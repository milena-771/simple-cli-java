package co.simplon.java.cli.parser;

public class Interpreter {
	
	public static String interprete(String inputs) {
		String[] commandLine = Parser.extract(inputs);
		String response = Executer.execute(commandLine);
		return response;
	}
}