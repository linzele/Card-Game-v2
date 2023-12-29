package Model;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Card extends ImageIcon implements Serializable{
	
	private String suit;
	private String name;
	private int value;
	
	// CONSTUCTOR
	public Card(String suit, String name, int value) 
	{
		super("./images/"+suit+name+".png");
		
		this.suit = suit;
		this.name = name;
		this.value = value;
		
	}

	// RETURN THE SUIT OF CARD
	public String getSuit()
	{
		return this.suit;
	}
	
	
	// RETURN NAME OF CURRENT CARD
	public String getName()
	{
		return this.name;
	}
	
	// RETURN VALUE OF CURRENT CARD
	public int getValue()
	{
		return this.value;
	}
	
	// RETURN THE NAME OF THE CURRENT CARD
	public String toString()
	{
		return "<"+this.suit+" "+this.name+">";
	}


	
}

