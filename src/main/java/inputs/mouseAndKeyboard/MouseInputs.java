package inputs.mouseAndKeyboard;

import game.GamePanel;
import game.GameWindow;
import game.Map;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    private final GamePanel gamePanel;

    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        gamePanel.player.setPlayerX(e.getX() + GameWindow.width * (gamePanel.player.getPlayerX() / GameWindow.width));
        gamePanel.player.setPlayerY(e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        gamePanel.player.setPlayerX(e.getX());
        gamePanel.player.setPlayerY(e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("Mouse Moved");
    }
}