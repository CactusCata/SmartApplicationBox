package fr.cactuscata.smartapplication.msg;

import java.util.Scanner;

public class ConsoleMessage extends Message {

	private final Scanner scanner = new Scanner(System.in);

	@Override
	public void sendMessage(Object message) {
		System.out.println(message);
	}

	@Override
	public String getInput() {
		return this.scanner.nextLine();
	}

	@Override
	public String getInput(Object message) {
		this.sendMessage(message);
		return this.getInput();
	}

}
