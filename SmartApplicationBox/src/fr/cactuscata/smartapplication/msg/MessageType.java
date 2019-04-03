package fr.cactuscata.smartapplication.msg;

public enum MessageType {

	CONSOLE(new ConsoleMessage()),
	BOX(new BoxMessage());
	
	private final Message message;
	
	private MessageType(Message message) {
		this.message = message;
	}
	
	public static MessageType getDefault() {
		return MessageType.CONSOLE;
	}

	public Message getMessage() {
		return this.message;
	}
}
