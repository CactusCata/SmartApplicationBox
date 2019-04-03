package fr.cactuscata.smartapplication.api;

import java.util.logging.Logger;

import fr.cactuscata.smartapplication.SmartApplicationBox;
import fr.cactuscata.smartapplication.msg.BoxMessage;
import fr.cactuscata.smartapplication.msg.Message;
import fr.cactuscata.smartapplication.msg.MessageType;

public class Settings {

	private static Settings instance;

	{
		instance = this;
	}

	public static Settings getInstance() {
		return instance;
	}

	private final String applicationName;
	private final Logger logger;
	private final boolean enabled;

	public Settings(String applicationName, MessageType messageTypeFormat) {
		this.applicationName = applicationName;
		this.logger = Logger.getLogger(this.getApplicationName());
		Message.setUsedMessageType(messageTypeFormat);
		if (Message.getMessageInstance() instanceof BoxMessage)
			((BoxMessage) Message.getMessageInstance()).setTitleBox(getApplicationName());
		this.enabled = true;
	}

	public Settings(String applicationName) {
		this(applicationName, MessageType.getDefault());
	}

	public String getApplicationName() {
		return this.applicationName == null ? SmartApplicationBox.getDefaultApplicationName() : this.applicationName;
	}

	public Logger getLogger() {
		return this.logger;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

}
