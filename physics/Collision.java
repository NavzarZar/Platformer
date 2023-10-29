package physics;

import game.Game;
import game.GameWindow;
import game.Player;
import levels.Level;
import levels.LevelOne;
import levels.LevelThree;
import levels.LevelTwo;

import java.awt.Point;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 * The Collision class handles collision detection and response for the player character.
 */
public class Collision {

    private static Class<? extends Level> CurrentLevel;

    private static int mapOffset;
    private static int mapElementWidth;
    private static int mapElementHeight;
    private static int levelHeight;
    private static int spikeHeight;
    private static ArrayList<Integer> holePositionList;
    private static ArrayList<Integer> spikePositionList;
    private static ArrayList<Integer> mapList;

    static {
        setLevel(Game.getLevel());
    }

    /**
     * Checks for collision on the left side of the player character.
     *
     * @param player The player character
     * @return true if a collision is detected on the left side
     */
    public static boolean collisionLeft(final Player player) {
        if (player.getPlayerX() - player.getMoveSpeed() <= 0) {
            return true;
        }

        int playerXRelativeToMap = (player.getPlayerX() - player.getMoveSpeed() - 1) / mapElementWidth;
        int heightOfPlayerInBlocks;

        if (holePositionList.contains(playerXRelativeToMap)) {
            return false;
        }

        if (GameWindow.HEIGHT - (levelHeight + player.getPlayerY() + player.getPlayerHeight()) >= 0) {
            heightOfPlayerInBlocks = (GameWindow.HEIGHT - (levelHeight + player.getPlayerY() + player.getPlayerHeight())) / mapElementHeight;
        } else {
            heightOfPlayerInBlocks = (GameWindow.HEIGHT - (levelHeight + player.getPlayerY() + player.getPlayerHeight() + mapElementHeight)) / mapElementHeight;
        }

        int heightOfMapLeftOfPlayer = mapList.get((player.getPlayerX() - player.getMoveSpeed()) / mapElementWidth) - 1;

        return heightOfPlayerInBlocks < heightOfMapLeftOfPlayer;
    }

    /**
     * Checks for collision on the right side of the player character.
     *
     * @param player The player character
     * @return true if a collision is detected on the right side
     */
    public static boolean collisionRight(Player player) {
        int heightOfPlayerInBlocks;
        int playerXRelativeToMap = (player.getPlayerX() + player.getPlayerWidth() + player.getMoveSpeed()) / mapElementWidth;
        int heightOfMapRightOfPlayer = mapList.get(playerXRelativeToMap) - 1;

        if (holePositionList.contains(playerXRelativeToMap)) {
            return false;
        }

        if (GameWindow.HEIGHT - (levelHeight + player.getPlayerY() + player.getPlayerHeight()) >= 0) {
            heightOfPlayerInBlocks = (GameWindow.HEIGHT - (levelHeight + player.getPlayerY() + player.getPlayerHeight())) / mapElementHeight;
        } else {
            heightOfPlayerInBlocks = (GameWindow.HEIGHT - (levelHeight + player.getPlayerY() + player.getPlayerHeight() + mapElementHeight)) / mapElementHeight;
        }

        return heightOfPlayerInBlocks < heightOfMapRightOfPlayer;
    }

    /**
     * Checks for collision with spikes.
     *
     * @param player The player character
     * @return true if the player character collides with spikes
     */
    public static boolean collisionSpike(Player player) {
        int playerLeftX = player.getPlayerX();
        int playerLeftY = player.getPlayerY() + player.getPlayerHeight();

        int playerRightX = player.getPlayerX() + player.getPlayerWidth();
        int playerRightY = player.getPlayerY() + player.getPlayerHeight();

        for (int spike : spikePositionList) {

            int x1 = spike * mapElementWidth;
            int y1 = GameWindow.HEIGHT - (levelHeight + mapElementHeight * (mapList.get(spike) - 1));

            int x2 = x1 + mapElementWidth;

            int x3 = x1 + mapElementWidth / 2;
            int y3 = y1 - spikeHeight;

            if (playerIsInsideTriangle(x1, x2, x3, y1, y1, y3, playerLeftX, playerLeftY)
                    || playerIsInsideTriangle(x1, x2, x3, y1, y1, y3, playerRightX, playerRightY)) {
                return true;
            }
        }
        return false;
    }

    private static boolean playerIsInsideTriangle(final int x1, final int x2, final int x3,
                                                  final int y1, final int y2, final int y3, final int px, final int py) {
        float areaOrig = abs((x2 - x1) * (y3 - y1));

        float area1 = abs((x1 - px) * (y2 - py) - (x2 - px) * (y1 - py));
        float area2 = abs((x2 - px) * (y3 - py) - (x3 - px) * (y2 - py));
        float area3 = abs((x3 - px) * (y1 - py) - (x1 - px) * (y3 - py));

        return area1 + area2 + area3 <= areaOrig;
    }

    /**
     * Checks if there is a map block under the player character.
     *
     * @param player The player character
     * @return true if there is a map block under the player character
     */
    public static boolean mapBlockUnderPlayer(final Player player) {
        Point bottomRightCorner = new Point(player.getPlayerX()
                + player.getPlayerWidth() + 1, player.getPlayerY()
                + player.getPlayerHeight());

        if (holePositionList.contains((player.getPlayerX()) / mapElementWidth)
                && holePositionList.contains((player.getPlayerX()
                + player.getPlayerWidth() - 1) / mapElementWidth)) {
            return false;
        }

        int mapLeftCornerHighestY = GameWindow.HEIGHT - (levelHeight
                + mapElementHeight * (mapList.get((player.getPlayerX() + 1)
                / mapElementWidth) - 1));

        int mapRightCornerHighestY = GameWindow.HEIGHT - (levelHeight
                + mapElementHeight
                * (mapList.get((bottomRightCorner.x - 2)
                / mapElementWidth) - 1));

        boolean collisionOnLeftCorner = mapLeftCornerHighestY
                - (player.getPlayerY() + player.getPlayerHeight())
                < player.getFallingSpeed();
        boolean collisionOnRightCorner = mapRightCornerHighestY
                - bottomRightCorner.y < player.getFallingSpeed();

        if (holePositionList.contains((player.getPlayerX()
                + player.getPlayerWidth()) / mapElementWidth)) {
            return collisionOnLeftCorner;
        }
        if (holePositionList.contains((player.getPlayerX())
                / mapElementWidth)) {
            return collisionOnRightCorner;
        }
        return collisionOnLeftCorner
                || collisionOnRightCorner;
    }

    /**
     * Sets the current level.
     *
     * @param level The level number
     */
    public static void setLevel(int level) {
        CurrentLevel = switch (level) {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
