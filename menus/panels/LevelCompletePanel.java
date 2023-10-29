package menus.panels;

import inputs.buttonListeners.LevelCompleteButtonListener;

import javax.swing.*;
import java.awt.*;

import static menus.GlobalMethods.styledButton;

public class LevelCompletePanel extends JPanel {
    private JButton mainMenuButton, exitButton, continueButton;
    private LevelCompleteButtonListener levelCompleteButtonListener;

    public LevelCompletePanel() {
        // Set the layout manager for the panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        levelCompleteButtonListener = new LevelCompleteButtonListener(this);

        // Initialize and configure UI components
        mainMenuButton = styledButton("Main Menu");
        exitButton = styledButton("Exit");
        continueButton = styledButton("Next Level");

        // Attach action listeners to buttons
        mainMenuButton.addActionListener(levelCompleteButtonListener);
        exitButton.addActionListener(levelCompleteButtonListener);
        continueButton.addActionListener(levelCompleteButtonListener);

        // Configure layout constraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Add components to the panel
        gbc.gridy += 1;
        this.add(mainMenuButton, gbc);

        gbc.gridy += 1;
        this.add(continueButton, gbc);

        gbc.gridy += 1;
        this.add(exitButton, gbc);

        // Set component visibility
        continueButton.setVisible(true);
        mainMenuButton.setVisible(true);
        exitButton.setVisible(true);
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getContinueButton() {
        return continueButton;
    }
}
