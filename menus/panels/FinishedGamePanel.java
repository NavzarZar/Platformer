package menus.panels;

import inputs.buttonListeners.FinishedGamePanelButtonListener;

import javax.swing.*;
import java.awt.*;

import static menus.GlobalMethods.styledButton;

/**
 * Represents the panel displayed when the game is finished.
 */
public class FinishedGamePanel extends JPanel {
    private JLabel thankYouLabel;
    private JButton mainMenu, exitButton;
    private FinishedGamePanelButtonListener finishedGamePanelButtonListener;

    /**
     * Creates a new FinishedGamePanel.
     */
    public FinishedGamePanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        finishedGamePanelButtonListener = new FinishedGamePanelButtonListener(this);

        // Initialize and configure UI components
        thankYouLabel = new JLabel("Thank you for playing our game!");
        mainMenu = styledButton("Return to Main Menu");
        exitButton = styledButton("Exit");

        // Attach action listeners to buttons
        mainMenu.addActionListener(finishedGamePanelButtonListener);
        exitButton.addActionListener(finishedGamePanelButtonListener);

        // Configure layout constraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Add components to the panel
        gbc.gridy += 1;
        this.add(thankYouLabel, gbc);

        gbc.gridy += 1;
        this.add(mainMenu, gbc);

        gbc.gridy += 1;
        this.add(exitButton, gbc);

        // Set component visibility
        thankYouLabel.setVisible(true);
        mainMenu.setVisible(true);
        exitButton.setVisible(true);
    }

    /**
     * Get the "Return to Main Menu" button.
     *
     * @return The "Return to Main Menu" button.
     */
    public JButton getMainMenu() {
        return mainMenu;
    }

    /**
     * Get the "Exit" button.
     *
     * @return The "Exit" button.
     */
    public JButton getExitButton() {
        return exitButton;
    }
}
