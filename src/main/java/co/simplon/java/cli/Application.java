package co.simplon.java.cli;

import co.simplon.java.cli.parser.Execute;
import co.simplon.java.cli.parser.Match;
import co.simplon.java.cli.parser.Receive;

public class Application {
	
	public static void main(String[] args) {
		String inputs = args[0];
		String response = "";
		String command = Receive.extractCommand(inputs);
		if(Match.isCommandExist(command)) {
			response = Execute.executeCommand(command);
		}else {
			response = "No command found";
		}
		System.out.println(response);
	}

}
