package co.simplon.java.cli.parser;

import java.util.Arrays;

import co.simplon.java.cli.commands.ParsedCommandLine;
import co.simplon.java.cli.commands.Commands;

public class Parser {

	public static ParsedCommandLine extract(String inputs) {
		String[] lineArr = inputs.split(" ", 2);
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand(lineArr[0]);
		if(lineArr.length > 1) {
			line.setArguments(lineArr[1]);
		}
		return line;
	}
}
