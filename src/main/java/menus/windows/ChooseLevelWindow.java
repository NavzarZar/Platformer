package menus.windows;

import menus.panels.ChooseLevelPanel;
import menus.panels.ControlsPanel;

import javax.swing.*;

public class ChooseLevelWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 420;

    public ChooseLevelWindow(ChooseLevelPanel chooseLevelPanel) {
        JFrame jframe = new JFrame();
        jframe.setSize(width, height);

        //The program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //We add the panel with the pause menu inside the frame
        jframe.add(chooseLevelPanel);

        //Sets the window to pop up in centre
        jframe.setLocationRelativeTo(null);
        //We ses the frame
        jframe.setVisible(true);
    }
}
