package game;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

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

        Map.mapOffset = player.getPlayerX();
        drawMap(g);
//        player.setPlayerX((int) (player.getPlayerX() + player.getPlayerVelocityX()));
//        player.makePlayerFall(map);
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
        for (int i = 0; i < Map.mapList.size(); i++) {
            for (int j = 0; j < Map.mapList.get(i); j++) {
                g.drawRect(
                        i * Map.mapElementWidth,
                        GameWindow.height - (Map.levelHeight + j * Map.mapElementHeight),
                        Map.mapElementWidth,
                        Map.mapElementHeight
                );
            }
        }
    }

}