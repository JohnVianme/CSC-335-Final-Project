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
        panel.setLayout(null);
        this.add(panel);

        // Adding a window listener for closing the app.
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

    }

    private void start() {
       
        // Start with buttons that determine how many players in game.
        JButton cpuButton = new JButton("CPU");
        cpuButton.setActionCommand("cpu");
        cpuButton.addActionListener(new ButtonClickListener());
        cpuButton.setBounds(340, 200, 100, 50);
        panel.add(cpuButton);

        JButton twoPlayerButton = new JButton("Two Players");
        twoPlayerButton.setActionCommand("twoPlayer");
        twoPlayerButton.addActionListener(new ButtonClickListener());
        twoPlayerButton.setBounds(340, 300, 100, 50);
        panel.add(twoPlayerButton);

        JButton threePlayerButton = new JButton("Three Players");
        threePlayerButton.setActionCommand("threePlayer");
        threePlayerButton.addActionListener(new ButtonClickListener());
        threePlayerButton.setBounds(340, 400, 100, 50);
        panel.add(threePlayerButton);

        JButton fourPlayerButton = new JButton("Four Players");
        fourPlayerButton.setActionCommand("fourPlayer");
        fourPlayerButton.addActionListener(new ButtonClickListener());
        fourPlayerButton.setBounds(340, 500, 100, 50);
        panel.add(fourPlayerButton);

        // Also add an exit button. (In case user changes their mind about playing).
        JButton exitButton = new JButton("Exit");
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(new ButtonClickListener());
        exitButton.setBounds(650, 25, 100, 50);
        panel.add(exitButton);

        this.add(panel);

        this.revalidate();
        this.repaint();
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
        dicePanel.setBounds(100, 350, 600, 100);
        dicePanel.setLayout(new GridLayout(1, 5, 15, 0));
        this.add(dicePanel);

        this.revalidate();
        this.repaint();

    }

    /**
     * Method to create the page where scoreboard is displayed after game is completed.
     */
    private void scorePage() {
        // Wipe GUI to start from fresh slate.
        this.getContentPane().removeAll();
        this.setLayout(null);

        // Label header to tell the user the game has ended.
        JLabel overLabel = new JLabel("Game Over!");
        overLabel.setBounds(350, 25, 200, 100);
        this.add(overLabel);

        // Label to ask user if they would like to play another game.
        JLabel playAgainLabel = new JLabel("New Game?");
        playAgainLabel.setBounds(350, 400, 200, 100);
        this.add(playAgainLabel);

        // YES/NO buttons for user to decide if they want to play another game.
        JButton yesButton = new JButton("YES");
        yesButton.setActionCommand("yes");
        yesButton.addActionListener(new ButtonClickListener());
        yesButton.setBounds(336, 480, 50, 50);
        this.add(yesButton);

        JButton noButton = new JButton("NO");
        noButton.setActionCommand("no");
        noButton.addActionListener(new ButtonClickListener());
        noButton.setBounds(386, 480, 50, 50);
        this.add(noButton);

        // Text Area to display results for each of the players.
        JTextArea scoreArea = new JTextArea();
        scoreArea.setSize(400, 200);
        scoreArea.setEditable(false);
        scoreArea.setBounds(150, 100, 500, 200);
        this.add(scoreArea);

        this.setVisible(true);

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
            JLabel diceLabel = new JLabel(new ImageIcon("six.png"));
            dicePanel.add(diceLabel);
        }

        JLabel selectLabel = new JLabel("Select a Category");
        

        // Refresh the panel.
        dicePanel.revalidate();
        dicePanel.repaint();

    }

    // Click listener for the previously listed buttons.
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            // If statements to handle each game mode that is selected.

            // CPU Button
            if (command.equals("cpu")) {
                // Set up the page to prepare for the game.
                playPage();
            }
            // Two Player Button
            else if (command.equals("twoPlayer")) {
                // Set up the page to prepare for the game.
                playPage();
            }
            // Three Player Button
            else if (command.equals("threePlayer")) {
                // Set up the page to prepare for the game.
                playPage();
            }
            // Four Player Button
            else if (command.equals("fourPlayer")) {
                // Set up the page to prepare for the game.
                scorePage();
            }
            // Roll Button
            else if (command.equals("roll")) {
                // Display a new set of dice for the player and update their available rollCount.
                rollDice();
            }
            // YES Button
            else if (command.equals("yes")) {
                // Go back to the start page.
                start();
            }
            // NO Button
            else if (command.equals("no")) {
                // Exit the program.
                System.exit(0);
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


