package game;

import physics.Collision;

import java.awt.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Player {
    private int playerY = 500;
    private int playerX = 0;

    private boolean playerIsJumping = false;
    private boolean movingLeft = false;
    private boolean hitSpike = false;
    private static boolean movingRight = false;

    public boolean getHasHitSpike() {
        return hitSpike;
    }

    public void setHasHitSpike(boolean hitSpike) {
        this.hitSpike = hitSpike;
    }



    public int moveSpeed = 1;

    public double velocityX = 0;
    public double velocityY = 0;

    public double jumpVelocity = 1;

    public double fallingSpeed = 1;

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

//        System.out.println(Collision.collisionLeft(this));
//
        if (!Collision.collisionLeft(this)) {
            this.setVelocityX(-moveSpeed);
            this.setPlayerX(this.getPlayerX() - moveSpeed);
        } else if(mapX - playerX <= moveSpeed) {
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
        } else if (mapX - (playerX+playerWidth) <= moveSpeed) {
            this.setPlayerX(mapX - this.getPlayerWidth());
            this.setVelocityX(0);
        }

        if (playerX > GameWindow.width*(Map.mapList.size())) {
            this.setPlayerX(GameWindow.width - playerWidth);
        }
    }
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public void makePlayerFall() {
//        int mapUnderLeftCorner = GameWindow.height - (Map.levelHeight +
//                Map.mapElementHeight *
//                        (Map.mapList.get(playerX / Map.mapElementWidth) - 1));
//
//        int mapUnderRightCorner = GameWindow.height - (Map.levelHeight +
//                Map.mapElementHeight *
//                        (Map.mapList.get((playerX + playerWidth) / Map.mapElementWidth) - 1));
//
//
//        int distanceLeftCornerToMap = mapUnderLeftCorner - (playerY + playerHeight) + 1;
//        int distanceRightCornerToMap = mapUnderRightCorner - (playerY + playerHeight) + 1;

//        System.out.println(distanceLeftCornerToMap + " " + distanceRightCornerToMap);
//        if (distanceLeftCornerToMap <= fallingSpeed
//                || distanceRightCornerToMap  <= fallingSpeed && distanceLeftCornerToMap > 0 && distanceRightCornerToMap > 0) {
////            System.out.println(min(mapUnderLeftCorner, mapUnderRightCorner) - (playerY+playerHeight));
//            playerY += min(mapUnderLeftCorner, mapUnderRightCorner) - (playerY+playerHeight);
//        }

        boolean playerHasBlockUnder = Collision.mapBlockUnderPlayer(this);

        if (!playerHasBlockUnder && velocityY <= fallingSpeed && !playerIsJumping) {
            velocityY += 0.4;
        } else if (velocityY <= -jumpVelocity) {
            velocityY = fallingSpeed - 0.01;
            playerIsJumping = false;
        }else if (playerIsJumping) {
            velocityY -= 0.01;
        }  else if(playerHasBlockUnder) {
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