package co.simplon.java.cli.parser;

import co.simplon.java.cli.commands.Command;

public class Execute {
	
	public static String executeCommand(String command, String arguments) {
		String response = "";
		if(command.equals("hw")) {
			response = Command.hw();
		}else if(command.equals("date")) {
			response = Command.date();
		}else if(command.equals("time")){
			response = Command.time();
		}else if(command.equals("datetime")) {
			response = Command.datetime();
		}else if(command.equals("print") || command.equals("echo")) {
			response = Command.print(arguments);
		}
		return response;
	}
}
