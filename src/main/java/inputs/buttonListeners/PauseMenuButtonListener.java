package inputs.buttonListeners;

import game.Game;
import game.Player;
import menus.GameMenu;
import menus.panels.PauseMenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

/**
 * The `PauseMenuButtonListener` class handles button click events on the PauseMenuPanel.
 */
public class PauseMenuButtonListener implements ActionListener {
    PauseMenuPanel pauseMenuPanel;
    Player player;

    /**
     * Constructs a `PauseMenuButtonListener` with a reference to the PauseMenuPanel.
     *
     * @param pauseMenuPanel The PauseMenuPanel to interact with.
     */
    public PauseMenuButtonListener(PauseMenuPanel pauseMenuPanel) {
        this.pauseMenuPanel = pauseMenuPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pauseMenuPanel.getContinueButton()) {
            // Resume the game and close the PauseMenuPanel window.
            Game.setIsPaused(false);
            getFrameForComponent(pauseMenuPanel).dispatchEvent(new WindowEvent(getFrameForComponent(pauseMenuPanel), WindowEvent.WINDOW_CLOSING));
        }
        if (e.getSource() == pauseMenuPanel.getRestartButton()) {
            // Restart the game and close the PauseMenuPanel window.
            Game.setPressedRestart(true);
            Game.setIsPaused(false);
            getFrameForComponent(pauseMenuPanel).dispatchEvent(new WindowEvent(getFrameForComponent(pauseMenuPanel), WindowEvent.WINDOW_CLOSING));
        }
        if (e.getSource() == pauseMenuPanel.getExitButton()) {
            // Exit the application when the exit button is clicked.
            System.exit(0);
        }
        if (e.getSource() == pauseMenuPanel.getReturnToMenu()) {
            // Return to the main menu and close the PauseMenuPanel window.
            Game.setPressedReturnToMainMenu(true);
            new GameMenu();
            getFrameForComponent(pauseMenuPanel).dispatchEvent(new WindowEvent(getFrameForComponent(pauseMenuPanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}
