package fr.cactuscata.smartapplication.msg;

import javax.swing.JOptionPane;

import fr.cactuscata.smartapplication.SmartApplicationBox;

public class BoxMessage extends Message {

	private String title;
	private int messageType;

	public BoxMessage(String title, int messageType) {
		setTitleBox(title);
		this.messageType = messageType;
	}

	public BoxMessage(String title) {
		this(title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public BoxMessage() {
		this(SmartApplicationBox.getDefaultApplicationName());
	}

	@Override
	public void sendMessage(Object message) {
		JOptionPane.showMessageDialog(null, message, this.title, this.messageType);
	}

	@Override
	public String getInput() {
		return this.getInput(null);
	}

	@Override
	public String getInput(Object message) {
		return JOptionPane.showInputDialog(message);
	}
	
	public final void setTitleBox(String title) {
		this.title = title;
	}

}
