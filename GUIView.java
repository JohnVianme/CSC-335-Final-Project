import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class GUIView extends JFrame {
	private JButton easyModebutton;
	private JButton hardModebutton;

	private static Game myGame;
	private JPanel panel;
	private JLabel instructionLabel;
	private JLabel playerNumLabel;
	private JLabel rollCountLabel;
	private JLabel scoreLabel;
	private JPanel dicePanel;
	private JButton rollButton;
	private JPanel heldPanel;
	private JComboBox<String> catOptions;

	public GUIView() {
		setUp();
		myGame = new Game();
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

		// Also add cpu buttons
		this.easyModebutton = new JButton("Easy Mode");
		easyModebutton.setActionCommand("easy");
		easyModebutton.addActionListener(new ButtonClickListener());
		easyModebutton.setBounds(500, 200, 100, 50);
		easyModebutton.setEnabled(false);
		easyModebutton.setVisible(false);
		panel.add(easyModebutton);

		this.hardModebutton = new JButton("Hard Mode");
		hardModebutton.setActionCommand("hard");
		hardModebutton.addActionListener(new ButtonClickListener());
		hardModebutton.setBounds(500, 250, 100, 50);
		hardModebutton.setEnabled(false);
		hardModebutton.setVisible(false);
		panel.add(hardModebutton);

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

		// if current player is Hard Mode CPU
		if (myGame.getCurName().equals("HARD CPU")) {
			HardCpuTurn();

			// if current player is Hard Mode CPU
		} else if (myGame.getCurName().equals("EASY CPU")) {
			EasyCpuTurn();
		} else {
			// Display the "roll" button, which will indicate we need a new set of dice
			// displayed and decrement rollCount.
			rollButton.setActionCommand("roll");
			// if rollButton has action listion listener do not add another
			if (rollButton.getActionListeners().length < 1) {
				rollButton.addActionListener(new ButtonClickListener());
			}
			// rollButton.addActionListener(new ButtonClickListener());
			rollButton.setBounds(340, 600, 100, 50);
			this.add(rollButton);

			// Create a panel where the dice will be displayed. Do not need to fill it yet,
			// since user has not rolled.
			dicePanel = new JPanel();
			dicePanel.setBackground(Color.RED);
			dicePanel.setBounds(100, 350, 600, 100);
			dicePanel.setLayout(new GridLayout(1, 5, 15, 0));
			this.add(dicePanel);

			// Create a label to help user recognize their current hand.
			JLabel currentLabel = new JLabel("Current Hand: ");
			currentLabel.setBounds(10, 355, 100, 100);
			currentLabel.setForeground(Color.RED);
			this.add(currentLabel);

			heldPanel = new JPanel();
			heldPanel.setBackground(Color.GREEN);
			heldPanel.setBounds(100, 460, 600, 100);
			heldPanel.setLayout(new GridLayout(1, 5, 15, 0));
			this.add(heldPanel);

			// Create a label to help user recognize the current dice they are holding.
			JLabel heldLabel = new JLabel("Dice Held: ");
			heldLabel.setBounds(10, 470, 100, 100);
			heldLabel.setForeground(Color.GREEN);
			this.add(heldLabel);

			this.revalidate();
			this.repaint();
		}

	}

	/*
	 * Helper method to display the Hard CPU's roll and selected category.
	 */
	private void HardCpuTurn() {
		myGame.currRollDice();
		// Create a panel where the dice will be displayed. Do not need to fill it yet,
		// since user has not rolled.
		dicePanel = new JPanel();
		dicePanel.setBackground(Color.RED);
		dicePanel.setBounds(100, 350, 600, 100);
		dicePanel.setLayout(new GridLayout(1, 5, 15, 0));
		this.add(dicePanel);

		// Do not need to display the rollCount for the CPU.
		rollCountLabel.setText("");

		// get the result of the roll
		ArrayList<DiceEnum> curHand = myGame.getPlayerHand();

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
		// Get the first category available, since this is the EASY CPU.
		Category cpuCategory = myGame.getCPUBestCat();

		// Create button to let user go to next player now that CPU is done.
		JButton nextButton = new JButton("Next");
		nextButton.setActionCommand("Next");
		nextButton.addActionListener(new ButtonClickListener());
		nextButton.setBounds(680, 700, 100, 50);
		this.add(nextButton);

		// Label to show the Easy CPU's selected category.
		// Add label above dropdown menu of categories.
		JLabel catLabel = new JLabel("HARD CPU selected category: " + cpuCategory.name());
		catLabel.setBounds(250, 670, 400, 50);
		this.add(catLabel);

		this.revalidate();
		this.repaint();

	}

	/*
	 * Helper method to display the Easy CPU's roll and selected category.
	 */
	private void EasyCpuTurn() {
		myGame.currRollDice();
		// Create a panel where the dice will be displayed. Do not need to fill it yet,
		// since user has not rolled.
		dicePanel = new JPanel();
		dicePanel.setBackground(Color.RED);
		dicePanel.setBounds(100, 350, 600, 100);
		dicePanel.setLayout(new GridLayout(1, 5, 15, 0));
		this.add(dicePanel);

		// Do not need to display the rollCount for the CPU.
		rollCountLabel.setText("");

		// get the result of the roll
		ArrayList<DiceEnum> curHand = myGame.getPlayerHand();

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

		// Get the first category available, since this is the EASY CPU.
		Category cpuCategory = myGame.getEasyCPUCat();

		// Create button to let user go to next player now that CPU is done.
		JButton nextButton = new JButton("Next");
		nextButton.setActionCommand("Next");
		nextButton.addActionListener(new ButtonClickListener());
		nextButton.setBounds(680, 700, 100, 50);
		this.add(nextButton);

		// Label to show the Easy CPU's selected category.
		// Add label above dropdown menu of categories.
		JLabel catLabel = new JLabel("EASY CPU selected category: " + cpuCategory.name());
		catLabel.setBounds(250, 670, 400, 50);
		this.add(catLabel);

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
		scoreArea.setSize(200, 100);
		scoreArea.setEditable(false);
		scoreArea.setBounds(340, 150, 100, 200);
		// This is where we need to add the concatenated string of each player and their
		// scores.
		String scoreText = getScoreText();
		scoreArea.setText(scoreText);
		this.add(scoreArea);

		this.setVisible(true);

		this.revalidate();
		this.repaint();

	}

	/*
	 * Private helper method to retrieve every player's name along with their
	 * associated score. Add to string in order
	 * 
	 * @return concatenated string of every player and their score.
	 */
	private String getScoreText() {
		// Create map to store each player and their score.
		HashMap<Integer, String> scoreMap = new HashMap<>();
		// Iterate through each player in the current game. Add name and current score
		// to the string.
		int playerCount = myGame.getPlayerAmount();
		// Add each name/score pair to the map.
		for (int i = 0; i < playerCount; i++) {
			myGame.setCurrIdx(i);
			int currScore = myGame.getTotalScore();
			String currName = myGame.getCurName();
			scoreMap.put(currScore, currName);

		}

		// Get all of the total score keys and sort them.
		List<Integer> scoreKeys = new ArrayList<>(scoreMap.keySet());
		Collections.sort(scoreKeys);

		// Add each of the players to the concatenated result string.
		// In order of DESCENDING scores. (So player with highest score is at top).
		// Start with an empty string.
		String scoreText = "";
		for (int i = scoreKeys.size() - 1; i >= 0; i--) {
			int scoreNum = scoreKeys.get(i);
			String playerName = scoreMap.get(scoreNum);
			scoreText += playerName + ": " + scoreNum + "\n";
		}
		return scoreText;
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

		// Create button to let user submit their hand. (Marked as latest category
		// selected.)
		JButton submitButton = new JButton("Submit Hand");
		submitButton.setActionCommand("submit");
		submitButton.addActionListener(new ButtonClickListener());
		submitButton.setBounds(680, 700, 100, 50);
		this.add(submitButton);

		// Click listener for the combo box of available player categories.

		// Get all unselected and valid categories player can choose from.
		String[] unfilledCats = myGame.getCurPlayerCategories();
		// remove old catOptions if existed
		if (catOptions != null) {
			this.remove(catOptions);
		}
		String resultString = "Unfilled Cat: ";
		for (int i = 0; i < unfilledCats.length; i++) {
			resultString = unfilledCats[i] + " ";
		}
		System.out.println(resultString);
		catOptions = new JComboBox<String>(unfilledCats);
		catOptions.setBounds(340, 700, 100, 50);
		catOptions.setEditable(false);
		this.add(catOptions);

		// Add label above dropdown menu of categories.
		JLabel catLabel = new JLabel("Select Category");
		catLabel.setBounds(340, 670, 200, 50);
		this.add(catLabel);

		// Refresh each element of GUI.
		dicePanel.revalidate();
		dicePanel.repaint();
		heldPanel.revalidate();
		heldPanel.repaint();
		this.revalidate();
		this.repaint();

	}

	// test for giving label functionality
	private void giveLabelClick(JLabel diceLabel, ArrayList<DiceEnum> curHand) {
		diceLabel.addMouseListener(new MouseAdapter() {
			// if we click a label, we want move it a new list of held dices
			public void mouseClicked(MouseEvent e) {
				String diceName = diceLabel.getName();
				boolean isHead = hasLabel(diceLabel);
				DiceEnum theDice = DiceEnum.valueOf(diceName);
				// if we have not held this dice before
				if (!isHead) {
					// add dice to held hand
					heldPanel.add(diceLabel);
					dicePanel.remove(diceLabel);
					myGame.curSetHold(theDice);
					// if dice is heald
				} else {
					// remove from held and add back to regular hand
					dicePanel.add(diceLabel);
					heldPanel.remove(diceLabel);
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
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			// If statements to handle each game mode that is selected.

			// CPU Button
			if (command.equals("cpu")) {
				myGame.addPlayer("Player 1");
				hardModebutton.setVisible(true);
				hardModebutton.setEnabled(true);
				easyModebutton.setVisible(true);
				easyModebutton.setEnabled(true);
			}
			// Two Player Button
			else if (command.equals("easy")) {
				myGame.addPlayer(new CPU("EASY CPU", CpuMode.EASY));
				String name = myGame.getCurName();
				int rolls = myGame.getRollCount();
				// Set up the page to prepare for the game.
				playPage(name, rolls);
			}
			// Two Player Button
			else if (command.equals("hard")) {
				myGame.addPlayer(new CPU("HARD CPU", CpuMode.HARD));
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
				scoreArea.setEditable(false);
				JOptionPane.showMessageDialog(null, scoreArea);
			}
			// Submit Hand Button
			else if (command.equals("submit")) {
				// If the user has not selected a category yet, they cannot submit their hand.
				// Get the most recently selected item in the combo box.
				String selected = (String) catOptions.getSelectedItem();
				System.out.println("Just selected: " + selected);
				if (selected.equals(null)) {
					JTextArea warningArea = new JTextArea("Please select category before submitting hand");
					warningArea.setEditable(false);
					JOptionPane.showMessageDialog(null, warningArea);
				}
				// get the selected cat category
				Category selectedCategory = Category.valueOf(selected);
				// make the current player submit their Hand
				boolean result = myGame.submitHand(selectedCategory);
				// If the user was able to submit, continue game with next turn.
				if (result == true) {
					nextTurn();
				}
				// If the user cannot submit anymore, game is over.
				else {
					scorePage();
				}
			}
			// Submit Hand Button
			else if (command.equals("Next")) {
				// If the user has not selected a category yet, they cannot submit their hand.
				// Get the most recently selected item in the combo box.
				// catOptions.setSelectedItem(e);
				String selected = "";
				if (myGame.getCurName().equals("HARD CPU")) {
					selected = myGame.getCPUBestCat().name();

				} else {
					selected = myGame.getEasyCPUCat().name();

				}
				System.out.println("CPU selected: " + selected);
				if (selected.equals(null)) {
					JTextArea warningArea = new JTextArea("Please select category before submitting hand");
					warningArea.setEditable(false);
					JOptionPane.showMessageDialog(null, warningArea);
				}
				// get the selected cat category
				Category selectedCategory = Category.valueOf(selected);
				// make the current player submit their Hand
				boolean result = myGame.submitHand(selectedCategory);
				// If the user was able to submit, continue game with next turn.
				if (result == true) {
					nextTurn();
				}
				// If the user cannot submit anymore, game is over.
				else {
					scorePage();
				}
			}
			// Close the program.
			else if (command.equals("exit")) {
				System.exit(0);
			}
		}
	}

	public void nextTurn() {
		this.playPage(myGame.getCurName(), myGame.getRollCount());
		this.revalidate();
		this.repaint();
		rollButton.setEnabled(true);

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
			if (!Arrays.asList(myGame.getCurPlayerCategories()).contains(cat.name())) {
				result += cat.name() + " (✓) : ";
			} else {
				result += cat.name() + " : ";
			}
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
