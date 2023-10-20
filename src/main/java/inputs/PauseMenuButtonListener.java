package inputs;

import menus.GameMenu;
import menus.PauseMenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseMenuButtonListener implements ActionListener {
    PauseMenuPanel pauseMenuPanel;
    public PauseMenuButtonListener(PauseMenuPanel pauseMenuPanel)
    {
        this.pauseMenuPanel = pauseMenuPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pauseMenuPanel.getContinueButton())
        {
        }

    }
}
