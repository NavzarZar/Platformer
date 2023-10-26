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


        //
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

        System.out.println(heightOfPlayerInBlocks + " " + heightOfMapLeftOfPlayer);
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


    public static boolean collisionSpikeRight(Player player) {
        int playerRightXRelativeToMap = (player.getPlayerX() + player.getPlayerWidth()) / Map.mapElementWidth;

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
        Point bottomRightCorner = new Point(player.getPlayerX() + player.getPlayerWidth() + 1, player.getPlayerY() + player.getPlayerHeight());

        if (Map.holePositionList.contains((player.getPlayerX()) / Map.mapElementWidth) && Map.holePositionList.contains((player.getPlayerX()+player.getPlayerWidth() - 1)/Map.mapElementWidth)) {
            return false;
        }


//        System.out.println(GameWindow.height
//                - (Map.levelHeight +
//                Map.mapElementHeight *
//                        (Map.mapList.get((bottomRightCorner.x) / Map.mapElementWidth) - 1)) - bottomRightCorner.y < player.fallingSpeed);

//        System.out.println(GameWindow.height
//                - (Map.levelHeight +
//                Map.mapElementHeight *
//                        (Map.mapList.get((bottomRightCorner.x) / Map.mapElementWidth) - 1)));

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
