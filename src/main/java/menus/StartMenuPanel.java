package menus;

import inputs.StartMenuButtonListener;

import javax.swing.*;
import java.awt.*;

public class StartMenuPanel extends JPanel {
    private JButton startButton;
    private JButton exitButton;
    private JLabel titleLabel;
    StartMenuButtonListener startMenuButtonListener;

    public StartMenuPanel() {
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(480, 640));

        startMenuButtonListener = new StartMenuButtonListener(this);
        titleLabel = new JLabel();

        startButton = new JButton();
        exitButton = new JButton();

        startButton.addActionListener(startMenuButtonListener);
        exitButton.addActionListener(startMenuButtonListener);

        this.add(titleLabel);
        this.add(startButton);
        this.add(exitButton);

        int startButtonY = 400;
        int startButtonX = 500;
        titleLabel.setText("Welcome to game");

        titleLabel.setVisible(true);
        startButton.setVisible(true);
        exitButton.setVisible(true);

        titleLabel.setLocation(0,0);
        startButton.setLocation(0,10);
        exitButton.setLocation(0,20);

    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
