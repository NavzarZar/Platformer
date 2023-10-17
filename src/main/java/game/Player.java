package game;

import physics.Collision;

import java.awt.*;

public class Player {
    private int playerY = 500;
    private int playerX = 0;

    private boolean playerIsJumping = false;

    public int moveSpeed = 1;

    public double velocityX = 0;
    public double velocityY = 1;

    public double jumpVelocity = 1;

    int fallingSpeed = 1;

    int playerWidth = 50;
    int playerHeight = 50;


    public double getPlayerVelocityX() {
        return velocityX;
    }

    public double getPlayerVelocityY() {
        return velocityY;
    }


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

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public Point getPlayerPosition() {
        return new Point(playerX, playerY);
    }

    public void jump(Map map) {
        if (mapBlockUnderPlayer(map)) {
            playerIsJumping = true;
        }
    }

    public void moveLeft(Map map) {
        int mapX = (this.getPlayerX() / map.getMapElementWidth()) * (map.getMapElementWidth());
        if (!Collision.collisionLeft(this, map)) {
            this.setVelocityX(-moveSpeed);
            this.setPlayerX(this.getPlayerX() - moveSpeed);
        } else if(this.getPlayerX() - mapX <= moveSpeed) {
            this.setVelocityX(0);
            this.setPlayerX(0);
        }
    }

    public void moveRight(Map map) {
        int mapX = (this.getPlayerX() / map.getMapElementWidth() + 1) * (map.getMapElementWidth());
        if (!Collision.collisionRight(this, map)) {
            this.setPlayerX(this.getPlayerX() + moveSpeed);
            this.setVelocityX(moveSpeed);
        } else if (mapX - (playerX+playerWidth) <= moveSpeed) {
            this.setPlayerX(mapX - this.getPlayerWidth());
            this.setVelocityX(0);
        }
    }
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public void makePlayerFall(Map map) {
        if (!mapBlockUnderPlayer(map) && velocityY <= fallingSpeed && !playerIsJumping) {
            velocityY += 0.03;
        } else if (velocityY <= -jumpVelocity) {
            velocityY = fallingSpeed-0.2;
            playerIsJumping = false;
        }else if (playerIsJumping) {
            velocityY -= 0.01;
        }  else if(mapBlockUnderPlayer(map)) {
            velocityY = 0;
        }

        this.setPlayerY((int) (this.getPlayerY() + velocityY));
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


    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }
}