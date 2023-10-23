package menus.panels;

import game.Game;
import game.GamePanel;
import game.Player;
import inputs.buttonListeners.GameOverMouseButtonListener;

import javax.swing.*;

import java.awt.*;

import static java.awt.Font.SANS_SERIF;
import static menus.GlobalMethods.createStyledLabel;
import static menus.GlobalMethods.styledButton;

public class GameOverPanel extends JPanel {
    private final JButton retryButton;
    private final JButton exitButton;
    private JLabel gameOverLabel;
    GameOverMouseButtonListener gameOverMouseButtonListener;

    public GameOverPanel()
    {
        gameOverMouseButtonListener = new GameOverMouseButtonListener(this, new GamePanel(new Player()));

        retryButton = styledButton("Retry");
        exitButton = styledButton("Exit");

        gameOverLabel = new JLabel("Game Over!");
        retryButton.addActionListener(gameOverMouseButtonListener);
        exitButton.addActionListener(gameOverMouseButtonListener);

        this.add(gameOverLabel);
        this.add(retryButton);
        this.add(exitButton);

        gameOverLabel.setVisible(true);
        retryButton.setVisible(true);
        exitButton.setVisible(true);

    }

    public JButton getRetryButton() {
        return retryButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
