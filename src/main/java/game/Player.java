package game;

import java.awt.*;

public class Player {
    int playerY = 50;
    int playerX = 50;

    int moveSpeed = 5;
    int fallingSpeed = 1;

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

    public void moveLeft(Map map) {
        int mapX = (this.getPlayerX() / map.getMapElementWidth()) * (map.getMapElementWidth());
        if (!Collision.collisionLeft(this, map)) {
            this.setPlayerX(this.getPlayerX() - moveSpeed);
        } else if(this.getPlayerX() - mapX <= moveSpeed) {
            this.setPlayerX(mapX);
        }
    }

    public void moveRight(Map map) {
        int mapX = (this.getPlayerX() / map.getMapElementWidth() + 1) * (map.getMapElementWidth());
        if (!Collision.collisionRight(this, map)) {
            this.setPlayerX(this.getPlayerX() + moveSpeed);
        } else if (mapX - (playerX+playerWidth) <= moveSpeed) {
            this.setPlayerX(mapX - this.getPlayerWidth());
        }
    }

    public void makePlayerFall(Map map) {
        if (!mapBlockUnderPlayer(map)) {
            this.setPlayerY(this.getPlayerY() + fallingSpeed);
        }
    }

    private boolean mapBlockUnderPlayer(Map map) {
        Point bottomRightCorner = new Point(this.getPlayerX() + this.getPlayerWidth(), this.getPlayerY() + this.getPlayerHeight());
        return (this.getPlayerY() + this.getPlayerHeight() + fallingSpeed == GameWindow.height - (Map.levelHeight +
                map.getMapElementHeight() *
                        (map.getMapList().get(this.getPlayerX() / map.getMapElementWidth()) - 1)))
                || (bottomRightCorner.y + fallingSpeed == GameWindow.height - (Map.levelHeight +
                map.getMapElementHeight() *
                        (map.getMapList().get(bottomRightCorner.x / map.getMapElementWidth()) - 1)));
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