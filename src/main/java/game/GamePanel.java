package game;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public Player player = new Player();
    int fallingSpeed = 1;
    int moveSpeed = 5;
    Map map;
    private int frames = 0;
    private long lastChecked = 0;

    public GamePanel() {
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        map = new Map();
    }

    public Map getMap() {
        return map;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        drawMap(g);
        player.setPlayerX(player.getPlayerX() + player.getPlayerVelocityX());
        player.makePlayerFall(map);
        drawPlayer(g);

        // displayFrames();
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

}