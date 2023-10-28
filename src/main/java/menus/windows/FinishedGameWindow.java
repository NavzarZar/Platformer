package menus.windows;

import menus.panels.ChooseLevelPanel;
import menus.panels.ControlsPanel;
import menus.panels.FinishedGamePanel;

import javax.swing.*;

public class FinishedGameWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 420;

    public FinishedGameWindow(FinishedGamePanel finishedGamePanel) {
        JFrame jframe = new JFrame();
        jframe.setSize(width, height);

        //The program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //We add the panel with the pause menu inside the frame
        jframe.add(finishedGamePanel);

        //Sets the window to pop up in centre
        jframe.setLocationRelativeTo(null);

        //We see the frame and it can not be resized
        jframe.setResizable(false);
        jframe.setVisible(true);
    }
}
