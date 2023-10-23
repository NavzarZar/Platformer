package game;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import physics.Collision;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public final Player player;
    private int frames = 0;
    private long lastChecked = 0;

    public GamePanel(Player player) {
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(player));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        this.player = player;

        Map.mapOffset = player.playerHeight;
    }


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        drawMap(g);
        drawPlayer(g);

        // displayFrames();
    }

    public void drawSpike(Graphics g, int mapBlockNumber) {

        int mapOffset = GameWindow.height - (Map.levelHeight + (Map.mapElementHeight) * (Map.mapList.get(mapBlockNumber)-1));
        int[] xCoordinates = new int[]{(mapBlockNumber) * Map.mapElementWidth, (mapBlockNumber+1) * Map.mapElementWidth, mapBlockNumber * Map.mapElementWidth + Map.mapElementWidth/2};
        int[] yCoordinates = new int[]{mapOffset, mapOffset, mapOffset - Map.spikeHeight};

        g.fillPolygon(xCoordinates, yCoordinates, 3);
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
        g.setColor(Color.red);
        g.fillRect(player.getPlayerX() - player.getPlayerX() / GameWindow.width * GameWindow.width, player.getPlayerY(), player.getPlayerWidth(), player.getPlayerHeight());
        g.setColor(Color.black);
    }

    private void drawMap(Graphics g) {
        Map.mapOffset = (player.getPlayerX() / GameWindow.width * (GameWindow.width / Map.mapElementWidth));
        for (int i = 0; i < GameWindow.width/Map.mapElementWidth; i++) {
            for (int j = 0; j < Map.mapList.get(i + Map.mapOffset); j++) {
                g.drawRect(
                        i * Map.mapElementWidth,
                        GameWindow.height - (Map.levelHeight + j * Map.mapElementHeight),
                        Map.mapElementWidth,
                        Map.mapElementHeight
                );
            }
        }

        for (int i : Map.spikeList) {
            drawSpike(g, i);
        }
    }

}