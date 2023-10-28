package menus.panels;

import inputs.buttonListeners.LevelCompleteButtonListener;

import javax.swing.*;

import java.awt.*;

import static menus.GlobalMethods.styledButton;

public class LevelCompletePanel extends JPanel {
    private JButton mainMenuButton, exitButton;
    private LevelCompleteButtonListener levelCompleteButtonListener;
    public LevelCompletePanel()
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        levelCompleteButtonListener = new LevelCompleteButtonListener(this);

        mainMenuButton = styledButton("Main Menu");
        exitButton = styledButton("Exit");

        mainMenuButton.addActionListener(levelCompleteButtonListener);
        exitButton.addActionListener(levelCompleteButtonListener);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy += 1;
        this.add(mainMenuButton, gbc);

        gbc.gridy += 1;
        this.add(exitButton, gbc);

        mainMenuButton.setVisible(true);
        exitButton.setVisible(true);
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
