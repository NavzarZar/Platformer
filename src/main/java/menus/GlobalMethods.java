package menus;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The GlobalMethods class contains utility methods for styling Swing components.
 */
public abstract class GlobalMethods {

    /**
     * Creates a styled JButton with custom border, color, and hover effects.
     *
     * @param text The text to display on the button.
     * @return The styled JButton.
     */
    public static JButton styledButton(String text) {
        JButton button = new JButton(text);
        int spacing = 5; // Adjust for the desired spacing
        Color borderColor = Color.BLACK; // Customize border color
        int borderThickness = 3; // Customize border thickness

        // Create a CompoundBorder with EmptyBorder and customized LineBorder
        CompoundBorder border = new CompoundBorder(
                new EmptyBorder(spacing, spacing, spacing, spacing),
                new LineBorder(borderColor, borderThickness)
        );

        button.setBorder(border);

        // Make the button edges round
        int arc = 15; // Adjust for desired roundness
        button.setBorder(BorderFactory.createLineBorder(borderColor, borderThickness));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setMargin(new Insets(spacing, spacing, spacing, spacing));
        button.setForeground(borderColor);
        button.setBorderPainted(false);

        // Add a MouseListener to change the button color on hover and press
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(borderColor.brighter());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(borderColor.darker());
            }
        });

        return button;
    }

    /**
     * Gets the JFrame that contains a given component.
     *
     * @param comp The component for which to find the JFrame.
     * @return The JFrame containing the component or null if not found.
     */
    public static JFrame getFrameForComponent(Component comp) {
        if (comp == null) {
            return null;
        } else if (comp instanceof JFrame) {
            return (JFrame) comp;
        } else {
            return getFrameForComponent(comp.getParent());
        }
    }
}
