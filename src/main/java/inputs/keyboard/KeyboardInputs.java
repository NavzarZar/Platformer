package inputs.keyboard;

import game.Game;
import game.Player;
import menus.PauseMenu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The `KeyboardInputs` class handles keyboard input for the game.
 */
public class KeyboardInputs implements KeyListener {
    private final Player player;

    public KeyboardInputs(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used in this context.
    }

    // Variables to track keyboard input states
    public static boolean movingLeft = false;
    public static boolean movingRight = false;
    public static boolean isJumping = false;

    @Override
    public void keyPressed(KeyEvent e) {
        if (!Game.gameOver) {
            // Handle key presses when the game is not over
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
                    isJumping = true;
                    player.jump();
                }
                case KeyEvent.VK_ESCAPE -> {
                    // Pause the game and open the PauseMenu when the Escape key is pressed
                    Game.isPaused = true;
                    new PauseMenu();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (!Game.gameOver) {
            // Handle key releases when the game is not over
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
}
