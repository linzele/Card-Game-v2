package AdminMod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

import AdminMod.Utility;

import java.io.*;

public class CreateAdminText {

	public static void main(String[] args) {
		String adminHashedPass = Utility.getHash("password");

		try {
			FileWriter file = new FileWriter("admin.txt");

			file.write(adminHashedPass);
			file.close();
		} catch (IOException ex) {

		}

	}

}
