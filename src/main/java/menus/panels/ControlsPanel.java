package menus.panels;

import inputs.ControlMouseButtonListener;
import menus.windows.ControlsWindow;

import javax.naming.ldap.Control;
import javax.swing.*;

public class ControlsPanel extends JPanel {
    private JButton returnButton;
    ControlMouseButtonListener controlMouseButtonListener;

    final ControlsWindow controlsWindow = new ControlsWindow(this);
    public ControlsPanel() {
        controlMouseButtonListener = new ControlMouseButtonListener(this, controlsWindow);
        returnButton = new JButton("Return to Main Menu");

        returnButton.addActionListener(controlMouseButtonListener);

        this.add(returnButton);
        returnButton.setVisible(true);
    }

    public JButton getReturnButton() {
        return returnButton;
    }
}
