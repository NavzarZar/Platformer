package game;

import inputs.keyboard.KeyboardInputs;
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

/**
 * The `GamePanel` class represents the game's graphical panel for rendering the game world.
 */
public class GamePanel extends JPanel {
    public final Player player;

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
    Color[] playerColors = new Color[]{Color.decode("#6237b8"), Color.decode("#4f2b8f"), Color.decode("#324029")};

    /**
     * Constructs a new `GamePanel` for rendering the game world.
     *
     * @param player The player object to interact with.
     */
    public GamePanel(Player player) {
        // Register keyboard input for player control.
        addKeyListener(new KeyboardInputs(player));
        try {
            // Load the background image based on the current game level.
            image = ImageIO.read(new File("src/main/resources/images/background" + Game.getLevel() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Determine the current game level and its properties using reflection.
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

        // Create and configure the level text label.
        levelText.setFont(new Font("Serif", Font.BOLD, 50));
        levelText.setForeground(Color.white);
        levelText.setBounds(1000, 0, GameWindow.width, GameWindow.height);
        levelText.setVisible(true);

        this.add(levelText);

        // Initialize map offset.
        mapOffset = player.playerHeight;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(image, 0, 0, null);

        // Draw the game map and player.
        drawMap(g);
        drawPlayer(g);
    }

    public void drawSpike(Graphics g, int mapBlockNumber) {
        // Calculate spike coordinates and draw spikes.
        int mapVerticalOffset = GameWindow.height - (levelHeight + (mapElementHeight) * (mapList.get(mapBlockNumber) - 1));
        int mapOffset = GameWindow.width * (player.getPlayerX() / GameWindow.width);

        int[] xCoordinates = new int[]{(mapBlockNumber) * mapElementWidth - mapOffset, (mapBlockNumber + 1) * mapElementWidth - mapOffset, mapBlockNumber * mapElementWidth + mapElementWidth / 2 - mapOffset};
        int[] yCoordinates = new int[]{mapVerticalOffset, mapVerticalOffset, mapVerticalOffset - spikeHeight};

        g.fillPolygon(xCoordinates, yCoordinates, 3);
    }

    private void drawPlayer(Graphics g) {
        // Draw the player character.
        g.setColor(playerColors[Game.getLevel() - 1]);
        g.fillRect(player.getPlayerX() - player.getPlayerX() / GameWindow.width * GameWindow.width, player.getPlayerY(), player.getPlayerWidth(), player.getPlayerHeight());
        g.setColor(Color.black);
    }

    private void drawFlag(Graphics g, int x, int y) {
        // Draw a flag element.
        g.setColor(Color.black);
        g.fillRect(x, y, 5, 180);
        g.setColor(Color.red);
        g.fillRect(x-100, y, 100, 50);
    }

    private void drawMap(Graphics g) {
        // Calculate map offset based on the player's position.
        mapOffset = (player.getPlayerX() / GameWindow.width * (GameWindow.width / mapElementWidth));
        for (int i = 0; i < GameWindow.width / mapElementWidth; i++) {
            if (holePositionList.contains(i + mapOffset)) {
                continue;
            }
            for (int j = -((GameWindow.height - levelHeight) / mapElementHeight); j < mapList.get(i + mapOffset); j++) {
                if (player.getPlayerX() / GameWindow.width == 2) {
                    // Special logic for the flag area.
                    drawFlag(g, 18 * mapElementWidth-50, GameWindow.height - (levelHeight + mapList.get(53) * mapElementHeight + 100));
                    if (i == 15 || i == 16 || i == 17) {
                        if ((i + j) % 2 == 0) {
                            g.setColor(Color.black);
                        } else {
                            g.setColor(Color.white);
                        }
                        g.fillRect(i * mapElementWidth, GameWindow.height - (levelHeight + j * mapElementHeight), mapElementWidth, mapElementHeight);
                        g.setColor(Color.black);
                        g.drawRect(i * mapElementWidth, GameWindow.height - (levelHeight + j * mapElementHeight), mapElementWidth, mapElementHeight);
                        continue;
                    }
                }
                g.setColor(blockColors[Game.getLevel() - 1]);
                g.fillRect(i * mapElementWidth, GameWindow.height - (levelHeight + j * mapElementHeight), mapElementWidth, mapElementHeight);
                g.setColor(Color.black);
                g.drawRect(i * mapElementWidth, GameWindow.height - (levelHeight + j * mapElementHeight), mapElementWidth, mapElementHeight);
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
