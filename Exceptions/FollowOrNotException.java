package Exceptions;

public class FollowOrNotException extends Exception {

	public FollowOrNotException() {
		super("Please enter either [Y] or [N]!");
	}
}
