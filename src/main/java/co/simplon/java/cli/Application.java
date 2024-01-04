package co.simplon.java.cli;

import co.simplon.java.cli.parser.Executer;
import co.simplon.java.cli.parser.Interpreter;
import co.simplon.java.cli.parser.Parser;

public class Application {
	
	public static void main(String[] args) {
		String inputs = args[0];
		Interpreter.interprete(inputs);
	}
}
