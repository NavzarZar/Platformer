package menus.windows;

import game.Game;
import menus.panels.PauseMenuPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The PauseMenuWindow class represents the window for the pause menu.
 * It displays the PauseMenuPanel within the window and provides functionality for handling pause events.
 */
public class PauseMenuWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 480;

    /**
     * Constructs a new PauseMenuWindow.
     *
     * @param pauseMenuPanel The PauseMenuPanel to be displayed within the window.
     */
    public PauseMenuWindow(PauseMenuPanel pauseMenuPanel) {
        // Create a new JFrame object
        JFrame jframe = new JFrame();

        // Set the size of the window
        jframe.setSize(width, height);

        // Specify that the program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add the panel with the pause menu inside the frame
        jframe.add(pauseMenuPanel);

        // Set the window to pop up in the center of the screen
        jframe.setLocationRelativeTo(null);

        // Make the frame non-resizable
        jframe.setResizable(false);

        // Make the frame visible
        jframe.setVisible(true);

        // Add a window listener to handle window closing
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Resume the game and dispose of the window when it is closed
                Game.setIsPaused(false);
                jframe.dispose();
            }
        });
    }
}
