package co.simplon.java.cli.commands;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Command {
	
	public static String hw() {
		return "Hello World!";
	}
	
	public static String date() {
		LocalDate date = LocalDate.now();
		String response = date.toString();
		return response;
	}
}
