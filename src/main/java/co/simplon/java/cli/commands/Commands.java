
package co.simplon.java.cli.commands;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Commands {
	
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
	
	public static String print(ParsedCommandLine line) {
		String response = "";
		if(line.getArguments() != null) {
			String arguments = line.getArguments();
			response = arguments;
		}
		return response;
	}
	
	public static String secsanta(ParsedCommandLine line) {
		String response= "";
		if(line.getArguments() != null) {
			String arguments = line.getArguments();
			String[] names = arguments.split(",");
			if(names.length % 2 == 0) {
				ArrayList<String> namesList = new ArrayList(Arrays.asList(names));
				Map<String, String> pairs = new HashMap<>();
				for(int i = 0; i <= namesList.size();i++) {
					Random random = new Random();
					int keyIndex = random.nextInt(namesList.size());
					String key = namesList.get(keyIndex);
					namesList.remove(keyIndex);
					int valueIndex = random.nextInt(namesList.size());
					String value = namesList.get(valueIndex);
					namesList.remove(valueIndex);
					pairs.put(key, value);
				}
				for(Map.Entry<String, String> pair : pairs.entrySet()) {
					String tmp = "["+ pair.getKey()+"::"+pair.getValue()+"] ";
					response += tmp;
				}
			}else {
				response = "Please provide an even number of names";
			}			
		}else {
			response = "Please provide a list of names to propose pairs from";
		}
		return response;
	}
}
