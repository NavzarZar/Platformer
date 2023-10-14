package inputs;

import game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//a
public class KeyboardInputs implements KeyListener {

    private final GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int delta = 4;

        //Searches for keyboard input, changes the pos where the rectangle is drawn (X,Y) in regards with said input
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.changePlayerY(-delta);
            case KeyEvent.VK_A -> gamePanel.changePlayerX(-delta);
            case KeyEvent.VK_S -> gamePanel.changePlayerY(delta);
            case KeyEvent.VK_D -> gamePanel.changePlayerX(delta);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}