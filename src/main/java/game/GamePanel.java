package game;

import inputs.mouseAndKeyboard.KeyboardInputs;
import inputs.mouseAndKeyboard.MouseInputs;
import levels.Level;
import levels.LevelOne;
import levels.LevelThree;
import levels.LevelTwo;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    public final Player player;
    private int frames = 0;
    private long lastChecked = 0;

    final BufferedImage image;

    int mapOffset;
    int mapElementWidth;
    int mapElementHeight;
    int levelHeight;
    int spikeHeight;
    ArrayList<Integer> holePositionList;
    ArrayList<Integer> spikePositionList;
    ArrayList<Integer> mapList;
    JLabel levelText = new JLabel("Level " + Game.getLevel(), SwingConstants.CENTER);

    final int alpha = 127;

    final int alpha3 = 180;
    Color[] blockColors = new Color[]{new Color(140, 46, 199, alpha), new Color(44, 22, 135, alpha), new Color(86, 97, 79, alpha3)};
    Color[] playerColors = new Color[]{Color.decode("#eb8d00"), Color.decode("#4f2b8f"), Color.decode("#324029")};

    public GamePanel(Player player) {
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(player));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        try {
            image = ImageIO.read(new File("src/main/resources/images/background" + Game.getLevel() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Class<? extends Level> CurrentLevel = switch (Game.getLevel()) {
            case 1 -> LevelOne.class;
            case 2 -> LevelTwo.class;
            case 3 -> LevelThree.class;
            default -> throw new IllegalStateException("Unexpected value: " + Game.getLevel());
        };


        try {
            Field field = CurrentLevel.getField("mapOffset");
            mapOffset = field.getInt(null);

            field = CurrentLevel.getField("mapElementWidth");
            mapElementWidth = field.getInt(null);

            field = CurrentLevel.getField("mapElementHeight");
            mapElementHeight = field.getInt(null);

            field = CurrentLevel.getField("levelHeight");
            levelHeight = field.getInt(null);

            field = CurrentLevel.getField("spikeHeight");
            spikeHeight = field.getInt(null);

            field = CurrentLevel.getField("holePositionList");
            holePositionList = (ArrayList<Integer>) field.get(null);

            field = CurrentLevel.getField("spikePositionList");
            spikePositionList = (ArrayList<Integer>) field.get(null);

            field = CurrentLevel.getField("mapList");
            mapList = (ArrayList<Integer>) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.player = player;
        levelText.setFont(new Font("Serif", Font.BOLD, 50));
        levelText.setForeground(Color.white);
        levelText.setBounds(0, 0, GameWindow.width, GameWindow.height);
        levelText.setVisible(true);

        this.add(levelText);

        mapOffset = player.playerHeight;
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

        int mapVerticalOffset = GameWindow.height - (levelHeight + (mapElementHeight) * (mapList.get(mapBlockNumber) - 1));
        int mapOffset = GameWindow.width * (player.getPlayerX() / GameWindow.width);

        int[] xCoordinates = new int[]{(mapBlockNumber) * mapElementWidth - mapOffset, (mapBlockNumber + 1) * mapElementWidth - mapOffset, mapBlockNumber * mapElementWidth + mapElementWidth / 2 - mapOffset};
        int[] yCoordinates = new int[]{mapVerticalOffset, mapVerticalOffset, mapVerticalOffset - spikeHeight};

        g.fillPolygon(xCoordinates, yCoordinates, 3);
    }


    private void drawPlayer(Graphics g) {
        g.setColor(playerColors[Game.getLevel() - 1]);
        g.fillRect(player.getPlayerX() - player.getPlayerX() / GameWindow.width * GameWindow.width, player.getPlayerY(), player.getPlayerWidth(), player.getPlayerHeight());
        g.setColor(Color.black);
    }

    private void drawMap(Graphics g) {

        mapOffset = (player.getPlayerX() / GameWindow.width * (GameWindow.width / mapElementWidth));
        for (int i = 0; i < GameWindow.width / mapElementWidth; i++) {
            if (holePositionList.contains(i + mapOffset)) {
                continue;
            }
            for (int j = -((GameWindow.height - levelHeight) / mapElementHeight); j < mapList.get(i + mapOffset); j++) {
                g.setColor(blockColors[Game.getLevel() - 1]);
                g.fillRect(
                        i * mapElementWidth,
                        GameWindow.height - (levelHeight + j * mapElementHeight),
                        mapElementWidth,
                        mapElementHeight
                );
                g.setColor(Color.black);
                g.drawRect(
                        i * mapElementWidth,
                        GameWindow.height - (levelHeight + j * mapElementHeight),
                        mapElementWidth,
                        mapElementHeight
                );
            }
        }

        for (int i : spikePositionList) {
            if (holePositionList.contains(i)) {
                continue;
            }
            drawSpike(g, i);
        }
    }

}