import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUIView extends JFrame {
    private static Game myGame = new Game();
    private JPanel panel;
    private JLabel instructionLabel;

    public GUIView() {
        setUp();
    }

    private void setUp() {
        // Setting the size of the frame.
        this.setSize(800, 800);

        // Adding welcome label for player's first time opening view.
        instructionLabel = new JLabel("Welcome to Yahtzee! Select game mode below!");
        instructionLabel.setBounds(200, 100, 600, 100);
        this.add(instructionLabel);

        // Adding the panel.
        panel = new JPanel();
        this.add(panel);

        // Adding a window listener for closing the app.
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

    }

    private void start() {
        // Setting up the required buttons.

        // Start with buttons that determine how many players in game.
        JButton cpuButton = new JButton("CPU");
        cpuButton.setActionCommand("cpu");
        cpuButton.addActionListener(new ButtonClickListener());
        panel.add(cpuButton);

        JButton twoPlayerButton = new JButton("Two Players");
        twoPlayerButton.setActionCommand("twoPlayer");
        twoPlayerButton.addActionListener(new ButtonClickListener());
        panel.add(twoPlayerButton);

        JButton threePlayerButton = new JButton("Three Players");
        threePlayerButton.setActionCommand("threePlayer");
        threePlayerButton.addActionListener(new ButtonClickListener());
        panel.add(threePlayerButton);

        JButton fourPlayerButton = new JButton("Four Players");
        fourPlayerButton.setActionCommand("fourPlayer");
        fourPlayerButton.addActionListener(new ButtonClickListener());
        panel.add(fourPlayerButton);

        // Also add an exit button. (In case user changes their mind about playing).
        JButton exitButton = new JButton("Exit");
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(new ButtonClickListener());
        panel.add(exitButton);
    }

    // Click listener for the previously listed buttons.
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            // If statements to handle each possible command that was clicked.
        }
    }

    public static void main(String[] args) {
        GUIView view = new GUIView();
        view.start();
        view.setVisible(true);
    }
}
