package co.simplon.java.cli.commands;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
	
	public static String time() {
		LocalTime time = LocalTime.now();
		String response = time.toString();
		return response;
	}
	
	public static String datetime() {
		LocalDateTime dateTime = LocalDateTime.now();
		String response = dateTime.toString();
		return response;
	}
	
	public static String print(String arguments) {
		String response = arguments;
		return response;	
	}
}
