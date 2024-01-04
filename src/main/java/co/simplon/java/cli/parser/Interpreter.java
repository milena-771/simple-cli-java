package co.simplon.java.cli.parser;

public class Interpreter {
	
	public static void interprete(String inputs) {
		String[] commandLine = Parser.extract(inputs);
		String response = Executer.execute(commandLine);
		System.out.println(response);
	}
}
