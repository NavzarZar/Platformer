package menus.panels;

import inputs.buttonListeners.ControlMouseButtonListener;
import menus.windows.ControlsWindow;

import javax.swing.*;

import java.awt.*;

import static menus.GlobalMethods.styledButton;

public class ControlsPanel extends JPanel {
    private JButton returnButton;
    ControlMouseButtonListener controlMouseButtonListener;

    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        String instructions = "Game Controls:";
        g.drawString(instructions, 30, 30);

        g.setFont(new Font("Arial", Font.PLAIN, 16));
        String controlA = "Move left: Press 'A'";
        String controlD = "Move right: Press 'D'";
        String controlSpace = "Jump: Press 'SPACE'";
        String controlEsc = "Pause the game: Press 'ESC'";
        g.drawString(controlA, 100, 60);
        g.drawString(controlD, 100, 90);
        g.drawString(controlSpace, 100, 120);
        g.drawString(controlEsc, 100, 150);

        // Draw keyboard keys
        drawKey(g, "A", 50, 200, 40, 40);
        drawKey(g, "D", 100, 200 ,40, 40);
        drawKey(g, "SPACE", 150, 200, 73, 40);
        drawKey(g, "ESC", 233, 200, 45, 40);
    }

    private void drawKey(Graphics g, String key, int x, int y, int width, int height) {
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString(key, x + 12, y + 25);
    }

    public ControlsPanel() {
        controlMouseButtonListener = new ControlMouseButtonListener(this);
        returnButton = styledButton("Return to Main Menu");

        returnButton.addActionListener(controlMouseButtonListener);
        this.add(returnButton);
        this.setVisible(true);
    }

    public JButton getReturnButton() {
        return returnButton;
    }
}
