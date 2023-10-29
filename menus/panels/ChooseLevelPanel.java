package menus.panels;

import inputs.buttonListeners.ChooseLevelButtonListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static menus.GlobalMethods.styledButton;

/**
 * Represents the panel for choosing a game level.
 */
public class ChooseLevelPanel extends JPanel {
    private JButton lvlOne;
    private JButton lvlTwo;
    private JButton lvlThree;
    private JButton returnToMenu;
    private final ChooseLevelButtonListener chooseLevelButtonListener;
    private final JLabel chooseLevelLabel;

    /**
     * Creates a new ChooseLevelPanel.
     */
    public ChooseLevelPanel() {
        // Set up the layout and dimensions of the panel
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(480, 640));

        GridBagConstraints gbc = new GridBagConstraints();

        // Create a button listener for level selection
        chooseLevelButtonListener = new ChooseLevelButtonListener(this);
        chooseLevelLabel = new JLabel("Choose your level!");

        returnToMenu = styledButton("Return to menu");
        lvlOne = styledButton("Level One");
        lvlTwo = styledButton("Level Two");
        lvlThree = styledButton("Level Three");

        // Attach action listeners to buttons
        lvlOne.addActionListener(chooseLevelButtonListener);
        lvlTwo.addActionListener(chooseLevelButtonListener);
        lvlThree.addActionListener(chooseLevelButtonListener);
        returnToMenu.addActionListener(chooseLevelButtonListener);

        // Set up grid constraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Add components to the panel
        gbc.gridy += 1;
        this.add(chooseLevelLabel, gbc);

        gbc.gridy += 1;
        this.add(lvlOne, gbc);

        gbc.gridy += 1;
        this.add(lvlTwo, gbc);

        gbc.gridy += 1;
        this.add(lvlThree, gbc);

        gbc.gridy += 1;
        this.add(returnToMenu, gbc);

        // Set borders, sizes, and visibility
        chooseLevelLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        chooseLevelLabel.setSize(40, 40);

        chooseLevelLabel.setVisible(true);
        lvlOne.setVisible(true);
        lvlTwo.setVisible(true);
        lvlThree.setVisible(true);
        returnToMenu.setVisible(true);
    }

    /**
     * Get the "Level One" button.
     *
     * @return The "Level One" button.
     */
    public JButton getLvlOne() {
        return lvlOne;
    }

    /**
     * Get the "Level Two" button.
     *
     * @return The "Level Two" button.
     */
    public JButton getLvlTwo() {
        return lvlTwo;
    }

    /**
     * Get the "Level Three" button.
     *
     * @return The "Level Three" button.
     */
    public JButton getLvlThree() {
        return lvlThree;
    }

    /**
     * Get the "Return to Menu" button.
     *
     * @return The "Return to Menu" button.
     */
    public JButton getReturnToMenu() {
        return returnToMenu;
    }
}
