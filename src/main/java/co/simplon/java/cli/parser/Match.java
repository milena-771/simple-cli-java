package co.simplon.java.cli.parser;

public class Match {
	
	public static Boolean isCommandExist(String inputs) {
		if(inputs.equals("hw") || inputs.equals("date") || inputs.equals("time") || inputs.equals("datetime") || inputs.equals("print") || inputs.equals("echo")) {
			return true;
		}else {
			return false;
		}
	}
}
