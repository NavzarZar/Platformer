package physics;

import game.GameWindow;
import game.Map;
import game.Player;

import java.awt.*;

import static java.lang.Math.abs;

public class Collision {
    public static boolean collisionLeft(Player player) {
        if(player.getPlayerX() - player.moveSpeed <= 0) {
            return true;
        }

        int playerXRelativeToMap = (player.getPlayerX() - player.moveSpeed - 1) / Map.mapElementWidth;
        int heightOfPlayerInBlocks;

        if (Map.holePositionList.contains(playerXRelativeToMap)) {
            return false;
        }

        if (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight()) >= 0) {
            heightOfPlayerInBlocks = (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight())) / Map.mapElementHeight;
        } else {
            heightOfPlayerInBlocks = (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight() + Map.mapElementHeight)) / Map.mapElementHeight;
        }
        int heightOfMapLeftOfPlayer = Map.mapList.get((player.getPlayerX() - player.moveSpeed) / Map.mapElementWidth) - 1;

        return heightOfPlayerInBlocks < heightOfMapLeftOfPlayer;
    }

    public static boolean collisionRight(Player player) {
        int heightOfPlayerInBlocks;
        int playerXRelativeToMap = (player.getPlayerX() + player.getPlayerWidth() + player.moveSpeed) / Map.mapElementWidth;
        int heightOfMapRightOfPlayer = Map.mapList.get(playerXRelativeToMap) - 1;


        if (Map.holePositionList.contains(playerXRelativeToMap)) {
            return false;
        }

        if (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight()) >= 0) {
            heightOfPlayerInBlocks = (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight())) / Map.mapElementHeight;
        } else {
            heightOfPlayerInBlocks = (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight() + Map.mapElementHeight)) / Map.mapElementHeight;
        }

        return heightOfPlayerInBlocks < heightOfMapRightOfPlayer;
    }

    public static boolean collisionSpike(Player player) {
        int playerLeftX = player.getPlayerX();
        int playerLeftY = player.getPlayerY() + player.getPlayerHeight();

        int playerRightX = player.getPlayerX() + player.getPlayerWidth();
        int playerRightY = player.getPlayerY() + player.getPlayerHeight();

        for (int spike : Map.spikePositionList) {

            int x1 = spike * Map.mapElementWidth;
            int y1 = GameWindow.height - (Map.levelHeight + Map.mapElementHeight * (Map.mapList.get(spike)-1));

            int x2 = x1 + Map.mapElementWidth;

            int x3 = x1 + Map.mapElementWidth / 2;
            int y3 = y1 - Map.spikeHeight;

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

        if (Map.holePositionList.contains((player.getPlayerX()) / Map.mapElementWidth) && Map.holePositionList.contains((player.getPlayerX()+player.getPlayerWidth() - 1)/Map.mapElementWidth)) {
            return false;
        }

        int mapLeftCornerHighestY = GameWindow.height - (Map.levelHeight +
                Map.mapElementHeight *
                        (Map.mapList.get((player.getPlayerX()+1) / Map.mapElementWidth) - 1));

        int mapRightCornerHighestY = GameWindow.height - (Map.levelHeight +
                Map.mapElementHeight *
                        (Map.mapList.get((bottomRightCorner.x-2) / Map.mapElementWidth) - 1));

        boolean collisionOnLeftCorner = mapLeftCornerHighestY - (player.getPlayerY() + player.getPlayerHeight()) < player.fallingSpeed;
        boolean collisionOnRightCorner = mapRightCornerHighestY - bottomRightCorner.y < player.fallingSpeed;

        if (Map.holePositionList.contains((player.getPlayerX() + player.getPlayerWidth()) / Map.mapElementWidth)) {
            return collisionOnLeftCorner;
        }
        if (Map.holePositionList.contains((player.getPlayerX()) / Map.mapElementWidth)) {
            return collisionOnRightCorner;
        }
        return collisionOnLeftCorner
                || collisionOnRightCorner;
    }
}
