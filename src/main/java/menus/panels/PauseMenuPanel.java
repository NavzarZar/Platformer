package menus.panels;

import game.Game;
import game.GamePanel;
import game.GameWindow;
import game.Player;
import inputs.buttonListeners.PauseMenuButtonListener;
import menus.PauseMenu;

import javax.swing.*;

import java.awt.*;

import static menus.GlobalMethods.styledButton;

/**
 *
 */
public class PauseMenuPanel extends JPanel {
    PauseMenuButtonListener pauseMenuButtonListener = new PauseMenuButtonListener(this);
    private final JButton restartButton;
    private final JButton continueButton;
    private final JButton exitButton;
    private final JButton returnToMenu;
    public PauseMenuPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        continueButton = styledButton("Continue");
        restartButton = styledButton("Restart Game");
        returnToMenu = styledButton("Return to Main Menu");
        exitButton = styledButton("Exit");

        continueButton.addActionListener(pauseMenuButtonListener);
        restartButton.addActionListener(pauseMenuButtonListener);
        returnToMenu.addActionListener(pauseMenuButtonListener);
        exitButton.addActionListener(pauseMenuButtonListener);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy += 1;
        this.add(continueButton, gbc);

        gbc.gridy += 1;
        this.add(restartButton, gbc);

        gbc.gridy += 1;
        this.add(returnToMenu, gbc);

        gbc.gridy += 1;
        this.add(exitButton, gbc);

        continueButton.setVisible(true);
        restartButton.setVisible(true);
        returnToMenu.setVisible(true);
        exitButton.setVisible(true);

    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public JButton getRestartButton() {
        return restartButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getReturnToMenu() {
        return returnToMenu;
    }
}
