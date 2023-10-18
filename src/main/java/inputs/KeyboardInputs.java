package inputs;

import game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

    private final GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
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
                gamePanel.player.moveLeft(gamePanel.getMap());
                movingLeft = true;
                movingRight = false;
            }
            case KeyEvent.VK_D -> {
                gamePanel.player.moveRight(gamePanel.getMap());
                movingLeft = false;
                movingRight = true;
            }
            case KeyEvent.VK_SPACE -> {
                gamePanel.player.jump(gamePanel.getMap());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A && movingLeft) {
            gamePanel.player.setVelocityX(0);
            movingLeft = false;
        }

        if (key == KeyEvent.VK_D && !movingLeft) {
            gamePanel.player.setVelocityX(0);
            movingRight = false;
        }
    }
}