package Model;

import java.util.*;

public class Deck {
	
	private ArrayList<Card> cards;
	
	
	// OTHER CONSTRUCTOR
	public Deck() 
	{
		// TODO Auto-generated constructor stub
		cards = new ArrayList<Card>();
		String [] suits = {"Heart","Diamond","Spade","Club"};
		for (int i =0; i < suits.length; i++)
		{
			// ADD IN DECK FOR CARDS WITH VALUE ACE
			Card aCard = new Card(suits[i],"Ace",1);
			cards.add(aCard);
			
			
			// ADD IN DECK FOR CARDS WITH VALUE 2 TO 10
			for (int num = 2; num<=10; num++)
			{
				Card oCard = new Card(suits[i],num+"",num);
				cards.add(oCard);
			}
			
			// ADD IN DECK FOR CARDS WITH PICTURE
			String [] pictures = {"King", "Queen", "Jack"};
			for (String picture: pictures)
			{
				Card picCard = new Card(suits[i], picture, 10);
				cards.add(picCard);
			
			}
		}
	}
	
	// SHOW ALL THE CARDS
	public void showCards() 
	{
		for (Card card: cards)
		{
			System.out.println(card.toString());
		}
	}
	
	
	public void shuffle()
	{
		Random random = new Random();
		for (int i=0; i<10000; i++)
		{
			int indexA = random.nextInt(cards.size());
			int indexB = random.nextInt(cards.size());
			
			Card cardA = cards.get(indexA);
			Card cardB= cards.get(indexB);
			cards.set(indexA, cardB);
			cards.set(indexB, cardA);			
		}
	}
	
	public Card dealCard()
	{
		return cards.remove(0);
	}
	
	public void addCardBack(Card card)
	{
		cards.add(card);
	}
	
	

}
