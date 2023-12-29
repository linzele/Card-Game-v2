package Model;
import java.util.*;

import Exceptions.BetAmountException;
import Exceptions.CallOrQuitException;
import Exceptions.FollowOrNotException;





public class Player extends User{
	
	private int chips;
	protected ArrayList<Card> cardsOnHand;
	private int betAmount;
	static Scanner input = new Scanner(System.in);
	private boolean quit = false;
	
	private char choice;
	private int scoreCompare;
	
	// CONSTRUCTOR
	public Player(String loginName,String password, int chips) 
	{
		super(loginName,password);
		this.cardsOnHand = new ArrayList <Card>();
		this.chips = chips;
	}
	
	
	public void addChips(int amount)
	{
		this.chips += amount;
	}
	
	public ArrayList<Card> getCardsOnHand() {
		return this.cardsOnHand;
	}
	
    public void deductChips(int amount) 
    {
		this.chips -= amount;
    }
    
    
    public void setChips(int chips)
    {
    	this.chips = chips;
    }
    
    public int getChips()
    {
        return this.chips;
    }
	
  
    
    public void addCard(Card card)
    {
    	this.cardsOnHand.add(card);
    }
    
   
    public int getScoreCompare()
    {
    	return this.scoreCompare;
    }
    
    public void setScoreCompare()
    {
    	Card pLastCard = this.cardsOnHand.get(cardsOnHand.size()-1);
    	
    	switch (pLastCard.getName())
    	{
    		case("King"):this.scoreCompare +=8;
    		break;
    		case("Queen"): this.scoreCompare +=4;
    		break;
    		case("Jack"):this.scoreCompare+=2;
    		break;
   	    	default:this.scoreCompare+=1;
    		break;
    	}
    		 
    	switch (pLastCard.getSuit())
    	{
    		 
    		case("Spade"):this.scoreCompare *=4;
    		break;
    		case("Heart"):this.scoreCompare *=3;
    		break;
    		case("Club"):this.scoreCompare *=2;
    		break;
    		default:this.scoreCompare*=1;
    		break;
    	}	
    }
  //--------------------------------------------------------------------------------------------------//
 
    // GET TOTAL VALUE ON HAND 
    public void showTotalCardValue() {

		System.out.println("Value:" + getTotalCardsValue());
	}

	public int getTotalCardsValue() {

		int total = 0;
		for (Card card : cardsOnHand) {
			total += card.getValue();
		}
		return total;
	}

    
    public int getBetAmount()
    {
    	return this.betAmount;
    }
    
    public void setBetAmount(int betAmount)
    {
    	this.betAmount = betAmount;
    }
    
    public int getLastCardValue()
    {
    	Card c = cardsOnHand.get(cardsOnHand.size()-1);
    	return c.getValue();
    }
 
    
    
    public void setChoice(char choice)
    {
    	this.choice = choice;
    }
    
    
    public void setQuit()
    {
    	this.quit = true;
    }
    
    public boolean getQuit()
    {
    	return this.quit;
    }
    
    public void reverseQuit()

    {
    	this.quit =false;
    }
    
    public char getChoice()
    {
    	return this.choice;
    }
   
    
    
    public void display()
    {
    	super.display();
    	System.out.println(this.chips);
    }
    
    
}
