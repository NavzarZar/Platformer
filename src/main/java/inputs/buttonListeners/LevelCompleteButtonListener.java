package inputs.buttonListeners;

import game.Game;
import menus.GameMenu;
import menus.panels.LevelCompletePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

public class LevelCompleteButtonListener implements ActionListener {
    LevelCompletePanel levelCompletePanel;

    public LevelCompleteButtonListener(LevelCompletePanel levelCompletePanel) {
        this.levelCompletePanel = levelCompletePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == levelCompletePanel.getExitButton()) {
            System.exit(0);
        }
        if (e.getSource() == levelCompletePanel.getContinueButton()) {
            Game.setLevel(Game.getLevel() + 1);
            new Game();
            getFrameForComponent(levelCompletePanel).dispatchEvent(new WindowEvent(getFrameForComponent(levelCompletePanel), WindowEvent.WINDOW_CLOSING));

        }
        if (e.getSource() == levelCompletePanel.getMainMenuButton()) {
            Game.pressedReturnToMainMenu = true;
            new GameMenu();
            getFrameForComponent(levelCompletePanel).dispatchEvent(new WindowEvent(getFrameForComponent(levelCompletePanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}