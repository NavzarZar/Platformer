package menus.panels;

import inputs.StartMenuButtonListener;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        startButton = createStyledButton("Start Game");
        chooseLvlButton = createStyledButton("Choose Level");
        controlsButton = createStyledButton("Controls");
        exitButton = createStyledButton("Exit");

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
        this.add(chooseLvlButton,gbc);

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

    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        int spacing = 5; // Adjust this value for the desired spacing
        Color borderColor = Color.BLACK; // Customize the border color
        int borderThickness = 3; // Customize the border thickness

        // Create a CompoundBorder with EmptyBorder and customized LineBorder
        CompoundBorder border = new CompoundBorder(
                new EmptyBorder(spacing, spacing, spacing, spacing),
                new LineBorder(borderColor, borderThickness)
        );

        button.setBorder(border);

        // Make the button edges round
        int arc = 15; // Adjust this value for the desired roundness
        button.setBorder(BorderFactory.createLineBorder(borderColor, borderThickness));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setMargin(new Insets(spacing, spacing, spacing, spacing));
        button.setForeground(borderColor);
        button.setBorderPainted(false);

        // Add a MouseListener to change the button color on hover and press
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(borderColor.brighter());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(borderColor.darker());
            }
        });

        return button;
    }
}

