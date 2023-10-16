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
        return (GameWindow.height - Map.levelHeight - this.getPlayerY()) / map.getMapElementHeight() <
                map.getMapList().get((this.getPlayerX() - moveSpeed) / map.getMapElementWidth());
    }

    public boolean collisionRight(Map map) {
        return (GameWindow.height - Map.levelHeight - this.getPlayerY()) / map.getMapElementHeight() <
                map.getMapList().get((this.getPlayerX() + this.getPlayerWidth() + moveSpeed) / map.getMapElementWidth());
    }

    public void moveLeft(Map map) {
        if (!collisionLeft(map)) {
            this.setPlayerX(this.getPlayerX() - moveSpeed);
        }
    }

    public void moveRight(Map map) {
        if (!collisionRight(map))
            this.setPlayerX(this.getPlayerX() + moveSpeed);
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