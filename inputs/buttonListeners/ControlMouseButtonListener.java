package inputs.buttonListeners;

import game.Game;
import game.GameWindow;
import menus.GameMenu;
import menus.panels.ControlsPanel;
import menus.panels.StartMenuPanel;
import menus.windows.ControlsWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

/**
 * The `ControlMouseButtonListener` class handles button click events on the ControlsPanel.
 */
public class ControlMouseButtonListener implements ActionListener {
    private final ControlsPanel controlsPanel;

    /**
     * Constructs a `ControlMouseButtonListener` with a reference to the ControlsPanel.
     *
     * @param controlsPanel The ControlsPanel to interact with.
     */
    public ControlMouseButtonListener(ControlsPanel controlsPanel) {
        this.controlsPanel = controlsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == controlsPanel.getReturnButton()) {
            // Return to the main menu.
            new GameMenu();
            // Close the ControlsPanel window.
            getFrameForComponent(controlsPanel).dispatchEvent(new WindowEvent(getFrameForComponent(controlsPanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}
