package game;

import javax.swing.*;

public class MenuWindow extends JFrame {
    public static final int width = 1920;
    public static final int height = 1080;

    public MenuWindow(StartMenu startMenu) {

        //Create new JFrame frame object
        JFrame jframe = new JFrame();
        jframe.setSize(width, height);

        //The program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //We add the panel with the menu inside the frame
        jframe.add(startMenu);

        //Sets the window to pop up in centre
        jframe.setLocationRelativeTo(null);
        //We ses the frame
        jframe.setVisible(true);
    }
}
