package game;

import inputs.ButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JPanel {
    private JButton startButton;
    private JButton exitButton;

    ButtonListener buttonListener;

    public StartMenu() {
        System.out.println("1");
        buttonListener = new ButtonListener(this);

        startButton = new JButton();
        exitButton = new JButton();

        startButton.addActionListener(buttonListener);
        exitButton.addActionListener(buttonListener);

        this.add(startButton);
        this.add(exitButton);

        int startButtonY = 400;
        int startButtonX = 500;

        startButton.setLocation(new Point(startButtonX, startButtonY));
        exitButton.setLocation(new Point(startButtonX, startButtonY + 15));

        startButton.setVisible(true);
        exitButton.setVisible(true);

    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
