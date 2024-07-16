package co.simplon.java.cli;

import co.simplon.java.cli.interpreter.Interpreter;

public class Application {

	public static void main(String[] args) {
		String inputs = "hw"; // Please change the command here
		String response = Interpreter.interprete(inputs);
		System.out.println(response);
	}
}
