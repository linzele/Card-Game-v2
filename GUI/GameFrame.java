package GUI;

import java.util.ConcurrentModificationException;

import javax.swing.JFrame;

import Model.Dealer;
import Model.Player;

public class GameFrame extends JFrame {

	private GamePanel gamePanel;
	private Dealer dealer;
	private Player player;

	public GameFrame(Dealer dealer, Player player) {
		this.dealer = dealer;
		this.player = player;
		gamePanel = new GamePanel(dealer, player);

		add(gamePanel);
		setTitle("HighSum Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void updateGameTable() {

		gamePanel.repaint();

	}

	public int callWindow() {
		pause();
		int call = gamePanel.callOrQuit();

		if (call == 0) {

			gamePanel.whenCall();
			pause();
			updateGameTable();
			gamePanel.setPlayerBalance();
		}

		return call;

	}

	public int followWindow() {
		pause();
		int follow = gamePanel.followOrQuit();

		if (follow == 0) {

			gamePanel.whenFollow();
			pause();
			updateGameTable();
			gamePanel.setPlayerBalance();
		}

		return follow;

	}

	public int endGameWindow(Player player, boolean equal) {
		gamePanel.revealDealerScore();
		int end = gamePanel.nextGameOrQuit(player, equal);
		return end;
	}

	public String promptPassword() {
		String password = gamePanel.enterPasswordWindow();
		return password;
	}

	public void pause() {
		try {
			Thread.sleep(1000);

		} catch (Exception e) {
		}
	}

}
