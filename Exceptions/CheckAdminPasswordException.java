package Exceptions;

public class CheckAdminPasswordException extends Exception {

	public CheckAdminPasswordException() {
		super("Please enter the correct password for Admin");
	}

}
