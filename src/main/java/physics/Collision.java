package physics;

import game.GameWindow;
import game.Map;
import game.Player;

import java.awt.*;

public class Collision {
    public static boolean collisionLeft(Player player) {
        if(player.getPlayerX() - player.moveSpeed <= 0) {
            return true;
        }

        int playerXRelativeToMap = (player.getPlayerX() - player.moveSpeed - 1) / Map.mapElementWidth;
        if (Map.holePositionList.contains(playerXRelativeToMap)) {
            return false;
        }

        int heightOfPlayerInBlocks = (GameWindow.height - Map.levelHeight - player.getPlayerY() - player.getPlayerHeight() - Map.mapElementHeight) / Map.mapElementHeight;
        int heightOfMapLeftOfPlayer = Map.mapList.get((player.getPlayerX() - player.moveSpeed) / Map.mapElementWidth) - 1;

        System.out.println("Height of player: " + heightOfPlayerInBlocks + " Height of map: " + heightOfMapLeftOfPlayer);

        return heightOfPlayerInBlocks < heightOfMapLeftOfPlayer;
    }

    public static boolean collisionRight(Player player) {
        int heightOfPlayerRespectiveToMap = (GameWindow.height - Map.levelHeight - player.getPlayerY() - player.getPlayerHeight()) / Map.mapElementHeight + 1;
        int playerXRelativeToMap = (player.getPlayerX() + player.getPlayerWidth() + player.moveSpeed) / Map.mapElementWidth;

        if (Map.holePositionList.contains(playerXRelativeToMap)) {
            return false;
        }
        int heightOfMapRightOfPlayer = Map.mapList.get(playerXRelativeToMap);

//        System.out.println("Height of player: " + heightOfPlayerRespectiveToMap + " Height of map: " + heightOfMapRightOfPlayer);
        return heightOfPlayerRespectiveToMap < heightOfMapRightOfPlayer;
    }


    public static boolean collisionSpikeRight(Player player) {
        int playerRightXRelativeToMap = (player.getPlayerX() + player.getPlayerWidth() - 1) / Map.mapElementWidth;

        if (Map.holePositionList.contains(playerRightXRelativeToMap)) {
            return false;
        }

        int spikeHeightRelativeToMap = GameWindow.height -
                (Map.levelHeight + Map.mapElementHeight * (Map.mapList.get(playerRightXRelativeToMap)-1));

        if (Map.spikePositionList.contains(playerRightXRelativeToMap) && player.getPlayerY() + player.getPlayerHeight() <= spikeHeightRelativeToMap
                && player.getPlayerY() + player.getPlayerHeight() >= spikeHeightRelativeToMap - Map.spikeHeight) {
            if (player.getPlayerY() + player.getPlayerHeight() > spikeHeightRelativeToMap - Map.spikeHeight/2) {
                return true;
            } else {
                return (player.getPlayerX() + player.getPlayerWidth()) % Map.mapElementWidth >= Map.mapElementWidth / 3;
            }
        }
        return false;
    }

    public static boolean collisionSpikeLeft(Player player) {
        int playerXRelativeToMap = (player.getPlayerX() + 1) / Map.mapElementWidth;
        if (Map.holePositionList.contains(playerXRelativeToMap)) {
            return false;
        }
        int spikeHeightRelativeToMap = GameWindow.height -
                (Map.levelHeight + Map.mapElementHeight * (Map.mapList.get(playerXRelativeToMap)-1));
        if (Map.spikePositionList.contains(playerXRelativeToMap) && player.getPlayerY() + player.getPlayerHeight() <= spikeHeightRelativeToMap
                && player.getPlayerY() + player.getPlayerHeight() >= spikeHeightRelativeToMap - Map.spikeHeight) {
            if (player.getPlayerY() + player.getPlayerHeight() > spikeHeightRelativeToMap - Map.spikeHeight/2) {
                return true;
            } else {
                return player.getPlayerX() % Map.mapElementWidth <= Map.mapElementWidth * 2 / 3;
            }
        }
        return false;
    }

    public static boolean collisionSpike(Player player) {
        return Collision.collisionSpikeLeft(player) || Collision.collisionSpikeRight(player);
    }

    public static boolean mapBlockUnderPlayer(Player player) {
        Point bottomRightCorner = new Point(player.getPlayerX() + player.getPlayerWidth(), player.getPlayerY() + player.getPlayerHeight());
        if (Map.holePositionList.contains(player.getPlayerX() / Map.mapElementWidth) && Map.holePositionList.contains((player.getPlayerX()+player.getPlayerWidth())/Map.mapElementWidth)) {
            return false;
        }
        return (GameWindow.height - (Map.levelHeight +
                Map.mapElementHeight *
                        (Map.mapList.get((player.getPlayerX()+1) / Map.mapElementWidth) - 1)) - (player.getPlayerY() + player.getPlayerHeight()) <= player.fallingSpeed
                || (GameWindow.height - (Map.levelHeight +
                Map.mapElementHeight *
                        (Map.mapList.get((bottomRightCorner.x - 1) / Map.mapElementWidth) - 1)) - bottomRightCorner.y < player.fallingSpeed));
    }
}
