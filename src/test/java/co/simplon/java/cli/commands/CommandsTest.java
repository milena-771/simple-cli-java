package co.simplon.java.cli.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Tests for Commands class")
class CommandsTest {
	
	@Test
	@DisplayName("Test for command hw()")
	void shouldReturnHelloWorldWithCommandHw() {
		String actual = Commands.hw();
		assertEquals("Hello World!", actual);
	}
	
	@Test
	@DisplayName("Test for command date() without arguments")
	void shouldReturnLocalDateNowIfCommandDateWithoutArgument() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("date");
		String actual = Commands.date(line);
		String expected = LocalDate.now().toString();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Test for command date() with arguments")
	void shouldReturnLocalDateNowWithTimeZoneIfCommandDateWithArguments() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("date");
		line.setArguments("--timezone=\"Asia/Tokyo\"");
		String actual = Commands.date(line);
		Instant nowUtc = Instant.now();
		ZoneId zone = ZoneId.of("Asia/Tokyo");
		String expected = LocalDate.ofInstant(nowUtc, zone).toString();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Test for command date() with wrong arguments")
	void shouldReturnErrorResponseIfCommandDateWithWrongArguments() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("date");
		line.setArguments("--timezone=\"Asia/Japan\"");
		String actual = Commands.date(line);
		String expected ="Please specify a registered IANA time zone name";
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Test for command time() without arguments")
	void shouldReturnLocalTimeNowIfCommandTimeWithoutArgument() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("time");
		String actual = Commands.time(line);
		String expected = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Test for command time() with arguments")
	void shouldReturnLocalTimeNowWithTimeZoneIfCommandTimeWithArgument() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("time");
		line.setArguments("--timezone=\"Asia/Tokyo\"");
		String actual = Commands.time(line);
		Instant nowUtc = Instant.now();
		ZoneId zone = ZoneId.of("Asia/Tokyo");
		String expected = LocalTime.ofInstant(nowUtc, zone).truncatedTo(ChronoUnit.SECONDS).toString();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Test for command time() with wrong arguments")
	void shouldReturnErrorResponseIfCommandTimeWithWrongArguments() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("time");
		line.setArguments("--timezone=\"Asia/Japan\"");
		String actual = Commands.time(line);
		String expected ="Please specify a registered IANA time zone name";
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Test for command datetime() without arguments")
	void shouldReturnLocalDateTimeNowIfCommandDatetimeWithoutArgument() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("datetime");
		String actual = Commands.datetime(line);
		String expected = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).toString();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Test for command datetime() with arguments")
	void shouldReturnLocalDateTimeNowWithTimeZoneIfCommandDatetimeWithArgument() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("datetime");
		line.setArguments("--timezone=\"Asia/Tokyo\"");
		String actual = Commands.datetime(line);
		Instant nowUtc = Instant.now();
		ZoneId zone = ZoneId.of("Asia/Tokyo");
		String expected = LocalDateTime.ofInstant(nowUtc, zone).truncatedTo(ChronoUnit.SECONDS).toString();
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@MethodSource
	void shouldReturnResponseWithErrorMessageIfArgumentIncorrect(String arguments, String expected) {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("datetime");
		line.setArguments(arguments);
		String actual = Commands.datetime(line);
		assertEquals(expected, actual);
	}
	
	static Stream<Arguments> shouldReturnResponseWithErrorMessageIfArgumentIncorrect(){
		return Stream.of(Arguments.of("--timezone\"Asia/Tokyo\"", "Did you mean --timezone= stupid idiot?"),
						Arguments.of("--timezone=", "Please specify a time zone name"),
						Arguments.of("--timezone=Asia/Tokyo", "Please specify a time zone name between quotes"),
						Arguments.of("--timezone=\"\"", "Please specify a registered IANA time zone name"),
						Arguments.of("--timezone=\" \"", "Please specify a registered IANA time zone name")

				);
	}
	
	@ParameterizedTest
	@MethodSource
	void shouldReturnResponseWithCommandPrint(String arguments, String expected) {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("print");
		line.setArguments(arguments);
		String actual = Commands.print(line);
		assertEquals(expected, actual);
	}
	
	static Stream<Arguments> shouldReturnResponseWithCommandPrint(){
		return Stream.of(Arguments.of(" ", " "),
						Arguments.of(null, ""),
						Arguments.of("happy testing", "happy testing")				

				);
	}
	
	@ParameterizedTest
	@MethodSource
	void shouldReturnResponseWithCommandSecsanta(String arguments, String expected) {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("secsanta");
		line.setArguments(arguments);
		String actual = Commands.secsanta(line);
		assertEquals(expected, actual);
	}
	
	static Stream<Arguments> shouldReturnResponseWithCommandSecsanta(){
		return Stream.of(Arguments.of(null, "Please provide a list of names to propose pairs from"),
						Arguments.of("Damla Laurine Juliette Lindsay", "Please provide an even number of names"),
						Arguments.of("Damla,Laurine,Juliette", "Please provide an even number of names"),
						Arguments.of(" ", "Please provide an even number of names")

				);
	}

}
