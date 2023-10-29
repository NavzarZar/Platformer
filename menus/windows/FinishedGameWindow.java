package menus.windows;

import menus.panels.FinishedGamePanel;

import javax.swing.*;

/**
 * The FinishedGameWindow class represents the window for displaying a finished game screen.
 * It displays the FinishedGamePanel within the window.
 */
public class FinishedGameWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 420;

    /**
     * Constructs a new FinishedGameWindow.
     *
     * @param finishedGamePanel The FinishedGamePanel to be displayed within the window.
     */
    public FinishedGameWindow(FinishedGamePanel finishedGamePanel) {
        // Create a new JFrame object
        JFrame jframe = new JFrame();

        // Set the size of the window
        jframe.setSize(width, height);

        // Specify that the program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add the panel with the finished game screen inside the frame
        jframe.add(finishedGamePanel);

        // Set the window to pop up in the center
        jframe.setLocationRelativeTo(null);

        // Make the frame non-resizable
        jframe.setResizable(false);

        // Make the frame visible
        jframe.setVisible(true);
    }
}
