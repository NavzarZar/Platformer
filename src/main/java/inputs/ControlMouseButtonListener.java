package inputs;

import game.Game;
import menus.GameMenu;
import menus.panels.ControlsPanel;
import menus.windows.ControlsWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMouseButtonListener implements ActionListener {
    private final ControlsPanel controlsPanel;
    private final ControlsWindow controlsWindow;
    public ControlMouseButtonListener(ControlsPanel controlsPanel, ControlsWindow controlsWindow) {
        this.controlsPanel = controlsPanel;
        this.controlsWindow = controlsWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == controlsPanel.getReturnButton()) {
            controlsWindow.dispose();
            controlsWindow.setVisible(false);
            new GameMenu();
        }
    }
}
