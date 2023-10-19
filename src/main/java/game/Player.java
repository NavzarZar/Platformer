package game;

import physics.Collision;

import java.awt.*;

public class Player {
    private int playerY = 500;
    private int playerX = 0;

    private boolean playerIsJumping = false;
    private boolean movingLeft = false;
    private static boolean movingRight = false;



    public int moveSpeed = 1;

    public double velocityX = 0;
    public double velocityY = 1;

    public double jumpVelocity = 1;

    public int fallingSpeed = 1;

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

    public void jump() {
        if (Collision.mapBlockUnderPlayer(this)) {
            playerIsJumping = true;
        }
    }

    public void moveLeft() {
        int mapX = (this.getPlayerX() / Map.mapElementWidth) * (Map.mapElementWidth);
        if (!Collision.collisionLeft(this)) {
            this.setVelocityX(-moveSpeed);
            this.setPlayerX(this.getPlayerX() - moveSpeed);
        } else if(mapX - playerX <= moveSpeed) {
            this.setVelocityX(0);
        }
    }

    public void moveRight() {
        int mapX = (this.getPlayerX() / Map.mapElementWidth + 1) * (Map.mapElementWidth);
        if (!Collision.collisionRight(this)) {
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

    public void makePlayerFall() {
        if (!Collision.mapBlockUnderPlayer(this) && velocityY <= fallingSpeed && !playerIsJumping) {
            velocityY += 0.03;
        } else if (velocityY <= -jumpVelocity) {
            velocityY = fallingSpeed-0.2;
            playerIsJumping = false;
        }else if (playerIsJumping) {
            velocityY -= 0.01;
        }  else if(Collision.mapBlockUnderPlayer(this)) {
            velocityY = 0;
        }

        this.setPlayerY((int) (this.getPlayerY() + velocityY));
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