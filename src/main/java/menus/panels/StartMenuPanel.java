package menus.panels;

import game.Game;
import inputs.buttonListeners.StartMenuButtonListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static menus.GlobalMethods.styledButton;

/**
 * The StartMenuPanel class represents the panel for the start menu screen.
 * It contains buttons for starting the game, choosing a level, viewing controls, and exiting the game.
 */
public class StartMenuPanel extends JPanel {
    private JButton startButton, exitButton, chooseLvlButton, controlsButton;
    private JLabel titleLabel;
    private StartMenuButtonListener startMenuButtonListener;
    private BufferedImage image;

    /**
     * Constructs a new StartMenuPanel.
     */
    public StartMenuPanel() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(480, 640));

        GridBagConstraints gbc = new GridBagConstraints();
        startMenuButtonListener = new StartMenuButtonListener(this);

        titleLabel = new JLabel("Welcome to the game!");

        startButton = styledButton("Start Game");
        chooseLvlButton = styledButton("Choose Level");
        controlsButton = styledButton("Controls");
        exitButton = styledButton("Exit");

        // Add action listeners to buttons
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

        titleLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        titleLabel.setSize(40, 40);

        controlsButton.setVisible(true);
        chooseLvlButton.setVisible(true);
        titleLabel.setVisible(true);
        startButton.setVisible(true);
        exitButton.setVisible(true);
    }

    /**
     * Gets the start button.
     *
     * @return The start button.
     */
    public JButton getStartButton() {
        return startButton;
    }

    /**
     * Gets the exit button.
     *
     * @return The exit button.
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * Gets the choose level button.
     *
     * @return The choose level button.
     */
    public JButton getChooseLvlButton() {
        return chooseLvlButton;
    }

    /**
     * Gets the controls button.
     *
     * @return The controls button.
     */
    public JButton getControlsButton() {
        return controlsButton;
    }
}
