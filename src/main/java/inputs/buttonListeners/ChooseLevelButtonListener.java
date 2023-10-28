package inputs.buttonListeners;

import game.Game;
import menus.GameMenu;
import menus.panels.ChooseLevelPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

public class ChooseLevelButtonListener implements ActionListener {

    ChooseLevelPanel chooseLevelPanel;
    public ChooseLevelButtonListener(ChooseLevelPanel chooseLevelPanel){
        this.chooseLevelPanel = chooseLevelPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chooseLevelPanel.getLvlOne()){
            System.out.println("1");
        }
        if(e.getSource() == chooseLevelPanel.getLvlTwo()){
            System.out.println("2");
        }
        if(e.getSource() == chooseLevelPanel.getLvlThree()){
            System.out.println("3");
        }
        if(e.getSource() == chooseLevelPanel.getReturnToMenu())
        {
            new GameMenu();
            getFrameForComponent(chooseLevelPanel).dispatchEvent(new WindowEvent(getFrameForComponent(chooseLevelPanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}
