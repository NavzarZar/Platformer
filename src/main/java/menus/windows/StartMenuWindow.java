package menus.windows;

import menus.panels.StartMenuPanel;

import javax.swing.*;
/**
 *
 */
public class StartMenuWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 480;

    public StartMenuWindow(StartMenuPanel startMenuPanel) {

        //Create new JFrame frame object
        JFrame jframe = new JFrame();
        jframe.setSize(width, height);

        //The program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //We add the panel with the menu inside the frame
        jframe.add(startMenuPanel);

        //Sets the window to pop up in centre
        jframe.setLocationRelativeTo(null);

        //We see the frame and it can not be resized
        jframe.setResizable(false);
        jframe.setVisible(true);
    }
}
