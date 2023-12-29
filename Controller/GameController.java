package Controller;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.event.KeyEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Exceptions.CheckPlayerExistException;
import GUI.GamePanel;
import Model.Dealer;
import Model.Player;
import View.ViewController;
import AdminMod.Utility;

public class GameController {

	private Dealer dealer;
	private Player player;

	private KeyEvent ea;
	private int rounds = 1;
	private final String PLAYERS_FILENAME = "./players.bin";
	private ArrayList<Player> players;

	private ViewController view;

	public GameController(ViewController viewController) {
		this.view = viewController;
		this.player = new Player("", "", 0);
		this.dealer = new Dealer();

	}

	private void loadPlayers() {
		players = new ArrayList<Player>();
		try {
			FileInputStream file = new FileInputStream("./players.bin");
			ObjectInputStream output = new ObjectInputStream(file);

			boolean endofFile = false;
			while (!endofFile) {
				try {
					Player player = (Player) output.readObject();
					players.add(player);
				} catch (EOFException ex) {
					endofFile = true;
				}
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException");
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException");
		} catch (IOException ex) {
			System.out.println("IOException");
		}

	}

	public void execute() {
		loadPlayers();
		view.login(players, player, dealer);
		if (view.getOldPlayer() != null) {
			this.player = new Player(view.getOldPlayer().getLoginName(), view.getOldPlayer().getHashedPassword(),
					view.getOldPlayer().getChips());

			rounds();

		}

		/*
		 * else if (player.getChips() <= 0) {
		 * 
		 * JOptionPane.showMessageDialog(null, "Not enough chips to start!"); }
		 */

	}

	public void rounds() {

		view.startOff(player, dealer);

		while (rounds < 5 && player.getQuit() == false && player.getChips() > 0) {
			view.dealing(dealer, player, rounds);
			betting_stage();

		}

		if (rounds == 5 && player.getQuit() == false) {

			evaluationRound();
		}

		else if (player.getChips() <= 0) {

			int i = rounds;

			for (rounds = i; rounds <= 4; rounds++) {

				view.dealing(dealer, player, rounds);

			}
			evaluationRound();
		}

	}

	private void betting_stage() {
		// --------------- IF PLAYER LAST CARD VALUE MORE---------------//
		if (player.getLastCardValue() > dealer.getLastCardValue()) {
			{
				int call = view.playerCall();

				if (call == 1) {
					saveData();
					player.setQuit();

					view.exitWindow();

				}
			}
		}
		// IF BOTH USER END UP WITH SAME VALUE
		// COMPARE SUITS
		else if (player.getLastCardValue() == dealer.getLastCardValue()) {
			player.setScoreCompare();
			dealer.setScoreCompare();

			if (player.getScoreCompare() > dealer.getScoreCompare()) {
				// PLAYER WILL BET
				int call = view.playerCall();
				if (call == 1) {
					saveData();
					player.setQuit();

					view.exitWindow();

				}
			} else {
				// DEALER WILL BET
				int follow = view.playerFollow();
				if (follow == 1) {
					saveData();
					player.setQuit();
					view.exitWindow();

				}
			}

		}
		// --------------- IF DEALER LAST CARD VALUE MORE---------------//
		else {
			// DEALER WILL BET
			// WHETHER PLAYER WILL FOLLOW
			int follow = view.playerFollow();
			if (follow == 1) {
				saveData();
				player.setQuit();
				view.exitWindow();

			}
		}
		rounds++;

	}

	private void evaluationRound() {
		boolean equal = false;
		int end = 0;

		if (player.getTotalCardsValue() > dealer.getTotalCardsValue()) {
			end = view.playerWin(player, equal);
			if (end == 0) {
				view.exitWindow();
				rounds = 1;
				dealer.refreshCards(player);
				rounds();
			} else {
				view.exitWindow();
			}
		} else if (player.getTotalCardsValue() == dealer.getTotalCardsValue()) {
			equal = true;
			end = view.playerWin(player, equal);
			if (end == 0) {
				view.exitWindow();
				rounds = 1;
				dealer.refreshCards(player);
				rounds();
			} else {
				player.setQuit();
				view.exitWindow();
			}
		} else {
			end = view.playerWin(dealer, equal);
			if (player.getChips() <= 0) {
				JOptionPane.showMessageDialog(null, "Dealer Wins!\nInsufficient chips. Thanks for playing!");
				view.exitWindow();
				return;
			} else if (end == 0) {
				view.exitWindow();
				rounds = 1;
				dealer.refreshCards(player);
				rounds();
			}

			else {
				view.exitWindow();
			}
		}
	}

	private void saveData() {

		try {
			FileOutputStream file = new FileOutputStream("./players.bin");
			ObjectOutputStream opStream = new ObjectOutputStream(file);
			players.get(view.getTarget()).setChips(player.getChips());
			for (Player player : players) {
				opStream.writeObject(player);
			}
			opStream.close();
			view.displayDataSaved();
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
