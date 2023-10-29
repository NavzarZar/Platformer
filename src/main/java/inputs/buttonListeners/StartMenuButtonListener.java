package inputs.buttonListeners;

import game.Game;
import menus.ChooseLevelMenu;
import menus.ControlMenu;
import menus.panels.PauseMenuPanel;
import menus.panels.StartMenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

/**
 * The `StartMenuButtonListener` class handles button click events on the StartMenuPanel.
 */
public class StartMenuButtonListener implements ActionListener {
    StartMenuPanel startMenuPanel;
    PauseMenuPanel pauseMenuPanel;

    /**
     * Constructs a `StartMenuButtonListener` with a reference to the StartMenuPanel.
     *
     * @param startMenuPanel The StartMenuPanel to interact with.
     */
    public StartMenuButtonListener(StartMenuPanel startMenuPanel) {
        this.startMenuPanel = startMenuPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startMenuPanel.getStartButton()) {
            // Start a new game and close the StartMenuPanel window.
            Game.setIsPaused(false);
            new Game();
            getFrameForComponent(startMenuPanel).dispatchEvent(new WindowEvent(getFrameForComponent(startMenuPanel), WindowEvent.WINDOW_CLOSING));
        } else if (e.getSource() == startMenuPanel.getExitButton()) {
            // Exit the application when the exit button is clicked.
            System.exit(0);
        } else if (e.getSource() == startMenuPanel.getChooseLvlButton()) {
            // Open the ChooseLevelMenu and close the StartMenuPanel window.
            new ChooseLevelMenu();
            getFrameForComponent(startMenuPanel).dispatchEvent(new WindowEvent(getFrameForComponent(startMenuPanel), WindowEvent.WINDOW_CLOSING));
        } else if (e.getSource() == startMenuPanel.getControlsButton()) {
            // Open the ControlMenu and close the StartMenuPanel window.
            new ControlMenu();
            getFrameForComponent(startMenuPanel).dispatchEvent(new WindowEvent(getFrameForComponent(startMenuPanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}
