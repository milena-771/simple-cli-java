package co.simplon.java.cli.parser;

import co.simplon.java.cli.commands.ParsedCommandLine;

public class Interpreter {
	
	public static String interprete(String inputs) {
		ParsedCommandLine commandLine = Parser.extract(inputs);
		String response = Executer.execute(commandLine);
		return response;
	}
}
