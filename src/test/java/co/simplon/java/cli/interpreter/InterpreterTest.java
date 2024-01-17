package co.simplon.java.cli.interpreter;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.simplon.java.cli.commands.ParsedCommandLine;

@DisplayName("Tests for Interpreter class")
class InterpreterTest {
	
	@Test
	@DisplayName("Test for return type of interprete method")
	void shouldReturnInstanceOfString() {
		String response = Interpreter.interprete("test");
		assertInstanceOf(String.class, response);	
	}
	
	@Test
	@DisplayName("Test to throw an IllegalArgumentException if input is null")
	void shoulThrowAnExceptionIfInputIsNull() {
		assertThrows(NullPointerException.class, () -> Interpreter.interprete(null));	
	}

}
