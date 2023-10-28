package game;

import inputs.mouseAndKeyboard.KeyboardInputs;
import inputs.mouseAndKeyboard.MouseInputs;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel {
    public final Player player;
    private int frames = 0;
    private long lastChecked = 0;

    final BufferedImage image;

    final int alpha = 127;

    final int alpha3 = 180;
    Color[] blockColors = new Color[] {new Color(140, 46, 199, alpha), new Color(44, 22, 135, alpha), new Color(86, 97, 79, alpha3)};
    Color[] playerColors = new Color[] {Color.decode("#eb8d00"), Color.decode("#4f2b8f"), Color.decode("#324029")};

    public GamePanel(Player player) {
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(player));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        try {
            image  = ImageIO.read(new File("src/main/resources/images/background3.png"));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        this.player = player;

        Map.mapOffset = player.playerHeight;
    }


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(image, 0, 0, null);
        drawMap(g);
        drawPlayer(g);

        // displayFrames();
    }

    public void drawSpike(Graphics g, int mapBlockNumber) {

        int mapVerticalOffset = GameWindow.height - (Map.levelHeight + (Map.mapElementHeight) * (Map.mapList.get(mapBlockNumber)-1));
        int mapOffset = GameWindow.width * (player.getPlayerX() / GameWindow.width);

        int[] xCoordinates = new int[]{(mapBlockNumber) * Map.mapElementWidth - mapOffset, (mapBlockNumber+1) * Map.mapElementWidth - mapOffset, mapBlockNumber * Map.mapElementWidth + Map.mapElementWidth/2 - mapOffset};
        int[] yCoordinates = new int[]{mapVerticalOffset, mapVerticalOffset, mapVerticalOffset - Map.spikeHeight};

        g.fillPolygon(xCoordinates, yCoordinates, 3);
    }


    private void drawPlayer(Graphics g) {
        g.setColor(playerColors[2]);
        g.fillRect(player.getPlayerX() - player.getPlayerX() / GameWindow.width * GameWindow.width, player.getPlayerY(), player.getPlayerWidth(), player.getPlayerHeight());
        g.setColor(Color.black);
    }

    private void drawMap(Graphics g) {

        Map.mapOffset = (player.getPlayerX() / GameWindow.width * (GameWindow.width / Map.mapElementWidth));
        for (int i = 0; i < GameWindow.width/Map.mapElementWidth; i++) {
            if (Map.holePositionList.contains(i + Map.mapOffset)) {
                continue;
            }
            for (int j = -((GameWindow.height-Map.levelHeight)/Map.mapElementHeight); j < Map.mapList.get(i + Map.mapOffset); j++) {
                g.setColor(blockColors[2]);
                g.fillRect(
                        i * Map.mapElementWidth,
                        GameWindow.height - (Map.levelHeight + j * Map.mapElementHeight),
                        Map.mapElementWidth,
                        Map.mapElementHeight
                );
                g.setColor(Color.black);
                g.drawRect(
                        i * Map.mapElementWidth,
                        GameWindow.height - (Map.levelHeight + j * Map.mapElementHeight),
                        Map.mapElementWidth,
                        Map.mapElementHeight
                );
            }
        }

        for (int i : Map.spikePositionList) {
            if (Map.holePositionList.contains(i)) {
                continue;
            }
            drawSpike(g, i);
        }
    }

}