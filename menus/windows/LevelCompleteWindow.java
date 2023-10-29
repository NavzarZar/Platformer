package menus.windows;

import menus.panels.LevelCompletePanel;

import javax.swing.*;

/**
 * The LevelCompleteWindow class represents the window for displaying a level completion screen.
 * It displays the LevelCompletePanel within the window.
 */
public class LevelCompleteWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 480;

    /**
     * Constructs a new LevelCompleteWindow.
     *
     * @param levelCompletePanel The LevelCompletePanel to be displayed within the window.
     */
    public LevelCompleteWindow(LevelCompletePanel levelCompletePanel) {
        // Create a new JFrame object
        JFrame jframe = new JFrame();

        // Set the size of the window
        jframe.setSize(width, height);

        // Specify that the program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add the panel with the level completion screen inside the frame
        jframe.add(levelCompletePanel);

        // Set the window to pop up in the center of the screen
        jframe.setLocationRelativeTo(null);

        // Make the frame non-resizable
        jframe.setResizable(false);

        // Make the frame visible
        jframe.setVisible(true);
    }
}
