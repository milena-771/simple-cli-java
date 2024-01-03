package co.simplon.java.cli.parser;

import co.simplon.java.cli.commands.Command;

public class Parser {

	public static Boolean checkCommand(String inputs) {
		String[] inputsArr = inputs.split(" ");
		Boolean isValid = true;
		for(int i = 0; i<inputsArr.length; i++) {
			String element = inputsArr[i];
			if(Command.COMMANDS.contains(element)) {
				isValid = true;
			}else {
				isValid = false;
				break;
			}
		}
		return isValid;
	}
	
	public static Result callMethod(String inputs) {
		
		Result message = new Result();
		message.setResponse(inputs);
		return message;
	}
}
