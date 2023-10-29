package inputs.buttonListeners;

import game.Game;
import menus.GameMenu;
import menus.panels.ChooseLevelPanel;
import physics.Collision;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

/**
 * The `ChooseLevelButtonListener` class handles button click events on the Choose Level panel.
 */
public class ChooseLevelButtonListener implements ActionListener {

    ChooseLevelPanel chooseLevelPanel;

    /**
     * Constructs a `ChooseLevelButtonListener` with a reference to the ChooseLevelPanel.
     *
     * @param chooseLevelPanel The ChooseLevelPanel to interact with.
     */
    public ChooseLevelButtonListener(ChooseLevelPanel chooseLevelPanel){
        this.chooseLevelPanel = chooseLevelPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chooseLevelPanel.getLvlOne()){
            // Set the game level to 1 and start the game.
            Game.setLevel(1);
            Collision.setLevel(1);
            Game.setGameOver(false);
            new Game();
            // Close the ChooseLevelPanel window.
            getFrameForComponent(chooseLevelPanel).dispatchEvent(new WindowEvent(getFrameForComponent(chooseLevelPanel), WindowEvent.WINDOW_CLOSING));
        }
        if(e.getSource() == chooseLevelPanel.getLvlTwo()){
            // Set the game level to 2 and start the game.
            Game.setLevel(2);
            Collision.setLevel(2);
            Game.setGameOver(false);
            new Game();
            // Close the ChooseLevelPanel window.
            getFrameForComponent(chooseLevelPanel).dispatchEvent(new WindowEvent(getFrameForComponent(chooseLevelPanel), WindowEvent.WINDOW_CLOSING));
        }
        if(e.getSource() == chooseLevelPanel.getLvlThree()){
            // Set the game level to 3 and start the game.
            Game.setLevel(3);
            Collision.setLevel(3);
            Game.setGameOver(false);
            new Game();
            // Close the ChooseLevelPanel window.
            getFrameForComponent(chooseLevelPanel).dispatchEvent(new WindowEvent(getFrameForComponent(chooseLevelPanel), WindowEvent.WINDOW_CLOSING));
        }
        if(e.getSource() == chooseLevelPanel.getReturnToMenu())
        {
            // Return to the main menu.
            new GameMenu();
            // Close the ChooseLevelPanel window.
            getFrameForComponent(chooseLevelPanel).dispatchEvent(new WindowEvent(getFrameForComponent(chooseLevelPanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}
