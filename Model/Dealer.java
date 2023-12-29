package Model;
import java.util.*;

public class Dealer extends Player {
	
	private Deck deck;
	
	// OTHER CONSTRUCTOR
	public Dealer() {
		// TODO Auto-generated constructor stub
		super("Dealer", "",10000000);
		deck = new Deck();
	}
	
	

	
	// WHEN DEALER SHUFFLE CARDS 
	public void shuffleCards()
	{
	     deck.shuffle();
	}
	
	// DEALER DEALING ONE CARD, FROM THE TOP OF DECK
	public void dealCardsTo(Player player)
	{
		Card card = deck.dealCard();
		player.addCard(card);
	}
	

	
	// FIRST ROUND OF DEALING ORDER
	public void dealing(Player player, Dealer dealer, int rounds)
	{
		if (rounds ==1) 
		{
		dealCardsTo(player);
		dealCardsTo(dealer);
		dealCardsTo(player);
		dealCardsTo(dealer);
		}
		
		else 
		{
		dealCardsTo(player);
		dealCardsTo(dealer);
		}
		
	}
	


	
	//REFRESH THE CARDS ON PLAYER'S AND DEALER'S HAND
	public void refreshCards(Player player)
	{

		deck = new Deck();
		player.cardsOnHand = new ArrayList<Card>();
		this.cardsOnHand = new ArrayList<Card>();
	}
	
	
}
