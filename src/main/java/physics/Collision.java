package physics;

import game.Game;
import game.GameWindow;
import game.Map;
import game.Player;
import levels.Level;
import levels.LevelOne;
import levels.LevelThree;
import levels.LevelTwo;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 *
 *
 */
public class Collision {

    static Class<? extends Level> CurrentLevel;

    static int mapOffset;
    static int mapElementWidth;
    static int mapElementHeight;
    static int levelHeight;
    static int spikeHeight;
    static ArrayList<Integer> holePositionList;
    static ArrayList<Integer> spikePositionList;
    static ArrayList<Integer> mapList;

    static {
        setLevel(Game.getLevel());
    }

    public static boolean collisionLeft(Player player) {
        if(player.getPlayerX() - player.moveSpeed <= 0) {
            return true;
        }

        int playerXRelativeToMap = (player.getPlayerX() - player.moveSpeed - 1) / mapElementWidth;
        int heightOfPlayerInBlocks;

        if (holePositionList.contains(playerXRelativeToMap)) {
            return false;
        }

        if (GameWindow.height - (levelHeight + player.getPlayerY() + player.getPlayerHeight()) >= 0) {
            heightOfPlayerInBlocks = (GameWindow.height - (levelHeight + player.getPlayerY() + player.getPlayerHeight())) / mapElementHeight;
        } else {
            heightOfPlayerInBlocks = (GameWindow.height - (levelHeight + player.getPlayerY() + player.getPlayerHeight() + mapElementHeight)) / mapElementHeight;
        }
        int heightOfMapLeftOfPlayer = mapList.get((player.getPlayerX() - player.moveSpeed) / mapElementWidth) - 1;

        return heightOfPlayerInBlocks < heightOfMapLeftOfPlayer;
    }

    public static boolean collisionRight(Player player) {
        int heightOfPlayerInBlocks;
        int playerXRelativeToMap = (player.getPlayerX() + player.getPlayerWidth() + player.moveSpeed) / mapElementWidth;
        int heightOfMapRightOfPlayer = mapList.get(playerXRelativeToMap) - 1;


        if (holePositionList.contains(playerXRelativeToMap)) {
            return false;
        }

        if (GameWindow.height - (levelHeight + player.getPlayerY() + player.getPlayerHeight()) >= 0) {
            heightOfPlayerInBlocks = (GameWindow.height - (levelHeight + player.getPlayerY() + player.getPlayerHeight())) / mapElementHeight;
        } else {
            heightOfPlayerInBlocks = (GameWindow.height - (levelHeight + player.getPlayerY() + player.getPlayerHeight() + mapElementHeight)) / mapElementHeight;
        }

        return heightOfPlayerInBlocks < heightOfMapRightOfPlayer;
    }

    public static boolean collisionSpike(Player player) {
        int playerLeftX = player.getPlayerX();
        int playerLeftY = player.getPlayerY() + player.getPlayerHeight();

        int playerRightX = player.getPlayerX() + player.getPlayerWidth();
        int playerRightY = player.getPlayerY() + player.getPlayerHeight();

        for (int spike : spikePositionList) {

            int x1 = spike * mapElementWidth;
            int y1 = GameWindow.height - (levelHeight + mapElementHeight * (mapList.get(spike)-1));

            int x2 = x1 + mapElementWidth;

            int x3 = x1 + mapElementWidth / 2;
            int y3 = y1 - spikeHeight;

            if (playerIsInsideTriangle(x1, x2, x3, y1, y1, y3, playerLeftX, playerLeftY) || playerIsInsideTriangle(x1, x2, x3, y1, y1, y3, playerRightX, playerRightY)) return true;

        }
        return false;
    }

    private static boolean playerIsInsideTriangle(int x1, int x2, int x3, int y1, int y2, int y3, int px,  int py) {
        float areaOrig = abs( (x2 - x1)*(y3 - y1));

        float area1 =    abs( (x1 - px)*(y2 - py) - (x2 - px)*(y1 - py) );
        float area2 =    abs( (x2 - px)*(y3 - py) - (x3 - px)*(y2 - py) );
        float area3 =    abs( (x3 - px)*(y1 - py) - (x1 - px)*(y3 - py) );


        return area1 + area2 + area3 <= areaOrig;
    }

    public static boolean mapBlockUnderPlayer(Player player) {
        Point bottomRightCorner = new Point(player.getPlayerX() + player.getPlayerWidth() + 1, player.getPlayerY() + player.getPlayerHeight());

        if (holePositionList.contains((player.getPlayerX()) / mapElementWidth) && holePositionList.contains((player.getPlayerX()+player.getPlayerWidth() - 1)/mapElementWidth)) {
            return false;
        }

        int mapLeftCornerHighestY = GameWindow.height - (levelHeight +
                mapElementHeight *
                        (mapList.get((player.getPlayerX()+1) / mapElementWidth) - 1));

        int mapRightCornerHighestY = GameWindow.height - (levelHeight +
                mapElementHeight *
                        (mapList.get((bottomRightCorner.x-2) / mapElementWidth) - 1));

        boolean collisionOnLeftCorner = mapLeftCornerHighestY - (player.getPlayerY() + player.getPlayerHeight()) < player.fallingSpeed;
        boolean collisionOnRightCorner = mapRightCornerHighestY - bottomRightCorner.y < player.fallingSpeed;

        if (holePositionList.contains((player.getPlayerX() + player.getPlayerWidth()) / mapElementWidth)) {
            return collisionOnLeftCorner;
        }
        if (holePositionList.contains((player.getPlayerX()) / mapElementWidth)) {
            return collisionOnRightCorner;
        }
        return collisionOnLeftCorner
                || collisionOnRightCorner;
    }

    public static void setLevel (int level){
        CurrentLevel  = switch (level) {
            case 1 -> LevelOne.class;
            case 2 -> LevelTwo.class;
            case 3 -> LevelThree.class;
            default -> throw new IllegalStateException("Unexpected value: " + Game.getLevel());
        };
        try {
            Field field = CurrentLevel.getField("mapOffset");
            mapOffset = field.getInt(null);

            field = CurrentLevel.getField("mapElementWidth");
            mapElementWidth = field.getInt(null);

            field = CurrentLevel.getField("mapElementHeight");
            mapElementHeight = field.getInt(null);

            field = CurrentLevel.getField("levelHeight");
            levelHeight = field.getInt(null);

            field = CurrentLevel.getField("spikeHeight");
            spikeHeight = field.getInt(null);

            field = CurrentLevel.getField("holePositionList");
            holePositionList = (ArrayList<Integer>) field.get(null);

            field = CurrentLevel.getField("spikePositionList");
            spikePositionList = (ArrayList<Integer>) field.get(null);

            field = CurrentLevel.getField("mapList");
            mapList = (ArrayList<Integer>) field.get(null);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
