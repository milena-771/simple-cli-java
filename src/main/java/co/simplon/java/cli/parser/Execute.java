package co.simplon.java.cli.parser;

import co.simplon.java.cli.commands.Command;

public class Execute {
	
	public static String executeCommand(String command) {
		String response = "";
		if(command.equals("hw")) {
			response = Command.hw();
		}
		return response;
	}
}
