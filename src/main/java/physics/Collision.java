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

        int heightOfPlayerInBlocks = (GameWindow.height - Map.levelHeight - player.getPlayerY() - player.getPlayerHeight()) / Map.mapElementHeight + 1;
        int heightOfMapLeftOfPlayer = Map.mapList.get((player.getPlayerX() - player.moveSpeed) / Map.mapElementWidth);

        return heightOfPlayerInBlocks < heightOfMapLeftOfPlayer;
    }

    public static boolean collisionRight(Player player) {
        int heightOfPlayerRespectiveToMap = (GameWindow.height - Map.levelHeight - player.getPlayerY() - player.getPlayerHeight()) / Map.mapElementHeight + 1;
        int heightOfMapRightOfPlayer = Map.mapList.get((player.getPlayerX() + player.getPlayerWidth() + player.moveSpeed) / Map.mapElementWidth);

//        System.out.println("Height of player: " + heightOfPlayerRespectiveToMap + " Height of map: " + heightOfMapRightOfPlayer);
        return heightOfPlayerRespectiveToMap < heightOfMapRightOfPlayer;
    }

    public static boolean mapBlockUnderPlayer(Player player) {
        Point bottomRightCorner = new Point(player.getPlayerX() + player.getPlayerWidth(), player.getPlayerY() + player.getPlayerHeight());

        return (GameWindow.height - (Map.levelHeight +
                Map.mapElementHeight *
                        (Map.mapList.get((player.getPlayerX()+1) / Map.mapElementWidth) - 1)) - (player.getPlayerY() + player.getPlayerHeight()) <= player.fallingSpeed
                || (GameWindow.height - (Map.levelHeight +
                Map.mapElementHeight *
                        (Map.mapList.get((bottomRightCorner.x - 1) / Map.mapElementWidth) - 1)) - bottomRightCorner.y < player.fallingSpeed));
    }
}
