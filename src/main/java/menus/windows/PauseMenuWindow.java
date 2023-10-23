package menus.windows;

import menus.panels.PauseMenuPanel;

import javax.swing.*;

public class PauseMenuWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 480;

    public PauseMenuWindow(PauseMenuPanel pauseMenuPanel) {
        JFrame jframe = new JFrame();
        jframe.setSize(width, height);

        //The program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //We add the panel with the pause menu inside the frame
        jframe.add(pauseMenuPanel);

        //Sets the window to pop up in centre
        jframe.setLocationRelativeTo(null);
        //We ses the frame
        jframe.setVisible(true);
    }
}