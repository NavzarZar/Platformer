package physics;

import game.GameWindow;
import game.Map;
import game.Player;

import java.awt.*;

import static java.lang.Math.abs;

public class Collision {
    public static boolean collisionLeft(Player player) {
        if(player.getPlayerX() - player.moveSpeed <= 0) {
            return true;
        }


        //
        int playerXRelativeToMap = (player.getPlayerX() - player.moveSpeed - 1) / Map.mapElementWidth;
        int heightOfPlayerInBlocks;

        if (Map.holePositionList.contains(playerXRelativeToMap)) {
            return false;
        }

        if (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight()) >= 0) {
            heightOfPlayerInBlocks = (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight())) / Map.mapElementHeight;
        } else {
            heightOfPlayerInBlocks = (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight() + Map.mapElementHeight)) / Map.mapElementHeight;
        }
        int heightOfMapLeftOfPlayer = Map.mapList.get((player.getPlayerX() - player.moveSpeed) / Map.mapElementWidth) - 1;

        System.out.println(heightOfPlayerInBlocks + " " + heightOfMapLeftOfPlayer);
        return heightOfPlayerInBlocks < heightOfMapLeftOfPlayer;
    }

    public static boolean collisionRight(Player player) {
        int heightOfPlayerInBlocks;
        int playerXRelativeToMap = (player.getPlayerX() + player.getPlayerWidth() + player.moveSpeed) / Map.mapElementWidth;
        int heightOfMapRightOfPlayer = Map.mapList.get(playerXRelativeToMap) - 1;


        if (Map.holePositionList.contains(playerXRelativeToMap)) {
            return false;
        }

        if (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight()) >= 0) {
            heightOfPlayerInBlocks = (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight())) / Map.mapElementHeight;
        } else {
            heightOfPlayerInBlocks = (GameWindow.height - (Map.levelHeight + player.getPlayerY() + player.getPlayerHeight() + Map.mapElementHeight)) / Map.mapElementHeight;
        }


        return heightOfPlayerInBlocks < heightOfMapRightOfPlayer;
    }

    public static boolean collisionSpikeLeft(Player player) {
        int px = player.getPlayerX();
        int py= player.getPlayerY() + player.getPlayerHeight();

        for (int spike : Map.spikePositionList) {
            System.out.println(spike);

            int x1 = spike * Map.mapElementWidth;
            int y1 = GameWindow.height - (Map.levelHeight + Map.mapElementHeight * (Map.mapList.get(spike)-1));

            int x2 = x1 + Map.mapElementWidth;
            int y2 = y1;

            int x3 = x1 + Map.mapElementWidth / 2;
            int y3 = y1 - Map.spikeHeight;

            System.out.println("Point1: " + (x1) + " " + (y1) + "\nPoint2: " + x2 + " " + y2 + "\nPoint3: " + x3 + " " + y3);

            // get the area of the triangle
            float areaOrig = abs( (x2-x1)*(y3-y1) - (x3-x1)*(y2-y1) );

            // get the area of 3 triangles made between the point
            // and the corners of the triangle
            float area1 =    abs( (x1-px)*(y2-py) - (x2-px)*(y1-py) );
            float area2 =    abs( (x2-px)*(y3-py) - (x3-px)*(y2-py) );
            float area3 =    abs( (x3-px)*(y1-py) - (x1-px)*(y3-py) );

            // if the sum of the three areas equals the original,
            // we're inside the triangle!
            System.out.println((area1 + area2 + area3) + " " + areaOrig);

            if (area1 + area2 + area3 <= areaOrig) {
                return true;
            }
        }

        return false;
    }


    public static boolean collisionSpikeRight(Player player) {
        int px = player.getPlayerX() + player.getPlayerWidth();
        int py= player.getPlayerY() + player.getPlayerHeight();

        for (int spike : Map.spikePositionList) {
            System.out.println(spike);

            int x1 = spike * Map.mapElementWidth;
            int y1 = GameWindow.height - (Map.levelHeight + Map.mapElementHeight * (Map.mapList.get(spike)-1));

            int x2 = x1 + Map.mapElementWidth;
            int y2 = y1;

            int x3 = x1 + Map.mapElementWidth / 2;
            int y3 = y1 - Map.spikeHeight;


            // get the area of the triangle
            float areaOrig = abs( (x2-x1)*(y3-y1) - (x3-x1)*(y2-y1) );

            // get the area of 3 triangles made between the point
            // and the corners of the triangle
            float area1 =    abs( (x1-px)*(y2-py) - (x2-px)*(y1-py) );
            float area2 =    abs( (x2-px)*(y3-py) - (x3-px)*(y2-py) );
            float area3 =    abs( (x3-px)*(y1-py) - (x1-px)*(y3-py) );

            // if the sum of the three areas equals the original,
            // we're inside the triangle!
            System.out.println((area1 + area2 + area3) + " " + areaOrig);

            if (area1 + area2 + area3 <= areaOrig) {
                return true;
            }
        }

        return false;
    }
    public static boolean collisionSpike(Player player) {
        return Collision.collisionSpikeLeft(player) || Collision.collisionSpikeRight(player);
    }

    public static boolean mapBlockUnderPlayer(Player player) {
        Point bottomRightCorner = new Point(player.getPlayerX() + player.getPlayerWidth() + 1, player.getPlayerY() + player.getPlayerHeight());

        if (Map.holePositionList.contains((player.getPlayerX()) / Map.mapElementWidth) && Map.holePositionList.contains((player.getPlayerX()+player.getPlayerWidth() - 1)/Map.mapElementWidth)) {
            return false;
        }

        int mapLeftCornerHighestY = GameWindow.height - (Map.levelHeight +
                Map.mapElementHeight *
                        (Map.mapList.get((player.getPlayerX()+1) / Map.mapElementWidth) - 1));

        int mapRightCornerHighestY = GameWindow.height - (Map.levelHeight +
                Map.mapElementHeight *
                        (Map.mapList.get((bottomRightCorner.x-2) / Map.mapElementWidth) - 1));

        boolean collisionOnLeftCorner = mapLeftCornerHighestY - (player.getPlayerY() + player.getPlayerHeight()) < player.fallingSpeed;
        boolean collisionOnRightCorner = mapRightCornerHighestY - bottomRightCorner.y < player.fallingSpeed;

        if (Map.holePositionList.contains((player.getPlayerX() + player.getPlayerWidth()) / Map.mapElementWidth)) {
            return collisionOnLeftCorner;
        }
        if (Map.holePositionList.contains((player.getPlayerX()) / Map.mapElementWidth)) {
            return collisionOnRightCorner;
        }
        return collisionOnLeftCorner
                || collisionOnRightCorner;
    }
}
