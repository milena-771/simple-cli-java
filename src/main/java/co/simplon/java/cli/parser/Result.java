package co.simplon.java.cli.parser;

public class Result {

	private String response;

	public Result() {
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Result [response=" + response + "]";
	}	
}
