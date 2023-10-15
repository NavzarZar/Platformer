package game;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public Player player = new Player();
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

        player.setPlayerX(0);
        player.setPlayerY(0);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Draw map
        drawMap(g);
        makePlayerFall();
        drawPlayer(g);

        // displayFrames();
    }

    private void makePlayerFall() {
        if (!mapBlockUnderPlayer()) {
            player.setPlayerY(player.getPlayerY() + fallingSpeed);
        }
    }

    // Doesn't work if the map is not big enough, easy check to fix this though
    private boolean mapBlockUnderPlayer() {
        Point bottomRightCorner = new Point(player.getPlayerX() + player.getPlayerWidth(), player.getPlayerY() + player.getPlayerHeight());
        return (player.getPlayerY() + player.getPlayerHeight() + fallingSpeed == GameWindow.height - (Map.levelHeight +
                map.getMapElementHeight() *
                        (map.getMapList().get(player.getPlayerX() / map.getMapElementWidth()) - 1)))
                || (bottomRightCorner.y + fallingSpeed == GameWindow.height - (Map.levelHeight +
                map.getMapElementHeight() *
                        (map.getMapList().get(bottomRightCorner.x / map.getMapElementWidth()) - 1)));
    }

    private void displayFrames() {
        frames++;
        if (System.currentTimeMillis() - lastChecked >= 1000) {
            lastChecked = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
    }

    private void drawPlayer(Graphics g) {
        g.fillRect(player.getPlayerX(), player.getPlayerY(), player.getPlayerWidth(), player.getPlayerHeight());
    }

    private void drawMap(Graphics g) {
        for (int i = 0; i < map.getMapList().size(); i++) {
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

    private boolean collisionLeft() {
        return false;
    }

    private boolean collisionRight() {
        return false;
    }

    public void moveLeft() {
        if (!collisionLeft()) {
            player.setPlayerX(player.getPlayerX() - 1);
        }
    }

    public void moveRight() {
        if (!collisionRight())
            player.setPlayerX(player.getPlayerX() + 1);
    }

}