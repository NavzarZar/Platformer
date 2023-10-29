package game;

import inputs.keyboard.KeyboardInputs;
import levels.Level;
import levels.LevelOne;
import levels.LevelThree;
import levels.LevelTwo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * The `GamePanel` class represents the game's graphical panel
 * for rendering the game world.
 */
public final class GamePanel extends JPanel {
    /**
     * The player character in the game.
     */
    private final Player player;

    /**
     * The background image of the game.
     */
    private final BufferedImage image;

    /**
     * The horizontal offset of the game map.
     */
    private int mapOffset;

    /**
     * The width of each map element.
     */
    private int mapElementWidth;

    /**
     * The height of each map element.
     */
    private int mapElementHeight;

    /**
     * The height of the level.
     */
    private int levelHeight;

    /**
     * The height of spikes in the game.
     */
    private int spikeHeight;

    /**
     * A list of positions where holes are located in the map.
     */
    private ArrayList<Integer> holePositionList;

    /**
     * A list of positions where spikes are located in the map.
     */
    private ArrayList<Integer> spikePositionList;

    /**
     * A list of map element heights that make up the level map.
     */
    private ArrayList<Integer> mapList;

    /**
     * The alpha value for some colors (transparency).
     */
    private final int alpha = 127;

    /**
     * A different alpha value for colors with transparency.
     */
    private final int alpha3 = 180;

    /**
     * An array of colors used for drawing different block elements.
     */
    private final Color[] blockColors =
            new Color[]{new Color(140, 46, 199, alpha),
                    new Color(44, 22, 135, alpha),
                    new Color(86, 97, 79, alpha3)};

    /**
     * An array of colors used for the player character.
     */
    private final Color[] playerColors =
            new Color[]{Color.decode("#6237b8"),
                    Color.decode("#4f2b8f"),
                    Color.decode("#324029")};

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
            image = ImageIO.read(
                    new File("src/main/resources/images/background"
                            + Game.getLevel() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Determine the current game level and its properties using reflection.
        Class<? extends Level> CurrentLevel = switch (Game.getLevel()) {
            case 1 -> LevelOne.class;
            case 2 -> LevelTwo.class;
            case 3 -> LevelThree.class;
            default -> throw new IllegalStateException(
                    "Unexpected value: " + Game.getLevel());
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
        JLabel levelText = new JLabel("Level " + Game.getLevel(),
                SwingConstants.CENTER);
        levelText.setFont(new Font("Serif", Font.BOLD, 50));
        levelText.setForeground(Color.white);
        levelText.setBounds(1000, 0, GameWindow.WIDTH, GameWindow.HEIGHT);
        levelText.setVisible(true);

        this.add(levelText);

        // Initialize map offset.
        mapOffset = player.getPlayerHeight();
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(image, 0, 0, null);

        // Draw the game map and player.
        drawMap(g);
        drawPlayer(g);
    }

    /**
     * Draws a spike element on the map.
     * @param g
     * @param mapBlockNumber
     */
    public void drawSpike(final Graphics g, final int mapBlockNumber) {
        // Calculate spike coordinates and draw spikes.
        int mapVerticalOffset = GameWindow.HEIGHT
                - (levelHeight + (mapElementHeight)
                        * (mapList.get(mapBlockNumber) - 1));
        int mapOffset = GameWindow.WIDTH
                * (player.getPlayerX() / GameWindow.WIDTH);

        int[] xCoordinates = new int[]{(mapBlockNumber)
                * mapElementWidth - mapOffset,
                (mapBlockNumber + 1) * mapElementWidth - mapOffset,
                mapBlockNumber * mapElementWidth
                        + mapElementWidth / 2 - mapOffset};
        int[] yCoordinates = new int[]{mapVerticalOffset, mapVerticalOffset,
                mapVerticalOffset - spikeHeight};

        g.fillPolygon(xCoordinates, yCoordinates, 3);
    }

    private void drawPlayer(final Graphics g) {
        // Draw the player character.
        g.setColor(playerColors[Game.getLevel() - 1]);
        g.fillRect(player.getPlayerX() - player.getPlayerX()
                / GameWindow.WIDTH * GameWindow.WIDTH, player.getPlayerY(),
                player.getPlayerWidth(), player.getPlayerHeight());
        g.setColor(Color.black);
    }

    private void drawFlag(final Graphics g, final int x, final int y) {
        // Draw a flag element.
        g.setColor(Color.black);
        g.fillRect(x, y, 5, 180);
        g.setColor(Color.red);
        g.fillRect(x - 100, y, 100, 50);
    }

    private void drawMap(final Graphics g) {
        // Calculate map offset based on the player's position.
        mapOffset = (player.getPlayerX() / GameWindow.WIDTH
                * (GameWindow.WIDTH / mapElementWidth));
        for (int i = 0; i < GameWindow.WIDTH / mapElementWidth; i++) {
            if (holePositionList.contains(i + mapOffset)) {
                continue;
            }
            for (int j = -((GameWindow.HEIGHT - levelHeight)
                    / mapElementHeight);
                 j < mapList.get(i + mapOffset); j++) {
                if (player.getPlayerX() / GameWindow.WIDTH == 2) {
                    // Special logic for the flag area.
                    drawFlag(g, 18 * mapElementWidth - 50,
                            GameWindow.HEIGHT - (levelHeight + mapList.get(53)
                                    * mapElementHeight + 100));
                    if (i == 15 || i == 16 || i == 17) {
                        if ((i + j) % 2 == 0) {
                            g.setColor(Color.black);
                        } else {
                            g.setColor(Color.white);
                        }
                        g.fillRect(i * mapElementWidth,
                                GameWindow.HEIGHT
                                        - (levelHeight + j * mapElementHeight),
                                mapElementWidth, mapElementHeight);
                        g.setColor(Color.black);
                        g.drawRect(i * mapElementWidth,
                                GameWindow.HEIGHT - (levelHeight
                                        + j * mapElementHeight),
                                mapElementWidth, mapElementHeight);
                        continue;
                    }
                }
                g.setColor(blockColors[Game.getLevel() - 1]);
                g.fillRect(i * mapElementWidth,
                        GameWindow.HEIGHT - (levelHeight
                                + j * mapElementHeight),
                        mapElementWidth, mapElementHeight);
                g.setColor(Color.black);
                g.drawRect(i * mapElementWidth,
                        GameWindow.HEIGHT - (levelHeight
                                + j * mapElementHeight),
                        mapElementWidth, mapElementHeight);
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
