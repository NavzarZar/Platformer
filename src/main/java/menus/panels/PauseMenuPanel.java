package menus.panels;

import inputs.PauseMenuButtonListener;

import javax.swing.*;

public class PauseMenuPanel extends JPanel {
    PauseMenuButtonListener pauseMenuButtonListener = new PauseMenuButtonListener(this);
    private JButton continueButton;
        public PauseMenuPanel() {

            continueButton = new JButton();

            this.add(continueButton);

            continueButton.addActionListener(pauseMenuButtonListener);
        }

    public JButton getContinueButton() {
        return continueButton;
    }
}
