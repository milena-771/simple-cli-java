package co.simplon.java.cli.parser;

import java.util.Arrays;

import co.simplon.java.cli.commands.Commands;

public class Parser {

	public static String[] extract(String inputs) {
		String[] line = inputs.split(" ", 2);
		return line;
	}
}
