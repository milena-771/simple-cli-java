package co.simplon.java.cli.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import co.simplon.java.cli.commands.ParsedCommandLine;

@DisplayName("Tests for Parser class")
class ParserTest {

	@Test
	@DisplayName("Test for return type of extract method")
	void shouldReturnInstanceOfParsedCommandLine() {
		ParsedCommandLine line = Parser.extract("hw");
		assertInstanceOf(ParsedCommandLine.class, line);
	}

	@Test
	@DisplayName("Test to set command before first space from inputs")
	void shouldGetCommandFromInputs() {
		ParsedCommandLine line = Parser.extract("hw arguments");
		assertEquals("hw", line.getCommand());
	}

	@Test
	@DisplayName("Test to check blank command and arguments when inputs is a whitespace")
	void shouldReturnError() {
		ParsedCommandLine line = Parser.extract(" ");
		assertEquals("", line.getCommand());
		assertEquals("", line.getArguments());
	}

	@ParameterizedTest
	@MethodSource
	@DisplayName("Test Parser class to extract arguments from different inputs")
	void shouldGetArgumentsFromInputs(String inputs, String expected) {
		ParsedCommandLine actual = Parser.extract(inputs);
		assertEquals(expected, actual.getArguments());
	}

	static Stream<Arguments> shouldGetArgumentsFromInputs() {
		return Stream.of(Arguments.of("hw argument", "argument"),
				Arguments.of("hw argument withSpace", "argument withSpace"),
				Arguments.of("hw", null), Arguments.of("hw ", ""));
	}

}
