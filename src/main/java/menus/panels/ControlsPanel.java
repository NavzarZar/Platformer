package menus.panels;

import inputs.buttonListeners.ControlMouseButtonListener;
import menus.windows.ControlsWindow;

import javax.swing.*;

import static menus.GlobalMethods.styledButton;

public class ControlsPanel extends JPanel {
    private JButton returnButton;
    ControlMouseButtonListener controlMouseButtonListener;

    final ControlsWindow controlsWindow = new ControlsWindow(this);
    public ControlsPanel() {
        controlMouseButtonListener = new ControlMouseButtonListener(this);
        returnButton = styledButton("Return to Main Menu");

        returnButton.addActionListener(controlMouseButtonListener);

        this.add(returnButton);
        returnButton.setVisible(true);
    }

    public JButton getReturnButton() {
        return returnButton;
    }
}
