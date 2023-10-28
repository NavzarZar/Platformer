package inputs.buttonListeners;

import game.Game;
import game.Player;
import menus.GameMenu;
import menus.panels.PauseMenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

public class PauseMenuButtonListener implements ActionListener {
    PauseMenuPanel pauseMenuPanel;
    Player player;

    public PauseMenuButtonListener(PauseMenuPanel pauseMenuPanel) {
        this.pauseMenuPanel = pauseMenuPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pauseMenuPanel.getContinueButton()) {
            Game.isPaused = false;
            getFrameForComponent(pauseMenuPanel).dispatchEvent(new WindowEvent(getFrameForComponent(pauseMenuPanel), WindowEvent.WINDOW_CLOSING));
        }
        if (e.getSource() == pauseMenuPanel.getRestartButton()) {
            Game.pressedRestart = true;
            Game.isPaused = false;
            getFrameForComponent(pauseMenuPanel).dispatchEvent(new WindowEvent(getFrameForComponent(pauseMenuPanel), WindowEvent.WINDOW_CLOSING));
        }
        if (e.getSource() == pauseMenuPanel.getExitButton()) {
            System.exit(0);
        }
        if (e.getSource() == pauseMenuPanel.getReturnToMenu()) {
            Game.pressedReturnToMainMenu = true;
            new GameMenu();
            getFrameForComponent(pauseMenuPanel).dispatchEvent(new WindowEvent(getFrameForComponent(pauseMenuPanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}