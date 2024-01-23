package co.simplon.java.cli.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.simplon.java.cli.interpreter.Parser;

@DisplayName("Tests for ParsedCommandLine class")
class ParsedCommandLineTest {
	
	@Test
	@DisplayName("Test should not return a null instance from ParsedCommandLine constructor")
	void shouldConstructorReturnsWithNoneNullParams() {
		ParsedCommandLine actual = new ParsedCommandLine();
		assertNotNull(actual);
	}
	
	@Test
	@DisplayName("Test for toString method")
	void shouldToStringReturnsNotNull() {
		ParsedCommandLine line = new ParsedCommandLine();
		String actual = line.toString();
		assertNotNull(actual);
	}
	
	@Test
	@DisplayName("Test for getCommand method")
	void shouldGetCommandReturnSameInputFromSetCommand() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("test");
		String actual = line.getCommand();
		assertEquals("test", actual);
	}
	
	@Test
	@DisplayName("Test for getCommand method")
	void shouldGetArgumentsReturnSameInputFromSetArguments() {
		ParsedCommandLine line = new ParsedCommandLine();
		line.setCommand("print");
		line.setArguments("Hello everybody !");
		String actual = line.getArguments();
		assertEquals("Hello everybody !", actual);
	}
	

}
