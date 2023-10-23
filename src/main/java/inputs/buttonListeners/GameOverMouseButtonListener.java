package inputs.buttonListeners;

import game.Game;
import game.GamePanel;
import menus.panels.GameOverPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static menus.GlobalMethods.getFrameForComponent;

public class GameOverMouseButtonListener implements ActionListener {

    GameOverPanel gameOverPanel;
    GamePanel gamePanel;

    public GameOverMouseButtonListener(GameOverPanel gameOverPanel, GamePanel gamePanel) {
        this.gameOverPanel = gameOverPanel;
        this.gamePanel = gamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gameOverPanel.getExitButton()) {
            System.exit(0);
        }
        if (e.getSource() == gameOverPanel.getRetryButton()) {
            Game.gameOver = false;
            new Game();
            getFrameForComponent(gameOverPanel).dispose();
        }
    }
}
