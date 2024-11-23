import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUIView extends JFrame {
    private static Game myGame = new Game();
    private JPanel panel;
    private JLabel instructionLabel;
    private JLabel playerNumLabel;
    private JLabel rollCountLabel;
    private JLabel scoreLabel;
    private JPanel dicePanel;

    public GUIView() {
        setUp();
    }

    private void setUp() {
        // Setting the size of the frame.
        this.setSize(800, 800);

        // Adding welcome label for player's first time opening view.
        instructionLabel = new JLabel("Welcome to Yahtzee! Select game mode below.");
        instructionLabel.setBounds(250, 100, 600, 100);
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

    /**
     * Method to create the page where a player will play yahtzee during their turn.
     */
    private void playPage() {
        // Wipe GUI to start from fresh slate.
        this.getContentPane().removeAll();
        this.setLayout(null);

        // Will update playerNum label later, for now just declare its position.
        playerNumLabel = new JLabel("Current player: ");
        playerNumLabel.setBounds(50, 25, 200, 100);
        this.add(playerNumLabel);

        // Will update rollsRemaining count later, for now just declare its position.
        rollCountLabel = new JLabel("Rolls remaining: ");
        rollCountLabel.setBounds(650, 25, 200, 100);
        this.add(rollCountLabel);

        // Display the "roll" button, which will indicate we need a new set of dice displayed and decrement rollCount.
        JButton rollButton = new JButton("Roll");
        rollButton.setActionCommand("roll");
        rollButton.addActionListener(new ButtonClickListener());
        rollButton.setBounds(340, 600, 100, 50);
        this.add(rollButton);

        // Create a panel where the dice will be displayed. Do not need to fill it yet, since user has not rolled.
        dicePanel = new JPanel();
        dicePanel.setBounds(50, 350, 600, 200);
        dicePanel.setLayout(new GridLayout(1, 5, 15, 0));
        this.add(dicePanel);

        this.revalidate();
        this.repaint();

    }

    /**
     * When user clicks roll button, display new dice and update rollCountLabel.
     */
    private void rollDice() {
        // Get rid of existing dice. (If any).
        dicePanel.removeAll();

        // Retrieve five random dice from the model, and add each to the panel.
        for (int i = 0; i < 5; i++) {
            // For now, add one picture to make sure it is appearing in GUI.
            // Update later with functionality.
            
        }

    }

    // Click listener for the previously listed buttons.
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            // If statements to handle each game mode that is selected.

            // Create game object with one player.
            if (command.equals("cpu")) {
                // Set up the page to prepare for the game.
                playPage();
            }
            // Create game object with two players.
            else if (command.equals("twoPlayer")) {
                // Set up the page to prepare for the game.
                playPage();
            }
            // Create game object with three players.
            else if (command.equals("threePlayer")) {
                // Set up the page to prepare for the game.
                playPage();
            }
            // Create game object with four players.
            else if (command.equals("fourPlayer")) {
                // Set up the page to prepare for the game.
                playPage();
            }
            // Display a new set of dice for the player and update their available rollCount.
            else if (command.equals("roll")) {
                rollDice();
            }
            // Close the program.
            else if (command.equals("exit")) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        GUIView view = new GUIView();
        view.start();
        view.setVisible(true);
    }
}

