package co.simplon.java.cli.parser;

import java.util.Arrays;

import co.simplon.java.cli.commands.Command;

public class Receive {

	public static String extractCommand(String inputs) {
		String[] line = inputs.split(" ");
		String command = line[0];
		return command;
	}
	
	public static String extractArguments(String inputs) {
		String[] line = inputs.split(" ");
		String command = line[0];
		String sentence = "";
		if(line.length > 1) {
			String[] arguments = Arrays.copyOfRange(line, 1, line.length);
			sentence = String.join(" ", arguments);
		} else if((command.equals("print") || command.equals("echo")) && line.length == 1){
			sentence = " ";
		}
		return sentence;	
	}
}
