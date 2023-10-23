package menus.windows;

import menus.panels.GameOverPanel;
import menus.panels.StartMenuPanel;

import javax.swing.*;

public class GameOverWindow extends JFrame {
    public static final int width = 640;
    public static final int height = 480;

    public GameOverWindow(GameOverPanel gameOverPanel) {

        //Create new JFrame frame object
        JFrame jframe = new JFrame();
        jframe.setSize(width, height);

        //The program stops running when the frame is closed
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //We add the panel with the menu inside the frame
        jframe.add(gameOverPanel);

        //Sets the window to pop up in centre
        jframe.setLocationRelativeTo(null);
        //We ses the frame
        jframe.setVisible(true);
    }
}
