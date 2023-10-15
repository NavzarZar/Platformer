package game;

import java.awt.*;

public class Player {
    int playerY = 50;
    int playerX = 50;

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


    public int getPlayerY() {
        return playerY;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerY(int playerY) {
        System.out.println("Setting player y to " + playerY);
        this.playerY = playerY;
    }

    public void setPlayerX(int playerX) {
        System.out.println("Setting player x to " + playerY);
        this.playerX = playerX;
    }
}