package inputs.buttonListeners;

import game.Game;
import game.GamePanel;
import menus.GameMenu;
import menus.panels.GameOverPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

/**
 * The `GameOverMouseButtonListener` class handles button click events on the GameOverPanel.
 */
public class GameOverMouseButtonListener implements ActionListener {
    GameOverPanel gameOverPanel;

    /**
     * Constructs a `GameOverMouseButtonListener` with a reference to the GameOverPanel.
     *
     * @param gameOverPanel The GameOverPanel to interact with.
     */
    public GameOverMouseButtonListener(GameOverPanel gameOverPanel) {
        this.gameOverPanel = gameOverPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gameOverPanel.getExitButton()) {
            // Exit the application when the exit button is clicked.
            System.exit(0);
        }
        if (e.getSource() == gameOverPanel.getRetryButton()) {
            // Start a new game when the retry button is clicked.
            Game.setGameOver(false);
            new Game();
            // Close the GameOverPanel window.
            getFrameForComponent(gameOverPanel).dispatchEvent(new WindowEvent(getFrameForComponent(gameOverPanel), WindowEvent.WINDOW_CLOSING));
        }
        if(e.getSource() == gameOverPanel.getMainMenu()){
            // Return to the main menu and close the GameOverPanel window.
            Game.setPressedReturnToMainMenu(true);
            new GameMenu();
            getFrameForComponent(gameOverPanel).dispatchEvent(new WindowEvent(getFrameForComponent(gameOverPanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}
