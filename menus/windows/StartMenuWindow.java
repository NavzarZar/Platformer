package menus.windows;

import menus.panels.StartMenuPanel;

import javax.swing.*;

/**
 * The StartMenuWindow class represents the window for the start menu.
 * It displays the StartMenuPanel within the window.
 */
public class StartMenuWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 480;

    /**
     * Constructs a new StartMenuWindow.
     *
     * @param startMenuPanel The StartMenuPanel to be displayed within the window.
     */
    public StartMenuWindow(StartMenuPanel startMenuPanel) {

        // Create a new JFrame object
        JFrame jframe = new JFrame();

        // Set the size of the window
        jframe.setSize(width, height);

        // Specify that the program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add the panel with the start menu inside the frame
        jframe.add(startMenuPanel);

        // Set the window to pop up in the center of the screen
        jframe.setLocationRelativeTo(null);

        // Make the frame non-resizable
        jframe.setResizable(false);

        // Make the frame visible
        jframe.setVisible(true);
    }
}
