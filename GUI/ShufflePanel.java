package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShufflePanel extends JPanel {

	private ImageIcon cardBackImage;
	private ImageIcon shuffleImage;

	private Timer timer;
	private int cardIndex;
	private JLabel[] cardLoading;

	private JLabel shuffle;
	private JLabel shuffleWords;
	private JLabel cardBack;

	public ShufflePanel() {
		super();
		setLayout(null);
		setBackground(Color.decode("#35654d"));
		setPreferredSize(new Dimension(1024, 768));

		this.shuffleImage = new ImageIcon("images/shuffle.gif");
		//this.cardBackImage = new ImageIcon("./images/Cards.gif");

		// IMAGE OF SHUFFLE INSIDE LABEL
		shuffle = new JLabel();
		shuffle.setBounds(362, 158, 300, 168);
		shuffle.setIcon(shuffleImage);
		add(shuffle);

		// WORDS OF SHUFFLING INSIDE SHUFFLEWORDS
		shuffleWords = new JLabel("Shuffling.......");
		shuffleWords.setBounds(463, 366, 139, 18);
		shuffleWords.setFont(new Font("Serif", Font.BOLD, 20));
		add(shuffleWords);

		/*cardBack = new JLabel();
		cardBack.setIcon(cardBackImage);
		cardBack.setBounds(362, 431, 500, 200);
		add(cardBack); */

		// Card icons
		int cardWidth = 140;
		int cardHeight = 194;
		int spacing = 10;
		int cardsX = (900 - (5 * cardWidth + 4 * spacing));
		int cardsY = 425;

		cardLoading = new JLabel[5];
		for (int i = 0; i < cardLoading.length; i++) {
			ImageIcon cardIcon = new ImageIcon("images/back.png");
			JLabel cardLabel = new JLabel(cardIcon);
			int cardX = cardsX + i * (cardWidth + spacing);
			cardLabel.setBounds(cardX, cardsY, cardWidth, cardHeight);
			cardLabel.setVisible(false); // Hide the card initially
			cardLoading[i] = cardLabel;
			add(cardLabel);
		}

		cardIndex = 0;
		timer = new Timer();
		TimerTask showCardTask = new TimerTask() {
			@Override
			public void run() {
				if (cardIndex < cardLoading.length) {
					cardLoading[cardIndex].setVisible(true);
					cardIndex++;
				} else {
					timer.cancel();
				}
			}
		};
		timer.schedule(showCardTask, 300, 300); // Delay: 0.3 second, Repeat interval: 0.3 second

	}

}
