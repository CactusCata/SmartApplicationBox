package fr.cactuscata.smartapplication;

import fr.cactuscata.smartapplication.api.Settings;
import fr.cactuscata.smartapplication.api.ex.NoInitAPIException;
import fr.cactuscata.smartapplication.msg.MessageType;

public abstract class SmartApplicationBox {

	private static Settings settings;

	public SmartApplicationBox(Settings settings) {
		SmartApplicationBox.settings = settings;
	}

	public SmartApplicationBox(String applicationName, MessageType messageType) {
		this(new Settings(applicationName, messageType));
		this.launchScript();
	}

	public abstract void launchScript();
	
	public static Settings getSettings() {
		if (settings == null || !settings.isEnabled()) throw new NoInitAPIException();
		return SmartApplicationBox.settings;
	}

	public static String getDefaultApplicationName() {
		return "SmartApplicationBox";
	}
	
}
