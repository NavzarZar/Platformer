package game;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    private int playerX = 0, playerY = 0;
    private final int playerWidth = 50, playerHeight = 100;
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
            changePlayerY(1);
        }
    }

    private boolean mapBlockUnderPlayer() {
        Point bottomRightCorner = new Point(playerX+playerWidth, playerY + playerHeight);
        return (playerY + playerHeight == GameWindow.height - (Map.levelHeight +
                (map.getMapElementHeight()-1) * (map.getMapList().get(playerX/map.getMapElementWidth())-1)))
                || (bottomRightCorner.y == GameWindow.height - (Map.levelHeight +
                map.getMapElementHeight() * (map.getMapList().get(bottomRightCorner.x/map.getMapElementWidth())-1)));
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