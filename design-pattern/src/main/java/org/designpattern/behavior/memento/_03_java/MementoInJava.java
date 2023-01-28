package org.designpattern.behavior.memento._03_java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.designpattern.behavior.memento._02_after.Originator;

public class MementoInJava {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Originator originator = new Originator();
		originator.setRedTeamScore(10);
		originator.setBlueTeamScore(20);

		// serialization
		// try (FileOutputStream fileOut = new FileOutputStream("GameSave.hex");
		// 		 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
		// 	out.writeObject(originator);
		// }

		originator.setBlueTeamScore(25);
		originator.setRedTeamScore(15);

		// de-serialization
		try (FileInputStream fileIn = new FileInputStream("GameSave.hex");
				 ObjectInputStream in = new ObjectInputStream(fileIn)
		) {
			originator = (Originator)in.readObject();
			System.out.println(originator.getBlueTeamScore());
			System.out.println(originator.getRedTeamScore());
		}
	}
}
