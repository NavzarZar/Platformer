package menus.windows;

import game.Game;
import menus.panels.ControlsPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The ControlsWindow class represents the window for displaying the game controls screen.
 * It displays the ControlsPanel within the window.
 */
public class ControlsWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 420;

    /**
     * Constructs a new ControlsWindow.
     *
     * @param controlsPanel The ControlsPanel to be displayed within the window.
     */
    public ControlsWindow(ControlsPanel controlsPanel) {
        // Create a new JFrame object
        JFrame jframe = new JFrame();

        // Set the size of the window
        jframe.setSize(width, height);

        // Specify that the program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add the panel with the game controls screen inside the frame
        jframe.add(controlsPanel);

        // Set the window to pop up in the center
        jframe.setLocationRelativeTo(null);

        // Make the frame visible
        jframe.setVisible(true);

        // Make the frame non-resizable
        jframe.setResizable(false);
    }
}
