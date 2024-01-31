package co.simplon.java.cli.interpreter;

import co.simplon.java.cli.commands.ParsedCommandLine;
import co.simplon.java.cli.commands.Commands;

public class Executer {
	
	private Executer() {
	}
	
	public static String execute(ParsedCommandLine line) {
		String command = line.getCommand();
		String response = "";
		if(command.equals("hw")) {
			response = Commands.hw();
		}else if(command.equals("date")) {
			response = Commands.date(line);
		}else if(command.equals("time")){
			response = Commands.time(line);
		}else if(command.equals("datetime")) {
			response = Commands.datetime(line);
		}else if(command.equals("print") || command.equals("echo")) {
			response = Commands.print(line);
		}else if(command.equals("secsanta")) {
			response = Commands.secsanta(line);
		}else {
			response = "Command not found.";
		}
		return response;
	}
}
