package fr.cactuscata.smartapplication.api.ex;

public class NoInitAPIException extends SmartApplicationException {

	private static final long serialVersionUID = 1L;

	public NoInitAPIException() {
		super("The SmartApplicationBox was not initialized !");
	}
	
}
