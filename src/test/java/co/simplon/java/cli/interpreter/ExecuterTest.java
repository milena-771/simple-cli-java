package co.simplon.java.cli.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.simplon.java.cli.commands.ParsedCommandLine;

public class ExecuterTest {

	@Test
	@DisplayName("Test for hw command from Executer")
	void shouldReturnHelloWorldIfCommandIsHw() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("hw");
		String actual = Executer.execute(line);
		assertEquals("Hello World!", actual);
	}

	@Test
	@DisplayName("Test return error response if a command is called in upper case from Executer ")
	void shouldReturnErrorIfCommandIsHwUpperCase() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("HW");
		String actual = Executer.execute(line);
		assertEquals("Command not found.", actual);
	}

	@Test
	@DisplayName("Test for date command from Executer")
	void shouldReturnDateIfCommandIsDate() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("date");
		String actual = Executer.execute(line);
		String expected = LocalDate.now().toString();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Test for time command from Executer")
	void shouldReturnTimeIfCommandIsTime() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("time");
		String actual = Executer.execute(line);
		String expected = LocalTime.now().truncatedTo(ChronoUnit.SECONDS)
				.toString();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Test for datetime command from Executer")
	void shouldReturnDateTimeIfCommandIsDatetime() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("datetime");
		String actual = Executer.execute(line);
		String expected = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
				.toString();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Test for print command from Executer")
	void shouldReturnArgumentsIfCommandIsPrint() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("print");
		line.setArguments("Hello everybody");
		String actual = Executer.execute(line);
		String expected = "Hello everybody";
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Test for echo command from Executer")
	void shouldReturnArgumentsIfCommandIsEcho() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("echo");
		line.setArguments("Hello everybody");
		String actual = Executer.execute(line);
		String expected = "Hello everybody";
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Test for secsanta command from Executer")
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
