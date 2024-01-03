package co.simplon.java.cli.parser;

public class Match {
	
	public static Boolean isCommandExist(String inputs) {
		if(inputs.equals("hw")) {
			return true;
		}else {
			return false;
		}
	}
}
