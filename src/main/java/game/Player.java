package game;

import physics.Collision;

public class Player {
    private int playerY = 500;
    private int playerX = 0;

    private boolean playerIsJumping = false;



    public int moveSpeed = 3;

    public double velocityX = 0;
    public double velocityY = 0;

    public final int jumpHeight = 100;
    public final int jumpSpeed = 2;
    public int distanceJumped = 0;
    public double fallingSpeed = 2;

    int playerWidth = 50;
    int playerHeight = 75;


    public int getPlayerWidth() {
        return playerWidth;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
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
        } else if (mapX - playerX <= moveSpeed) {
            this.setVelocityX(0);
        }
    }


    public void moveRight() {
        int mapX = (this.getPlayerX() / Map.mapElementWidth + 1) * (Map.mapElementWidth);

        if (playerX > GameWindow.width * (Map.mapList.size() / (GameWindow.width / Map.mapElementWidth))) {
            return;
        }

        if (!Collision.collisionRight(this)) {
            this.setPlayerX(this.getPlayerX() + moveSpeed);
            this.setVelocityX(moveSpeed);
        } else if (mapX - (playerX + playerWidth) <= moveSpeed) {
            this.setPlayerX(mapX - this.getPlayerWidth());
            this.setVelocityX(0);
        }

        if (playerX > GameWindow.width * (Map.mapList.size())) {
            this.setPlayerX(GameWindow.width - playerWidth);
        }
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public void makePlayerFall() {

        boolean playerHasBlockUnder = Collision.mapBlockUnderPlayer(this);

        if (!playerHasBlockUnder && !playerIsJumping) {
            velocityY = fallingSpeed;
        } else if (distanceJumped >= jumpHeight) {
            distanceJumped = 0;
            playerIsJumping = false;
        } else if (playerIsJumping) {
            velocityY = -jumpSpeed;
            distanceJumped += jumpSpeed;
        } else {
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

    public void setPlayerIsJumping(boolean playerIsJumping) {
        this.playerIsJumping = playerIsJumping;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }
}