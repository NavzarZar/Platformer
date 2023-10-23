package menus.panels;

import inputs.buttonListeners.StartMenuButtonListener;

import javax.swing.*;
import java.awt.*;

import static menus.GlobalMethods.styledButton;

public class StartMenuPanel extends JPanel {
    private JButton startButton, exitButton, chooseLvlButton, controlsButton;
    private JLabel titleLabel;
    StartMenuButtonListener startMenuButtonListener;

    public StartMenuPanel() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(480, 640));

        GridBagConstraints gbc = new GridBagConstraints();

        startMenuButtonListener = new StartMenuButtonListener(this);
        titleLabel = new JLabel();

        startButton = styledButton("Start Game");
        chooseLvlButton = styledButton("Choose Level");
        controlsButton = styledButton("Controls");
        exitButton = styledButton("Exit");

        startButton.addActionListener(startMenuButtonListener);
        exitButton.addActionListener(startMenuButtonListener);
        controlsButton.addActionListener(startMenuButtonListener);
        chooseLvlButton.addActionListener(startMenuButtonListener);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy += 1;
        this.add(titleLabel, gbc);

        gbc.gridy += 1;
        this.add(startButton, gbc);

        gbc.gridy += 1;
        this.add(exitButton, gbc);

        gbc.gridy += 1;
        this.add(chooseLvlButton, gbc);

        gbc.gridy += 1;
        this.add(controlsButton, gbc);

        gbc.gridy += 1;
        this.add(exitButton, gbc);

        titleLabel.setText("Welcome to game");


        controlsButton.setVisible(true);
        chooseLvlButton.setVisible(true);
        titleLabel.setVisible(true);
        startButton.setVisible(true);
        exitButton.setVisible(true);


    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getChooseLvlButton() {
        return chooseLvlButton;
    }

    public JButton getControlsButton() {
        return controlsButton;
    }


}

