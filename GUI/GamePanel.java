package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ConcurrentModificationException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Exceptions.BetAmountException;
import Model.Card;
import Model.Dealer;
import Model.Player;
import AdminMod.Utility;
import javax.swing.*;
import View.*;

public class GamePanel extends JPanel {

	private int chipsOnTable;

	private Player player;
	private Dealer dealer;
	private ViewController view;
	private ImageIcon deckPic;
	private ImageIcon cardBackImage;
	private ImageIcon chipsPicture;
	private int rounds;
	private JLabel deck;
	private JLabel deckName;
	private JLabel dealerName;
	private JLabel dealerScore;

	private JLabel chipsPic;
	private JLabel chipsValue;

	private JLabel playerName;
	private JLabel playerCardValue;
	private JLabel playerBalance;

	public GamePanel(Dealer dealer, Player player) {
		super();
		setLayout(null);
		setBackground(Color.decode("#35654d"));
		this.dealer = dealer;
		this.player = player;
		cardBackImage = new ImageIcon("./images/back.png");
		deckPic = new ImageIcon("./images/deck.png");
		chipsPicture = new ImageIcon("./images/chips.jpg");
		this.rounds = 1;
		setPreferredSize(new Dimension(1361, 1002));
		addDeckImg();
		addChipsToTable();
		displayNames();
	}

	public int enterBetAmount() throws BetAmountException {
		String betAmount = JOptionPane.showInputDialog(this, "Player call, enter you bet amount");
		int betAmountValue = Integer.valueOf(betAmount);

		if (betAmountValue <= 0) {
			throw new BetAmountException("Bet amount cannot be less than 0!");
		}

		if (betAmountValue > player.getChips()) {
			throw new BetAmountException("Insufficient chips to bet");
		}

		return betAmountValue;
	}

	public int callOrQuit() {
		String[] customResponse = { "Call", "Quit" };
		int response = JOptionPane.showOptionDialog(this, "Do you want to Call or Quit?", "HighSum Game",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, customResponse, 0);

		return response;

	}

	public void whenCall() {

		boolean correct_num = false;
		while (!correct_num) {
			try {
				int betAmount = enterBetAmount();
				correct_num = true;
				player.deductChips(betAmount);
				rounds += 1;
				chipsOnTable += ((betAmount * 2));
				setTableChips();
			}

			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Please enter a numerical value!", "Error",
						JOptionPane.ERROR_MESSAGE);

			}

			catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	public int followOrQuit() {
		String[] customResponse = { "Follow", "Quit" };
		int response = JOptionPane.showOptionDialog(this, "Dealer Call, place 10 chips", "HighSum Game",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, customResponse, 0);

		return response;

	}

	public void revealDealerScore() {
		dealerScore = new JLabel();
		dealerScore.setText("Value: " + dealer.getTotalCardsValue());
		dealerScore.setBounds(472, 277, 139, 18);
		dealerScore.setFont(new Font("Serif", Font.BOLD, 20));
		add(dealerScore);
	}

	public void whenFollow() {
		rounds += 1;
		player.deductChips(10);
		chipsOnTable += 20;
		setTableChips();
	}

	public int nextGameOrQuit(Player player, boolean equal) {
		if (!equal) {
			player.addChips(chipsOnTable);
			setPlayerBalance();
			if (player.getChips() <= 0) {
				JOptionPane.showMessageDialog(this, "Insufficient chips. Thanks for playing!");
				player.setQuit();
				view.exitWindow(); // Return 'Quit' option to end the game
			}
			String[] customResponse = { "Play Now!", "Quit" };
			int response = JOptionPane.showOptionDialog(this, player.getLoginName() + " Wins! Next Game?",
					"HighSum Game", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, customResponse,
					0);

			return response;
		} else {
			player.addChips(chipsOnTable / 2);
			setPlayerBalance();
			if (player.getChips() <= 0) {
				JOptionPane.showMessageDialog(this, "Insufficient chips to continue. Thanks for playing!");
				player.setQuit();
				view.exitWindow();// Return 'Quit' option to end the game
			}
			String[] customResponse = { "Play Now!", "Quit" };
			int response = JOptionPane.showOptionDialog(this, "Both players Tie!", "HighSum Game",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, customResponse, 0);

			return response;
		}
	}

