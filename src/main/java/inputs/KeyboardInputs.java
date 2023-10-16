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

    @Override
    public void keyPressed(KeyEvent e) {
        //Searches for keyboard input, changes the pos where the rectangle is drawn (X,Y) in regards with said input
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A -> gamePanel.player.moveLeft(gamePanel.getMap());
            case KeyEvent.VK_D -> gamePanel.player.moveRight(gamePanel.getMap());
            case KeyEvent.VK_SPACE -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}