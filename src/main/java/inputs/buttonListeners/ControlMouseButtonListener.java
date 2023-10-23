package inputs.buttonListeners;

import game.Game;
import game.GameWindow;
import menus.GameMenu;
import menus.panels.ControlsPanel;
import menus.panels.StartMenuPanel;
import menus.windows.ControlsWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static menus.GlobalMethods.getFrameForComponent;

public class ControlMouseButtonListener implements ActionListener {
    private final ControlsPanel controlsPanel;

    public ControlMouseButtonListener(ControlsPanel controlsPanel) {
        this.controlsPanel = controlsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == controlsPanel.getReturnButton()) {
            new GameMenu();
            (getFrameForComponent(controlsPanel.getReturnButton())).dispose();
        }
    }
}
