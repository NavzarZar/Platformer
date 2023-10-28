package menus.panels;

import inputs.buttonListeners.FinishedGamePanelButtonListener;

import javax.swing.*;
import java.awt.*;

import static menus.GlobalMethods.styledButton;

public class FinishedGamePanel extends JPanel {
    private JLabel thankYouLabel;
    private JButton mainMenu, exitButton;
    private FinishedGamePanelButtonListener finishedGamePanelButtonListener;
    public FinishedGamePanel(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        finishedGamePanelButtonListener = new FinishedGamePanelButtonListener(this);

        thankYouLabel = new JLabel("Thank you for playing our game!");
        mainMenu =  styledButton("Return to Main Menu");
        exitButton = styledButton("Exit");

        mainMenu.addActionListener(finishedGamePanelButtonListener);
        exitButton.addActionListener(finishedGamePanelButtonListener);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy += 1;
        this.add(thankYouLabel, gbc);

        gbc.gridy += 1;
        this.add(mainMenu, gbc);

        gbc.gridy +=1;
        this.add(exitButton, gbc);

        thankYouLabel.setVisible(true);
        mainMenu.setVisible(true);
        exitButton.setVisible(true);
    }

    public JButton getMainMenu() {
        return mainMenu;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
