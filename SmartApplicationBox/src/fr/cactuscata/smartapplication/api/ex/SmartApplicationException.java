package fr.cactuscata.smartapplication.api.ex;

import fr.cactuscata.smartapplication.msg.MessageType;

public class SmartApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SmartApplicationException(String message) {
		super(message);
	}

	public SmartApplicationException(String message, Object... objects) {
		this(String.format(message, objects));
	}

	public void sendMessage() {
		MessageType.getDefault().getMessage().sendMessage(super.getMessage());
	}

}
