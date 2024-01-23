package co.simplon.java.cli.interpreter;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import co.simplon.java.cli.commands.ParsedCommandLine;

public class ExecuterTest {
	
	@Test
	void shouldReturnHelloWorldIfCommandIsHw() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("hw");
		String actual = Executer.execute(line);
		assertEquals("Hello World!", actual);		
	}
	
	@Test
	void shouldReturnErrorIfCommandIsHwUpperCase() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("HW");
		String actual = Executer.execute(line);
		assertEquals("Command not found.", actual);		
	}
	
	@Test
	void shouldReturnDateIfCommandIsDate() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("date");
		String actual = Executer.execute(line);
		String expected = LocalDate.now().toString();
		assertEquals(expected, actual);		
	}
	
	@Test
	void shouldReturnTimeIfCommandIsTime() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("time");
		String actual = Executer.execute(line);
		String expected = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString();
		assertEquals(expected, actual);		
	}
	
	@Test
	void shouldReturnDateTimeIfCommandIsDatetime() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("datetime");
		String actual = Executer.execute(line);
		String expected = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).toString();
		assertEquals(expected, actual);		
	}
	
	@Test
	void shouldReturnArgumentsIfCommandIsPrint() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("print");
		line.setArguments("Hello everybody");
		String actual = Executer.execute(line);
		String expected = "Hello everybody";
		assertEquals(expected, actual);		
	}
	
	@Test
	void shouldReturnArgumentsIfCommandIsEcho() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("echo");
		line.setArguments("Hello everybody");
		String actual = Executer.execute(line);
		String expected = "Hello everybody";
		assertEquals(expected, actual);		
	}
	
	@Test
	void shouldReturnPairsInAStringIfCommandIsSecsanta() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("secsanta");
		line.setArguments("Amélie,Isabelle,Emilie,Olivier");
		Pattern pattern = Pattern.compile("([)(\\d*::\\d*)(])(\\s*){3}");
		String actual = Executer.execute(line);
		Matcher matcher = pattern.matcher(actual);
		assertTrue(matcher.find());	
	}

}
