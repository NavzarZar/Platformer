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


}