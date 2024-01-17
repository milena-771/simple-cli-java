package co.simplon.java.cli;

import co.simplon.java.cli.interpreter.Executer;
import co.simplon.java.cli.interpreter.Interpreter;
import co.simplon.java.cli.interpreter.Parser;

public class Application {
	
	public static void main(String[] args) {
		String inputs = args[0];
		String response = Interpreter.interprete(inputs);
		System.out.println(response);
	}
}
