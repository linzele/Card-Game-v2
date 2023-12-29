package View;

import java.util.ArrayList;

import Exceptions.CheckPlayerExistException;
import GUI.GameFrame;
import GUI.LoginFrame;
import GUI.QuitFrame;
import GUI.ShuffleFrame;
import Model.Dealer;
import Model.Player;
import AdminMod.Utility;

//all input and output should be done view ViewController
//so that it is easier to implement GUI later
public class ViewController {

	private int targetPlayer;
	private Player oldPlayer;

	private LoginFrame loginFrame;
	private ShuffleFrame shuffleFrame;
	private GameFrame gameFrame;
	private QuitFrame quitFrame;

	public ViewController() {
		loginFrame = new LoginFrame();
	}

	private boolean matchAccount(ArrayList<Player> players, String playerName, String password)
			throws CheckPlayerExistException {
		boolean match = false;

		for (int x = 0; x < players.size(); x++) {
			Player player = players.get(x);
			if (playerName.equals(player.getLoginName()) && player.checkPassword(password)) {
				match = true;
				this.targetPlayer = x;
			}
		}
		if (!match) {
			throw new CheckPlayerExistException("Player do not exist or wrong password");
		}
		return match;
	}

	public void login(ArrayList<Player> players, Player player, Dealer dealer) {

		while (loginFrame.getLoginPanel().getSubmit() == false) {
			String loginName = loginFrame.getLoginPanel().getUserText();
			String password = loginFrame.getLoginPanel().getPassword();
			loginFrame.getRootPane().setDefaultButton(loginFrame.getSubmitButton());

			if (loginFrame.getLoginPanel().getSubmit() == true) {
				try {
					matchAccount(players, loginName, password);
					this.oldPlayer = players.get(this.targetPlayer);
				} catch (Exception e) {

					loginFrame.getLoginPanel().displayError(e.getMessage());
					;
					loginFrame.getLoginPanel().setSubmit(false);
				}
			}
		}
	}

	public Player getOldPlayer() {
		return this.oldPlayer;
	}

	public void startOff(Player player, Dealer dealer) {
		loginFrame.dispose();
		dealer.shuffleCards();
		shuffleFrame = new ShuffleFrame();
		shuffleFrame.dispose();
		gameFrame = new GameFrame(dealer, player);

	}

	public void dealing(Dealer dealer, Player player, int rounds) {

		if (rounds == 1) {
			dealer.dealCardsTo(dealer);
			dealer.dealCardsTo(player);
			dealer.dealCardsTo(dealer);
			dealer.dealCardsTo(player);
		}

		else {
			dealer.dealCardsTo(dealer);
			dealer.dealCardsTo(player);
		}

	}

	public int playerCall() {

		int call = gameFrame.callWindow();
		return call;
	}

	public int playerFollow() {
		int follow = gameFrame.followWindow();
		return follow;
	}

	public int playerWin(Player player, boolean equal) {

		int end = gameFrame.endGameWindow(player, equal);
		return end;
	}

	public void exitWindow() {
		gameFrame.dispose();
	}

	public int getTarget() {
		return this.targetPlayer;
	}

	public void displayDataSaved() {
		System.out.println("All data has been saved successfully.");
	}

}
