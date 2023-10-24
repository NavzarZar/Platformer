package inputs.buttonListeners;

import game.Game;
import menus.panels.PauseMenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

public class PauseMenuButtonListener implements ActionListener {
    PauseMenuPanel pauseMenuPanel;
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
            new Game();
            Game.isPaused = false;
            getFrameForComponent(pauseMenuPanel).dispatchEvent(new WindowEvent(getFrameForComponent(pauseMenuPanel), WindowEvent.WINDOW_CLOSING));
        }

    }
}
