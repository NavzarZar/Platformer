package inputs.buttonListeners;

import game.Game;
import menus.FinishedGameMenu;
import menus.GameMenu;
import menus.panels.LevelCompletePanel;
import physics.Collision;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

/**
 * The `LevelCompleteButtonListener` class handles button click events on the LevelCompletePanel.
 */
public class LevelCompleteButtonListener implements ActionListener {
    LevelCompletePanel levelCompletePanel;

    /**
     * Constructs a `LevelCompleteButtonListener` with a reference to the LevelCompletePanel.
     *
     * @param levelCompletePanel The LevelCompletePanel to interact with.
     */
    public LevelCompleteButtonListener(LevelCompletePanel levelCompletePanel) {
        this.levelCompletePanel = levelCompletePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == levelCompletePanel.getExitButton()) {
            // Exit the application when the exit button is clicked.
            System.exit(0);
        }
        if (e.getSource() == levelCompletePanel.getContinueButton()) {
            if (Game.getLevel() < 3) {
                // Increment the level and start the next level if available.
                Collision.setLevel(Game.getLevel() + 1);
                Game.setLevel(Game.getLevel() + 1);
                new Game();
            } else if (Game.getLevel() == 3) {
                // If it's the last level, show the finished game menu.
                new FinishedGameMenu();
            }
            // Close the LevelCompletePanel window.
            getFrameForComponent(levelCompletePanel).dispatchEvent(new WindowEvent(getFrameForComponent(levelCompletePanel), WindowEvent.WINDOW_CLOSING));
        }
        if (e.getSource() == levelCompletePanel.getMainMenuButton()) {
            // Return to the main menu and close the LevelCompletePanel window.
            Game.pressedReturnToMainMenu = true;
            new GameMenu();
            getFrameForComponent(levelCompletePanel).dispatchEvent(new WindowEvent(getFrameForComponent(levelCompletePanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}
