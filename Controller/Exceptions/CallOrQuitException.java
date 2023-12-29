package Exceptions;

public class CallOrQuitException extends Exception 
{
	
	public CallOrQuitException() {
		super("Please enter either [C] or [Q]!");
	}
	
}
