package inputs;

import game.Player;
import menus.PauseMenuPanel;
import menus.PauseMenuWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

    private final Player player;

    public KeyboardInputs(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public static boolean movingLeft = false;
    public static boolean movingRight = false;
    @Override
    public void keyPressed(KeyEvent e) {
        //Searches for keyboard input, changes the pos where the rectangle is drawn (X,Y) in regards with said input
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A -> {
                movingLeft = true;
                movingRight = false;
            }
            case KeyEvent.VK_D -> {
                movingLeft = false;
                movingRight = true;
            }
            case KeyEvent.VK_SPACE -> {
                player.jump();
            }
            case KeyEvent.VK_ESCAPE -> {
                 new PauseMenuWindow(new PauseMenuPanel());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A && movingLeft) {
            player.setVelocityX(0);
            movingLeft = false;
        }

        if (key == KeyEvent.VK_D && !movingLeft) {
            player.setVelocityX(0);
            movingRight = false;
        }
    }
}