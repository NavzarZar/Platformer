package menus.windows;

import menus.panels.GameOverPanel;

import javax.swing.*;

/**
 * The GameOverWindow class represents the window for displaying a game over screen.
 * It displays the GameOverPanel within the window.
 */
public class GameOverWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 480;

    /**
     * Constructs a new GameOverWindow.
     *
     * @param gameOverPanel The GameOverPanel to be displayed within the window.
     */
    public GameOverWindow(GameOverPanel gameOverPanel) {
        // Create a new JFrame object
        JFrame jframe = new JFrame();

        // Set the size of the window
        jframe.setSize(width, height);

        // Specify that the program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add the panel with the game over screen inside the frame
        jframe.add(gameOverPanel);

        // Set the window to pop up in the center of the screen
        jframe.setLocationRelativeTo(null);

        // Make the frame non-resizable
        jframe.setResizable(false);

        // Make the frame visible
        jframe.setVisible(true);
    }
}
