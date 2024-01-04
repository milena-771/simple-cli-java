package co.simplon.java.cli.parser;

public class Match {
	
	public static Boolean isCommandExist(String inputs) {
		if(inputs.equals("hw")) {
			return true;
		}else if(inputs.equals("date")) {
			return true;			
		}else if(inputs.equals("time")) {
			return true;
		}else if(inputs.equals("datetime")) {
			return true;
		}else if(inputs.equals("print") || inputs.equals("echo")) {
			return true;
		}else {
			return false;
		}
	}
}
