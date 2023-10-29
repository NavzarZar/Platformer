package menus.panels;

import inputs.buttonListeners.GameOverMouseButtonListener;

import javax.swing.*;
import java.awt.*;

import static menus.GlobalMethods.styledButton;

/**
 * Represents the panel displayed when the game is over.
 */
public class GameOverPanel extends JPanel {
    private final JButton retryButton, exitButton, mainMenu;

    private JLabel gameOverLabel;
    GameOverMouseButtonListener gameOverMouseButtonListener;

    /**
     * Creates a new GameOverPanel.
     */
    public GameOverPanel() {
        // Set the layout manager for the panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gameOverMouseButtonListener = new GameOverMouseButtonListener(this);

        // Initialize and configure UI components
        mainMenu = styledButton("Return to Main Menu");
        retryButton = styledButton("Retry");
        exitButton = styledButton("Exit");

        // Create and configure the game over label
        gameOverLabel = new JLabel("Game Over!");

        // Attach action listeners to buttons
        retryButton.addActionListener(gameOverMouseButtonListener);
        exitButton.addActionListener(gameOverMouseButtonListener);
        mainMenu.addActionListener(gameOverMouseButtonListener);

        // Configure layout constraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Add components to the panel
        gbc.gridy += 1;
        this.add(gameOverLabel, gbc);

        gbc.gridy += 1;
        this.add(retryButton, gbc);

        gbc.gridy += 1;
        this.add(mainMenu, gbc);

        gbc.gridy += 1;
        this.add(exitButton, gbc);

        // Set component visibility
        mainMenu.setVisible(true);
        gameOverLabel.setVisible(true);
        retryButton.setVisible(true);
        exitButton.setVisible(true);
    }

    /**
     * Get the "Retry" button.
     *
     * @return The "Retry" button.
     */
    public JButton getRetryButton() {
        return retryButton;
    }

    /**
     * Get the "Exit" button.
     *
     * @return The "Exit" button.
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * Get the "Return to Main Menu" button.
     *
     * @return The "Return to Main Menu" button.
     */
    public JButton getMainMenu() {
        return mainMenu;
    }
}
