package AdminMod;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import Controller.GameController;
import Exceptions.CheckPlayerExistException;
import Model.Dealer;
import Model.Player;
import View.ViewController;
//import a3_pack.LoginManager;

public class GameModule {

	private Player player;
	private ViewController view;
	private GameController gc;

	public GameModule() {
		// this.view = new ViewController();
		// this.gc = new GameController(this.view);
	}

	public void run() {
		boolean loggedIn = false;

		while (!loggedIn) {
			player = new Player("IcePeak", "password", 100);
			view = new ViewController();
			gc = new GameController(this.view);
			loggedIn = true;
		}
		gc.execute();
	}

	public static void main(String[] args) {
		new GameModule().run();
	}

}
