package fr.cactuscata.smartapplication.api.ex;

public class IncorrectInputException extends SmartApplicationException {

	private static final long serialVersionUID = 1L;
	
	public IncorrectInputException(String message) {
		super(message);
	}

	public IncorrectInputException(String message, Object... objects) {
		super(message, objects);
	}
}
