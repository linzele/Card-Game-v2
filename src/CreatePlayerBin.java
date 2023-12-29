package AdminMod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Model.Player;

public class CreatePlayerBin {

	public static void main(String[] args) {

		Player player1 = new Player("IcePeak", Utility.getHash("password"), 1000);

		try {

			FileOutputStream file = new FileOutputStream("./players.bin");
			ObjectOutputStream opStream = new ObjectOutputStream(file);

			opStream.writeObject(player1);

			opStream.close();
		}

		catch (IOException ex) {

			ex.printStackTrace();

		}
	}
}
