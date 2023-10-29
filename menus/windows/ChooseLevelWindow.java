package menus.windows;

import menus.panels.ChooseLevelPanel;

import javax.swing.*;

/**
 * The ChooseLevelWindow class represents the window for displaying the choose level screen.
 * It displays the ChooseLevelPanel within the window.
 */
public class ChooseLevelWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 420;

    /**
     * Constructs a new ChooseLevelWindow.
     *
     * @param chooseLevelPanel The ChooseLevelPanel to be displayed within the window.
     */
    public ChooseLevelWindow(ChooseLevelPanel chooseLevelPanel) {
        // Create a new JFrame object
        JFrame jframe = new JFrame();

        // Set the size of the window
        jframe.setSize(width, height);

        // Specify that the program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add the panel with the choose level screen inside the frame
        jframe.add(chooseLevelPanel);

        // Set the window to pop up in the center
        jframe.setLocationRelativeTo(null);

        // Make the frame non-resizable
        jframe.setResizable(false);

        // Make the frame visible
        jframe.setVisible(true);
    }
}