	public void addDeckImg() {
		deck = new JLabel();
		deck.setIcon(deckPic);
		deck.setBounds(62, 63, 140, 194);
		add(deck);
		deckName = new JLabel();
		deckName.setText("Deck");
		deckName.setBounds(89, 278, 139, 18);
		deckName.setFont(new Font("Serif", Font.BOLD, 20));
		add(deckName);
	}

	public void addChipsToTable() {
		chipsPic = new JLabel();
		chipsPic.setIcon(chipsPicture);
		chipsPic.setBounds(60, 350, 150, 150);
		add(chipsPic);
		chipsValue = new JLabel();
		chipsValue.setText("Chips on Table: 0");
		chipsValue.setBounds(50, 507, 188, 39);
		chipsValue.setFont(new Font("Serif", Font.BOLD, 20));
		add(chipsValue);
	}

	public void displayNames() {
		dealerName = new JLabel();
		dealerName.setBounds(279, 277, 139, 18);
		dealerName.setText(dealer.getLoginName());
		dealerName.setFont(new Font("Serif", Font.BOLD, 20));
		add(dealerName);
		playerName = new JLabel();
		playerName.setBounds(279, 720, 139, 18);
		playerName.setText(player.getLoginName());
		playerName.setFont(new Font("Serif", Font.BOLD, 20));
		add(playerName);
		playerCardValue = new JLabel();
		playerCardValue.setBounds(279, 749, 139, 18);
		playerCardValue.setText("Value: " + player.getTotalCardsValue());
		playerCardValue.setFont(new Font("Serif", Font.BOLD, 20));
		add(playerCardValue);
		playerBalance = new JLabel();
		playerBalance.setBounds(458, 720, 213, 20);
		playerBalance.setText("Balance chips: " + player.getChips());
		playerBalance.setFont(new Font("Serif", Font.BOLD, 20));
		add(playerBalance);
	}

	public void paintComponent(Graphics g) {

		try {
			super.paintComponent(g);
			int x_axis = 272;
			int y_axis = 63;

			int i = 0;

			{
				for (Card c : dealer.getCardsOnHand()) {
					if (i == 0d) {
						cardBackImage.paintIcon(this, g, x_axis, y_axis);
						i++;
					}

					else {
						c.paintIcon(this, g, x_axis, y_axis);

					}
					x_axis += 200;
				}
			}

			// FOR PLAYER SIDE
			x_axis = 272;
			y_axis = 500;
			for (Card c : player.getCardsOnHand()) {
				c.paintIcon(this, g, x_axis, y_axis);
				x_axis += 200;

			}

			playerCardValue.setText("Value: " + player.getTotalCardsValue());

			if ((rounds >= 5) || (player.getChips() <= 0)) {
				x_axis = 272;
				y_axis = 63;
				for (Card c : dealer.getCardsOnHand()) {
					c.paintIcon(this, g, x_axis, y_axis);
					x_axis += 200;

				}
			}

		}

		catch (ConcurrentModificationException e) {
			pause();
		}

	}

	public void setPlayerBalance() {
		playerBalance.setText("Balance chips: " + player.getChips());
		repaint();
	}

	public void setTableChips() {
		chipsValue.setText("Chips on table: " + chipsOnTable);
		repaint();
	}

	private void pause() {
		try {
			Thread.sleep(1000);

		} catch (Exception e) {
		}
	}

	public String enterPasswordWindow() {

		String password = JOptionPane.showInputDialog(this, "Please enter your password to quit the game: ");
		return password;

	}

}
