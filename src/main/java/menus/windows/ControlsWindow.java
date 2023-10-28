package menus.windows;

import game.Game;
import menus.panels.ControlsPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControlsWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 420;

    public ControlsWindow(ControlsPanel controlsPanel) {
        JFrame jframe = new JFrame();
        jframe.setSize(width, height);

        //The program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //We add the panel with the pause menu inside the frame
        jframe.add(controlsPanel);

        //Sets the window to pop up in centre
        jframe.setLocationRelativeTo(null);

        //We see the frame and it cannot be resized
        jframe.setVisible(true);
        jframe.setResizable(false);


    }
}
