package inputs.buttonListeners;

import menus.FinishedGameMenu;
import menus.GameMenu;
import menus.panels.FinishedGamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

public class FinishedGamePanelButtonListener implements ActionListener {
    FinishedGamePanel finishedGamePanel;
    public FinishedGamePanelButtonListener(FinishedGamePanel finishedGamePanel){
        this.finishedGamePanel = finishedGamePanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == finishedGamePanel.getExitButton()){
            System.exit(0);
        }
        if(e.getSource() == finishedGamePanel.getMainMenu()){
            new GameMenu();
            getFrameForComponent(finishedGamePanel).dispatchEvent(new WindowEvent(getFrameForComponent(finishedGamePanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}
