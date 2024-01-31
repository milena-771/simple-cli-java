package co.simplon.java.cli.interpreter;

import co.simplon.java.cli.commands.ParsedCommandLine;

public class Interpreter {
	
	private Interpreter() {
	}
	
	public static String interprete(String inputs) {
		if(inputs != null) {
			ParsedCommandLine commandLine = Parser.extract(inputs);
			String response = Executer.execute(commandLine);
			return response;
		}else {
			throw new NullPointerException();
		}	
	}
}
