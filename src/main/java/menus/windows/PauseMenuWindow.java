package menus.windows;

import game.Game;
import menus.panels.PauseMenuPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        //We see the frame and it can not be resized
        jframe.setResizable(false);
        jframe.setVisible(true);

        //Making the window close function more user-intuitively
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Game.setIsPaused(false);
                jframe.dispose();
            }
        });
    }
}