package inputs.buttonListeners;

import game.Game;
import game.GamePanel;
import menus.panels.GameOverPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

public class GameOverMouseButtonListener implements ActionListener {
    GameOverPanel gameOverPanel;

    public GameOverMouseButtonListener(GameOverPanel gameOverPanel) {
        this.gameOverPanel = gameOverPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gameOverPanel.getExitButton()) {
            System.exit(0);
        }
        if (e.getSource() == gameOverPanel.getRetryButton()) {
            Game.gameOver = false;
            Game game = new Game();
            getFrameForComponent(gameOverPanel).dispatchEvent(new WindowEvent(getFrameForComponent(gameOverPanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}
