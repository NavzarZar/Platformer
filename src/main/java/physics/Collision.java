package physics;

import game.GameWindow;
import game.Map;
import game.Player;

import java.awt.*;

public class Collision {
    public static boolean collisionLeft(Player player, Map map) {
        if(player.getPlayerX() - player.moveSpeed <= 0) {
            return true;
        }

        int heightOfPlayerInBlocks = (GameWindow.height - Map.levelHeight - player.getPlayerY() - player.getPlayerHeight()) / map.getMapElementHeight() + 1;
        int heightOfMapLeftOfPlayer = map.getMapList().get((player.getPlayerX() - player.moveSpeed) / map.getMapElementWidth());

//        System.out.println("Height of player: " + heightOfPlayerInBlocks + "\nheight of map: " + heightOfMapLeftOfPlayer);
//        System.out.println(heightOfPlayerInBlocks < heightOfMapLeftOfPlayer);
        return heightOfPlayerInBlocks < heightOfMapLeftOfPlayer;
    }

    public static boolean collisionRight(Player player, Map map) {
        int heightOfPlayerRespectiveToMap = (GameWindow.height - Map.levelHeight - player.getPlayerY() - player.getPlayerHeight()) / map.getMapElementHeight() + 1;
        int heightOfMapRightOfPlayer = map.getMapList().get((player.getPlayerX() + player.getPlayerWidth() + player.moveSpeed) / map.getMapElementWidth());
//        System.out.println("Player height: " + heightOfPlayerRespectiveToMap + "\nMap height: " + heightOfMapRightOfPlayer);
        return heightOfPlayerRespectiveToMap < heightOfMapRightOfPlayer;
    }

    public static boolean mapBlockUnderPlayer(Map map, Player player) {
        Point bottomRightCorner = new Point(player.getPlayerX() + player.getPlayerWidth(), player.getPlayerY() + player.getPlayerHeight());
        return (player.getPlayerY() + player.getPlayerHeight() + player.fallingSpeed == GameWindow.height - (Map.levelHeight +
                map.getMapElementHeight() *
                        (map.getMapList().get(player.getPlayerX() / map.getMapElementWidth()) - 1)))
                || (bottomRightCorner.y + player.fallingSpeed == GameWindow.height - (Map.levelHeight +
                map.getMapElementHeight() *
                        (map.getMapList().get(bottomRightCorner.x / map.getMapElementWidth()) - 1)));
    }
}
