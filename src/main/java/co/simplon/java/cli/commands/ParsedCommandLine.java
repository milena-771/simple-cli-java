package co.simplon.java.cli.commands;

public class ParsedCommandLine {
	
	private String command;
	
	private String arguments;

	public ParsedCommandLine() {
	}

	public String getCommand() {
		return command;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}

	public String getArguments() {
		return arguments;
	}

	public void setArguments(String arguments) {
		this.arguments = arguments;
	}

	@Override
	public String toString() {
		return "CommandLine [command=" + command + ", arguments=" + arguments + "]";
	}
}
