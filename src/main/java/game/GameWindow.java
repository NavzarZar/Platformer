package game;

import javax.swing.*;

public class GameWindow extends JFrame {
    public static final int width = 1440;
    public static final int height = 1080;

    public GameWindow(GamePanel gamePanel) {
        //Create new JFrame frame object
        JFrame jframe = new JFrame();
        jframe.setSize(width, height);

        //The program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //We add the panel with the drawings inside the frame
        jframe.add(gamePanel);

        //Sets the window to pop up in centre
        jframe.setLocationRelativeTo(null);
        //We ses the frame
        jframe.setVisible(true);
    }
}