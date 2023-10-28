package menus.panels;

import inputs.buttonListeners.GameOverMouseButtonListener;

import javax.swing.*;
import java.awt.*;

import static menus.GlobalMethods.styledButton;

public class GameOverPanel extends JPanel {
    private final JButton retryButton, exitButton, mainMenu;

    private JLabel gameOverLabel;
    GameOverMouseButtonListener gameOverMouseButtonListener;

    public GameOverPanel()
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gameOverMouseButtonListener = new GameOverMouseButtonListener(this);

        mainMenu = styledButton("Return to Main Menu");
        retryButton = styledButton("Retry");
        exitButton = styledButton("Exit");

        gameOverLabel = new JLabel("Game Over!");
        retryButton.addActionListener(gameOverMouseButtonListener);
        exitButton.addActionListener(gameOverMouseButtonListener);
        mainMenu.addActionListener(gameOverMouseButtonListener);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy += 1;
        this.add(gameOverLabel, gbc);

        gbc.gridy += 1;
        this.add(retryButton, gbc);

        gbc.gridy += 1;
        this.add(mainMenu, gbc);

        gbc.gridy += 1;
        this.add(exitButton, gbc);


        mainMenu.setVisible(true);
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

    public JButton getMainMenu() {
        return mainMenu;
    }
}