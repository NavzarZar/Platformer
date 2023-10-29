package menus.panels;

import inputs.buttonListeners.PauseMenuButtonListener;
import javax.swing.*;
import java.awt.*;
import static menus.GlobalMethods.styledButton;

/**
 * The PauseMenuPanel class represents the panel for the pause menu screen.
 * It contains buttons for continuing the game, restarting the game, returning to the main menu, and exiting the game.
 */
public class PauseMenuPanel extends JPanel {
    private JButton restartButton;
    private JButton continueButton;
    private JButton exitButton;
    private JButton returnToMenu;
    private PauseMenuButtonListener pauseMenuButtonListener;

    /**
     * Constructs a new PauseMenuPanel.
     */
    public PauseMenuPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        pauseMenuButtonListener = new PauseMenuButtonListener(this);

        continueButton = styledButton("Continue");
        restartButton = styledButton("Restart Game");
        returnToMenu = styledButton("Return to Main Menu");
        exitButton = styledButton("Exit");

        // Add action listeners to buttons
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

    /**
     * Gets the continue button.
     *
     * @return The continue button.
     */
    public JButton getContinueButton() {
        return continueButton;
    }

    /**
     * Gets the restart button.
     *
     * @return The restart button.
     */
    public JButton getRestartButton() {
        return restartButton;
    }

    /**
     * Gets the exit button.
     *
     * @return The exit button.
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * Gets the return to menu button.
     *
     * @return The return to menu button.
     */
    public JButton getReturnToMenu() {
        return returnToMenu;
    }
}
