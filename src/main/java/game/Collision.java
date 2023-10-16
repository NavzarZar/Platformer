package game;

public class Collision {
    public static boolean collisionLeft(Player player, Map map) {
        if(player.getPlayerX() - player.moveSpeed <= 0) {
            return true;
        }
        int heightOfPlayerRespectiveToMap = (GameWindow.height - Map.levelHeight - player.getPlayerY()) / map.getMapElementHeight() + 1;
        int heightOfMapLeftOfPlayer = map.getMapList().get((player.getPlayerX() - player.moveSpeed) / map.getMapElementWidth());

        return heightOfPlayerRespectiveToMap < heightOfMapLeftOfPlayer;
    }

    public static boolean collisionRight(Player player, Map map) {
        int heightOfPlayerRespectiveToMap = (GameWindow.height - Map.levelHeight - player.getPlayerY()) / map.getMapElementHeight() + 1;
        int heightOfMapRightOfPlayer = map.getMapList().get((player.getPlayerX() + player.getPlayerWidth() + player.moveSpeed) / map.getMapElementWidth());
        return heightOfPlayerRespectiveToMap < heightOfMapRightOfPlayer;
    }
}
