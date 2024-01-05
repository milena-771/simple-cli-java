package co.simplon.java.cli.parser;

import co.simplon.java.cli.commands.Commands;

public class Executer {
	
	public static String execute(String[] inputs) {
		String command = inputs[0];
		String response = "";
		if(command.equals("hw")) {
			response = Commands.hw();
		}else if(command.equals("date")) {
			response = Commands.date();
		}else if(command.equals("time")){
			response = Commands.time();
		}else if(command.equals("datetime")) {
			response = Commands.datetime();
		}else if(command.equals("print") || command.equals("echo")) {
			response = Commands.print(inputs);
		}else {
			response = "Command not found.";
		}
		return response;
	}
}
