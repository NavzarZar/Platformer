package menus.panels;

import inputs.buttonListeners.ChooseLevelButtonListener;
import inputs.buttonListeners.StartMenuButtonListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static menus.GlobalMethods.styledButton;

/**
 *
 */
public class ChooseLevelPanel extends JPanel {
    private JButton lvlOne;
    private JButton lvlTwo;
    private JButton lvlThree;
    private JButton returnToMenu;
    private final ChooseLevelButtonListener chooseLevelButtonListener;
    private final JLabel chooseLevelLabel;

    public ChooseLevelPanel()
    {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(480, 640));

        GridBagConstraints gbc = new GridBagConstraints();

        chooseLevelButtonListener = new ChooseLevelButtonListener(this);
        chooseLevelLabel = new JLabel("Choose your level!");

        returnToMenu = styledButton("Return to menu");
        lvlOne = styledButton("Level One");
        lvlTwo = styledButton("Level Two");
        lvlThree = styledButton("Level Three");

        lvlOne.addActionListener(chooseLevelButtonListener);
        lvlTwo.addActionListener(chooseLevelButtonListener);
        lvlThree.addActionListener(chooseLevelButtonListener);
        returnToMenu.addActionListener(chooseLevelButtonListener);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

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


        chooseLevelLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        chooseLevelLabel.setSize(40, 40);

        chooseLevelLabel.setVisible(true);
        lvlOne.setVisible(true);
        lvlTwo.setVisible(true);
        lvlThree.setVisible(true);
        returnToMenu.setVisible(true);

    }

    public JButton getLvlOne() {
        return lvlOne;
    }

    public JButton getLvlTwo() {
        return lvlTwo;
    }

    public JButton getLvlThree() {
        return lvlThree;
    }

    public JButton getReturnToMenu() {
        return returnToMenu;
    }
}
