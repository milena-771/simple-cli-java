package co.simplon.java.cli.parser;

import java.util.Arrays;

import co.simplon.java.cli.commands.Command;

public class Receive {

	public static String extractCommand(String inputs) {
		String[] line = inputs.split(" ");
		String command = line[0];
		return command;
	}
}
