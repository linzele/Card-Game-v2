package Model;

import java.io.*;
import java.util.Scanner;

import AdminMod.Utility;

abstract class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String loginName;
	private String password;
	static Scanner input = new Scanner(System.in);

	public User(String loginName, String password) {
		this.loginName = loginName;
		this.password = password;
	}

	// RETURN LOGIN NAME
	public String getLoginName() {
		return loginName;
	}

	public String getHashedPassword() {
		return password;
	}

	public void resetPassword(String password) {
		this.password = password;
	}

	// RETURN BOOLEAN IF PASSWORD IS TRUE/FALSE
	public boolean checkPassword(String password) {
		return this.password.equals(Utility.getHash(password));
	}

	// PASSWORD TO HASH AFTER SUCCESSFUL LOGIN

	public void display() {
		System.out.println(this.loginName + "," + this.password);
	}

}
