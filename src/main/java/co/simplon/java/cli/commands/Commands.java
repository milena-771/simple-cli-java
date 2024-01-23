
package co.simplon.java.cli.commands;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Commands {
	
	private static final Set<String> TIMEZONES = Set.of(TimeZone.getAvailableIDs());
	
	public static String hw() {
		return "Hello World!";
	}
	
	public static String date(ParsedCommandLine line) {
		String response = "";
		if(line.getArguments() != null) {
			String timezone = getTimeZone(line);
			if(TIMEZONES.contains(timezone)) {
				Instant nowUtc = Instant.now();
				ZoneId zone = ZoneId.of(timezone);
				LocalDate date = LocalDate.ofInstant(nowUtc, zone);
				response = date.toString();
			}else {
				response = timezone;
			}
		}else {
			LocalDate date = LocalDate.now();
			response = date.toString();
		}
		return response;
	}
	
	public static String time(ParsedCommandLine line) {
		String response = "";
		if(line.getArguments() != null) {
			String timezone = getTimeZone(line);
			if(TIMEZONES.contains(timezone)) {
				Instant nowUtc = Instant.now();
				ZoneId zone = ZoneId.of(timezone);
				LocalTime time = LocalTime.ofInstant(nowUtc, zone);
				response = time.truncatedTo(ChronoUnit.SECONDS).toString();
			}else {
				response = timezone;
			}
		}else {
			LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
			response = time.toString();
		}
		return response;
	}
	
	public static String datetime(ParsedCommandLine line) {
		String response = "";
		if(line.getArguments() != null) {
			String timezone = getTimeZone(line);
			if(TIMEZONES.contains(timezone)) {
				Instant nowUtc = Instant.now();
				ZoneId zone = ZoneId.of(timezone);
				LocalDateTime datetime = LocalDateTime.ofInstant(nowUtc, zone).truncatedTo(ChronoUnit.SECONDS);
				response = datetime.toString();
			}else {
				response = timezone;
			}			
		}else {
			LocalDateTime dateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
			response = dateTime.toString();
		}
		return response;
	}
	
	private static String getTimeZone(ParsedCommandLine line) {
		String response = "";
		String options = line.getArguments();
		Pattern patternParam = Pattern.compile("(?<param>--timezone=)(?<zone>.*)");
		Matcher matcherParam = patternParam.matcher(options);
		if(matcherParam.find()) {
			String timeZoneWithQuotes = matcherParam.group("zone");
			if(!timeZoneWithQuotes.isBlank()) {
				Pattern patternTZ = Pattern.compile("\".*?\"");
				Matcher matcherTZ = patternTZ.matcher(timeZoneWithQuotes);
				if(matcherTZ.find()) {
					String timezone = timeZoneWithQuotes.substring(1, timeZoneWithQuotes.length()-1);
					if(TIMEZONES.contains(timezone)) {
						response = timezone;
					}else {
						response="Please specify a registered IANA time zone name";
					}
				}else {
					response="Please specify a time zone name between quotes";
				}
			}else {
				response="Please specify a time zone name";
			}
		}else {
			response = "Did you mean --timezone= stupid idiot?";
		}
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
				Random random = new Random();
				for(int i = 0; i <= namesList.size();i++) {
					int keyIndex = random.nextInt(namesList.size());
					String key = namesList.get(keyIndex);
					namesList.remove(keyIndex);
					int valueIndex = random.nextInt(namesList.size());
					String value = namesList.get(valueIndex);
					namesList.remove(valueIndex);
					pairs.put(key.trim(), value.trim());
				}
				for(Map.Entry<String, String> pair : pairs.entrySet()) {
					String tmp = "["+pair.getKey()+"::"+pair.getValue()+"] ";
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
	
	
	/*public static String buildResponse(Map<String, String> pairs) {
		String response="";
		for(Map.Entry<String, String> pair : pairs.entrySet()) {
			String tmp = "["+pair.getKey()+"::"+pair.getValue()+"] ";
			response += tmp;
		}
		return response;
	}*/
}
