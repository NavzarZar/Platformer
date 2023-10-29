package game;

import javax.swing.JFrame;

/**
 * The `GameWindow` class represents the main game
 * window for displaying the game panel.
 */
public class GameWindow extends JFrame {
    /**
     * Width of window.
     */
    public static final int WIDTH = 1440;

    /**
     * Height of window.
     */
    public static final int HEIGHT = 1080;

    /**
     * Constructs a new `GameWindow` with the specified game panel.
     *
     * @param gamePanel The game panel to be displayed within the window.
     */
    public GameWindow(final GamePanel gamePanel) {
        // Create a new JFrame object with the specified dimensions.
        JFrame jframe = new JFrame();
        jframe.setSize(WIDTH, HEIGHT);

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
