package menus.panels;

import inputs.buttonListeners.ControlMouseButtonListener;
import menus.windows.ControlsWindow;

import javax.swing.*;

import java.awt.*;

import static menus.GlobalMethods.styledButton;

public class ControlsPanel extends JPanel {
    private JButton returnButton;
    ControlMouseButtonListener controlMouseButtonListener;

    public ControlsPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        controlMouseButtonListener = new ControlMouseButtonListener(this);
        returnButton = styledButton("Return to Main Menu");

        returnButton.addActionListener(controlMouseButtonListener);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy += 1;
        this.add(returnButton, gbc);

    }

    public JButton getReturnButton() {
        return returnButton;
    }
}
