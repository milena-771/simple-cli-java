package co.simplon.java.cli;

import co.simplon.java.cli.parser.Parser;
import co.simplon.java.cli.parser.Result;

public class Application {
	
	public static void main(String[] args) {
		String inputs = args[0];
		if(Parser.checkCommand(inputs)) {
			Parser.callMethod(inputs);
		};
		
	}

}
