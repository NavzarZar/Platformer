package menus.windows;

import menus.panels.ControlsPanel;

import javax.swing.*;

public class ControlsWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 420;

    public ControlsWindow(ControlsPanel controlsPanel) {
        JFrame jframe = new JFrame();
        jframe.setSize(width, height);

        //The program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //We add the panel with the pause menu inside the frame
        jframe.add(controlsPanel);

        //Sets the window to pop up in centre
        jframe.setLocationRelativeTo(null);
        //We ses the frame
        jframe.setVisible(true);
    }
}
