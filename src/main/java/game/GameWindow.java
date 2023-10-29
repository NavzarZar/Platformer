package game;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * The `GameWindow` class represents the main game window for displaying the game panel.
 */
public class GameWindow extends JFrame {
    public static final int width = 1440;
    public static final int height = 1080;

    /**
     * Constructs a new `GameWindow` with the specified game panel.
     *
     * @param gamePanel The game panel to be displayed within the window.
     */
    public GameWindow(GamePanel gamePanel) {
        // Create a new JFrame object with the specified dimensions.
        JFrame jframe = new JFrame();
        jframe.setSize(width, height);

        // Set the default close operation to exit when the frame is closed.
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add the game panel to the frame for rendering.
        jframe.add(gamePanel);

        // Center the window on the screen.
        jframe.setLocationRelativeTo(null);

        // Set the window to not be resizable.
        jframe.setResizable(false);

        // Make the window visible.
        jframe.setVisible(true);
    }
}
