package game;

import java.awt.*;

public class Player {
    int playerY = 50;
    int playerX = 50;

    int moveSpeed = 5;

    int playerWidth = 50;
    int playerHeight = 50;

    public int getPlayerWidth() {
        return playerWidth;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public void changePlayerPosition(Point point) {
        this.playerX = point.x;
        this.playerY = point.y;
    }

    public Point getPlayerPosition() {
        return new Point(playerX, playerY);
    }

    public boolean collisionLeft(Map map) {
        if(this.getPlayerX() - moveSpeed <= 0) {
            return true;
        }
        int heightOfPlayerRespectiveToMap = (GameWindow.height - Map.levelHeight - this.getPlayerY()) / map.getMapElementHeight() + 1;
        int heightOfMapLeftOfPlayer = map.getMapList().get((this.getPlayerX() - moveSpeed) / map.getMapElementWidth());

        return heightOfPlayerRespectiveToMap < heightOfMapLeftOfPlayer;
    }

    public boolean collisionRight(Map map) {
        int heightOfPlayerRespectiveToMap = (GameWindow.height - Map.levelHeight - this.getPlayerY()) / map.getMapElementHeight() + 1;
        int heightOfMapRightOfPlayer = map.getMapList().get((this.getPlayerX() + this.getPlayerWidth() + moveSpeed) / map.getMapElementWidth());
        return heightOfPlayerRespectiveToMap < heightOfMapRightOfPlayer;
    }

    public void moveLeft(Map map) {
        int mapX = (this.getPlayerX() / map.getMapElementWidth()) * (map.getMapElementWidth());
        if (!collisionLeft(map)) {
            this.setPlayerX(this.getPlayerX() - moveSpeed);
        } else if(this.getPlayerX() - mapX <= moveSpeed) {
            this.setPlayerX(mapX);
        }

    }

    public void moveRight(Map map) {
        int mapX = (this.getPlayerX() / map.getMapElementWidth() + 1) * (map.getMapElementWidth());
        System.out.println(playerX + playerWidth + " " + mapX);
        if (!collisionRight(map)) {
            this.setPlayerX(this.getPlayerX() + moveSpeed);
        } else if (mapX - (playerX+playerWidth) <= moveSpeed) {
            this.setPlayerX(mapX - this.getPlayerWidth());
        }
    }

    public int getPlayerY() {
        return playerY;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }
}