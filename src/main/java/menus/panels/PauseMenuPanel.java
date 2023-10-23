package menus.panels;

import inputs.buttonListeners.PauseMenuButtonListener;

import javax.swing.*;

import static menus.GlobalMethods.styledButton;

public class PauseMenuPanel extends JPanel {
    PauseMenuButtonListener pauseMenuButtonListener = new PauseMenuButtonListener(this);
    private final JButton restartButton;
    private final JButton continueButton;

    public PauseMenuPanel() {

        continueButton = styledButton("Return");
        restartButton = styledButton("Restart Game");

        this.add(continueButton);
        this.add(restartButton);

        continueButton.addActionListener(pauseMenuButtonListener);
        restartButton.addActionListener(pauseMenuButtonListener);
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public JButton getRestartButton() {
        return restartButton;
    }
}
