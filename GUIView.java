import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
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
	private JButton rollButton;
	private JPanel heldPanel;

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

		// roll button created here for use later
		this.rollButton = new JButton("Roll");
		this.add(panel);

		this.revalidate();
		this.repaint();
	}

	/**
	 * Method to create the page where a player will play yahtzee during their turn.
	 * 
	 * @param rolls
	 * @param name
	 */
	private void playPage(String name, int rolls) {
		// Wipe GUI to start from fresh slate.
		this.getContentPane().removeAll();
		this.setLayout(null);

		// Will update playerNum label later, for now just declare its position.
		playerNumLabel = new JLabel("Current player: " + name);
		playerNumLabel.setBounds(50, 25, 200, 100);
		this.add(playerNumLabel);

		// Will update rollsRemaining count later, for now just declare its position.
		rollCountLabel = new JLabel("Rolls remaining: " + rolls);
		rollCountLabel.setBounds(650, 25, 200, 100);
		this.add(rollCountLabel);

		// Button user can click to see current scores in all categories.
		JButton scoresButton = new JButton("Score Card");
		scoresButton.setActionCommand("scorecard");
		scoresButton.addActionListener(new ButtonClickListener());
		scoresButton.setBounds(10, 700, 100, 50);
		this.add(scoresButton);

		// Display the "roll" button, which will indicate we need a new set of dice
		// displayed and decrement rollCount.
		rollButton.setActionCommand("roll");
		rollButton.addActionListener(new ButtonClickListener());
		rollButton.setBounds(340, 600, 100, 50);
		this.add(rollButton);

		// Create a panel where the dice will be displayed. Do not need to fill it yet,
		// since user has not rolled.
		dicePanel = new JPanel();
		dicePanel.setBackground(Color.RED);
		dicePanel.setBounds(100, 350, 600, 100);
		dicePanel.setLayout(new GridLayout(1, 5, 15, 0));
		this.add(dicePanel);

		heldPanel = new JPanel();
		heldPanel.setBackground(Color.GREEN);
		heldPanel.setBounds(100, 460, 600, 100);
		heldPanel.setLayout(new GridLayout(1, 5, 15, 0));
		this.add(heldPanel);

		this.revalidate();
		this.repaint();

	}

	/**
	 * Method to create the page where scoreboard is displayed after game is
	 * completed.
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
		// make the player roll their dice
		boolean ableToRoll = myGame.currRollDice();
		// get the result of the roll
		ArrayList<DiceEnum> curHand = myGame.getPlayerHand();
		String result = "Just rolled: ";
		for (DiceEnum adice : curHand) {
			result += adice.getValue() + " ";
		}
		System.out.println(result);
		// Retrieve five random dice from the model, and add each to the panel.
		for (int i = 0; i < 5; i++) {
			// Update later with functionality.
			JLabel diceLabel = new JLabel();
			// set diceLabel name
			diceLabel.setName(curHand.get(i).name());
			// get name of dice
			String diceName = curHand.get(i).name().toLowerCase() + ".png";
			// get icon for the dice
			ImageIcon DiceIcon = new ImageIcon(
					new ImageIcon(diceName).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			diceLabel.setIcon(DiceIcon);
			giveLabelClick(diceLabel, myGame.getPlayerHand());

			dicePanel.add(diceLabel);

		}
		// update rollsRemaining
		rollCountLabel.setText("Rolls remaining: " + myGame.getRollCount());
		rollCountLabel.revalidate();
		rollCountLabel.repaint();

		JLabel selectLabel = new JLabel("Select a Category");

		// Refresh the panel.
		dicePanel.revalidate();
		dicePanel.repaint();
		heldPanel.revalidate();
		heldPanel.repaint();

	}

	// test for giving label functionality
	private void giveLabelClick(JLabel diceLabel, ArrayList<DiceEnum> curHand) {
		diceLabel.addMouseListener(new MouseAdapter() {
			// if we click a label, we want move it a new list of held dices
			public void mouseClicked(MouseEvent e) {
				String diceName = diceLabel.getName();
				boolean isHead = hasLabel(diceLabel);
				DiceEnum theDice = DiceEnum.valueOf(diceName);
				if (!isHead) {
					switch (diceName) {
					case "ONE":
						heldPanel.add(diceLabel);
						dicePanel.remove(diceLabel);

						break;
					case "TWO":
						heldPanel.add(diceLabel);
						dicePanel.remove(diceLabel);

						break;
					case "THREE":
						heldPanel.add(diceLabel);
						dicePanel.remove(diceLabel);

						break;
					case "FOUR":
						heldPanel.add(diceLabel);
						dicePanel.remove(diceLabel);

						break;
					case "FIVE":
						heldPanel.add(diceLabel);
						dicePanel.remove(diceLabel);

						break;
					case "SIX":
						heldPanel.add(diceLabel);
						dicePanel.remove(diceLabel);

						break;
					}
					myGame.curSetHold(theDice);

				} else {
					switch (diceName) {
					case "ONE":
						dicePanel.add(diceLabel);
						heldPanel.remove(diceLabel);

						break;
					case "TWO":
						dicePanel.add(diceLabel);
						heldPanel.remove(diceLabel);

						break;
					case "THREE":
						dicePanel.add(diceLabel);
						heldPanel.remove(diceLabel);

						break;
					case "FOUR":
						dicePanel.add(diceLabel);
						heldPanel.remove(diceLabel);

						break;
					case "FIVE":
						dicePanel.add(diceLabel);
						heldPanel.remove(diceLabel);

						break;
					case "SIX":
						dicePanel.add(diceLabel);
						heldPanel.remove(diceLabel);

						break;
					}
					myGame.curRemoveHold(theDice);

				}
				heldPanel.revalidate();
				heldPanel.repaint();
				dicePanel.revalidate();
				dicePanel.repaint();
			}

			private boolean hasLabel(JLabel diceLabel) {
				for (java.awt.Component component : heldPanel.getComponents()) {
					if (component.equals(diceLabel)) {
						System.out.println("Already Held");
						return true;
					}
				}
				return false;
			}
		});

	}

	// Click listener for the previously listed buttons.
	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			// If statements to handle each game mode that is selected.

			// CPU Button
			if (command.equals("cpu")) {
				myGame.addPlayer("Player 1");
				myGame.addPlayer("CPU");
				String name = myGame.getCurName();
				int rolls = myGame.getRollCount();
				// Set up the page to prepare for the game.
				playPage(name, rolls);
			}
			// Two Player Button
			else if (command.equals("twoPlayer")) {
				myGame.addPlayer("Player 1");
				myGame.addPlayer("Player 2");
				String name = myGame.getCurName();
				int rolls = myGame.getRollCount();
				// Set up the page to prepare for the game.
				playPage(name, rolls);
			}
			// Three Player Button
			else if (command.equals("threePlayer")) {
				myGame.addPlayer("Player 1");
				myGame.addPlayer("Player 2");
				myGame.addPlayer("Player 3");
				String name = myGame.getCurName();
				int rolls = myGame.getRollCount();
				// Set up the page to prepare for the game.
				playPage(name, rolls);
			}
			// Four Player Button
			else if (command.equals("fourPlayer")) {
				myGame.addPlayer("Player 1");
				myGame.addPlayer("Player 2");
				myGame.addPlayer("Player 3");
				myGame.addPlayer("Player 4");
				String name = myGame.getCurName();
				int rolls = myGame.getRollCount();
				// Set up the page to prepare for the game.
				playPage(name, rolls);
			}
			// Roll Button
			else if (command.equals("roll")) {
				// Display a new set of dice for the player and update their available
				// rollCount.
				rollDice();
				// disable button if no more rolls left
				if (myGame.getRollCount() == 0) {
					rollButton.setEnabled(false);
				}
				// clear heldDice Panle
				heldPanel.removeAll();
				heldPanel.revalidate();
				heldPanel.repaint();
			}
			// YES Button
			else if (command.equals("yes")) {
				// Go back to the start page.
				dispose();
				GUIView.main(null);
			}
			// NO Button
			else if (command.equals("no")) {
				// Exit the program.
				System.exit(0);
			}
			// Score Card Button
			else if (command.equals("scorecard")) {
				// Pop up window for user to view possible Yahtzee scores.
				String scoresString = getScoresString();
				JTextArea scoreArea = new JTextArea(scoresString);
				JOptionPane.showMessageDialog(null, scoreArea);
			}
			// Close the program.
			else if (command.equals("exit")) {
				System.exit(0);
			}
		}
	}

	private String getScoresString() {
		// Create arraylist of all possible categories, IN ORDER.
		ArrayList<Category> allCategories = new ArrayList<Category>();
		allCategories.add(Category.ONES);
		allCategories.add(Category.TWOS);
		allCategories.add(Category.THREES);
		allCategories.add(Category.FOURS);
		allCategories.add(Category.FIVES);
		allCategories.add(Category.SIXES);
		allCategories.add(Category.THREEOFKIND);
		allCategories.add(Category.FOUROFKIND);
		allCategories.add(Category.FULLHOUSE);
		allCategories.add(Category.SMALLSTRAIGHT);
		allCategories.add(Category.LARGESTRAIGHT);
		allCategories.add(Category.YAHTZEE);
		allCategories.add(Category.CHANCE);
		String result = "";
		for (Category cat : allCategories) {
			// Add each category, followed by current player's score in that category.
			result += cat.name() + " : ";
			result += myGame.getCategoryScore(cat) + "\n";
		}

		return result;

	}

	public static void main(String[] args) {
		GUIView view = new GUIView();
		view.start();
		view.setVisible(true);
	}
}
