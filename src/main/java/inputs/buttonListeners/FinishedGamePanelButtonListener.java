package inputs.buttonListeners;

import menus.FinishedGameMenu;
import menus.GameMenu;
import menus.panels.FinishedGamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

/**
 * The `FinishedGamePanelButtonListener` class handles button click events on the FinishedGamePanel.
 */
public class FinishedGamePanelButtonListener implements ActionListener {
    FinishedGamePanel finishedGamePanel;

    /**
     * Constructs a `FinishedGamePanelButtonListener` with a reference to the FinishedGamePanel.
     *
     * @param finishedGamePanel The FinishedGamePanel to interact with.
     */
    public FinishedGamePanelButtonListener(FinishedGamePanel finishedGamePanel){
        this.finishedGamePanel = finishedGamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == finishedGamePanel.getExitButton()){
            // Exit the application when the exit button is clicked.
            System.exit(0);
        }
        if(e.getSource() == finishedGamePanel.getMainMenu()){
            // Return to the main menu.
            new GameMenu();
            // Close the FinishedGamePanel window.
            getFrameForComponent(finishedGamePanel).dispatchEvent(new WindowEvent(getFrameForComponent(finishedGamePanel), WindowEvent.WINDOW_CLOSING));
        }
    }
}
