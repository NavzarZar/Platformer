package game;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    Player player = new Player();
    private int playerX = player.getPlayerPosition().x;
    private int playerY = player.getPlayerPosition().y;

    private final int playerWidth = player.getPlayerWidth();
    private final int playerHeight = player.getPlayerHeight();
    int fallingSpeed = 1;
    Map map;
    private int frames = 0;
    private long lastChecked = 0;

    public GamePanel() {
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        map = new Map();

        this.playerX = 0;
        this.playerY = 0;
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        // Draw map
        drawMap(g);
        makePlayerFall();
        drawPlayer(g);

        // displayFrames();
    }

    private void makePlayerFall() {
        if (!mapBlockUnderPlayer()) {
           changePlayerY(fallingSpeed);
        }
    }

    // Doesn't work if the map is not big enough, easy check to fix this though
    private boolean mapBlockUnderPlayer() {
        Point bottomRightCorner = new Point(playerX+playerWidth, playerY + playerHeight);
        return (playerY + playerHeight + fallingSpeed == GameWindow.height - (Map.levelHeight +
                map.getMapElementHeight() *
                        (map.getMapList().get(playerX/map.getMapElementWidth()) - 1)))
                || (bottomRightCorner.y + fallingSpeed == GameWindow.height - (Map.levelHeight +
                map.getMapElementHeight() *
                        (map.getMapList().get(bottomRightCorner.x/map.getMapElementWidth()) - 1)));
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public int getPlayerWidth() {
        return playerWidth;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public void changePlayerX(int value){
        this.playerX += value;
    }

    public void changePlayerY(int value){
        this.playerY += value;

    }
    public void drawRect(int x, int y)
    {
        this.playerX = x;
        this.playerY = y;
    }


    private void displayFrames() {
        frames++;
        if(System.currentTimeMillis() - lastChecked >= 1000) {
            lastChecked = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
    }

    private void drawPlayer(Graphics g) {
        g.fillRect(playerX, playerY, playerWidth, playerHeight);
    }

    private void drawMap(Graphics g) {
        for(int i = 0; i < map.getMapList().size(); i++) {
            for (int j = 0; j < map.getMapList().get(i); j++) {
                g.drawRect(
                        i * map.getMapElementWidth(),
                        GameWindow.height - (Map.levelHeight + j * map.getMapElementHeight()),
                        map.getMapElementWidth(),
                        map.getMapElementHeight()
                );
            }
        }
    }
}