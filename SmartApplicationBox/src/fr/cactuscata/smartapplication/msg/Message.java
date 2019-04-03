package fr.cactuscata.smartapplication.msg;

import fr.cactuscata.smartapplication.api.ex.IncorrectInputException;

public abstract class Message {

	private static boolean infiniteReturn = false;
	private static Message messageInstance;

	public static Message getMessageInstance() {
		return messageInstance;
	}

	public static void setUsedMessageType(MessageType messageType) {
		messageInstance = messageType.getMessage();
	}

	public static boolean isInfiniteReturnIfIsNotGood() {
		return infiniteReturn;
	}

	public static void setInfiniteReturnIfIsNotGood(boolean infiniteReturn) {
		Message.infiniteReturn = infiniteReturn;
	}

	// ------------------------------- //

	public abstract void sendMessage(Object message);

	public final void sendMessage(Object message, Object... objects) {
		this.sendMessage(String.format(String.valueOf(message), objects));
	}

	public abstract String getInput();

	public abstract String getInput(Object message);

	//

	public final String getInput(Object message, Object... objects) {
		return this.getInput(String.format(String.valueOf(message), objects));
	}

	public final int getInteger(String message) {
		String input = getInput(message);
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			if (isInfiniteReturnIfIsNotGood()) { return getInteger(message); }
			throw new IncorrectInputException("The number '%s' is not correct number !", input);
		}
	}

	public final int getInteger(String message, Object... objects) {
		return getInteger(String.format(message, objects));
	}

	public final float getFloat(String message) {
		String input = getInput(message);
		try {
			return Float.parseFloat(input);
		} catch (NumberFormatException e) {
			if (isInfiniteReturnIfIsNotGood()) { return getFloat(message); }
			throw new IncorrectInputException("The number '%s' is not correct number !", input);
		}
	}

	public final float getFloat(String message, Object... objects) {
		return getFloat(String.format(message, objects));
	}

	public final float getDouble(String message) {
		String input = getInput(message);
		try {
			return Float.parseFloat(input);
		} catch (NumberFormatException e) {
			if (isInfiniteReturnIfIsNotGood()) { return getDouble(message); }
			throw new IncorrectInputException("The number '%s' is not correct number !", input);
		}
	}

	public final float getDouble(String message, Object... objects) {
		return getDouble(String.format(message, objects));
	}

	public final char getCharacter(String message) {
		String input = getInput(message);
		if (input.length() == 1) { return input.charAt(0); }
		if (isInfiniteReturnIfIsNotGood()) { return getCharacter(message); }
		throw new IncorrectInputException("The character '%s' isn't valid !");
	}

	public final char getCharacter(String message, Object... objects) {
		return getCharacter(String.format(message, objects));
	}

}
