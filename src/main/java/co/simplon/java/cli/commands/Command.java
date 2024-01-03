package co.simplon.java.cli.commands;

import java.util.HashSet;
import java.util.Set;

public class Command {
	
	public static final Set<String> COMMANDS = new HashSet<>();
	
	static {
		COMMANDS.add("hw");
	}
	
	public static String hw() {
		return "Hello World!";
	}
	
	
}
