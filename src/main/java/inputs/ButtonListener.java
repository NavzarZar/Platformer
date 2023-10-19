package inputs;

import game.Game;
import game.MenuWindow;
import game.StartMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    StartMenu startMenu;

    public ButtonListener(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startMenu.getStartButton()) {
            new Game();
        }
        if(e.getSource() == startMenu.getExitButton()){
            System.exit(0);
        }

    }
}
