package co.simplon.java.cli;

import co.simplon.java.cli.parser.Execute;
import co.simplon.java.cli.parser.Match;
import co.simplon.java.cli.parser.Receive;

public class Application {
	
	public static void main(String[] args) {
		String inputs = args[0];
		String response = "";
		String command = Receive.extractCommand(inputs);
		String arguments = Receive.extractArguments(inputs);
		if(Match.isCommandExist(command)) {
			response = Execute.executeCommand(command, arguments);
		}else {
			response = "Command not found";
		}
		System.out.println(response);
	}
}
