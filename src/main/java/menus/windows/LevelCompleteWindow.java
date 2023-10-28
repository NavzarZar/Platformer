package menus.windows;

import menus.panels.GameOverPanel;
import menus.panels.LevelCompletePanel;
import menus.panels.StartMenuPanel;

import javax.swing.*;

public class LevelCompleteWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 480;

    public LevelCompleteWindow(LevelCompletePanel levelCompletePanel) {

        //Create new JFrame frame object
        JFrame jframe = new JFrame();
        jframe.setSize(width, height);

        //The program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //We add the panel with the menu inside the frame
        jframe.add(levelCompletePanel);

        //Sets the window to pop up in centre
        jframe.setLocationRelativeTo(null);
        //We ses the frame
        jframe.setVisible(true);
    }
}
