package inputs.buttonListeners;

import game.Game;
import menus.panels.PauseMenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static menus.GlobalMethods.getFrameForComponent;

public class PauseMenuButtonListener implements ActionListener {
    PauseMenuPanel pauseMenuPanel;

    public PauseMenuButtonListener(PauseMenuPanel pauseMenuPanel) {
        this.pauseMenuPanel = pauseMenuPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pauseMenuPanel.getContinueButton()) {
            getFrameForComponent(pauseMenuPanel.getContinueButton()).dispose();
        }
        if (e.getSource() == pauseMenuPanel.getRestartButton()) {

            new Game();
            getFrameForComponent(pauseMenuPanel.getRestartButton()).dispose();
        }

    }
}
