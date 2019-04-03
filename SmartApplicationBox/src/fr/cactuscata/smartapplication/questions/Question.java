package fr.cactuscata.smartapplication.questions;

import java.util.Map;

import fr.cactuscata.smartapplication.msg.Message;
import fr.cactuscata.smartapplication.msg.MessageType;
import fr.cactuscata.smartapplication.questions.request.SimpleResponseRequest;;

public class Question extends ElaborateQuestion<SimpleResponseRequest> {

	public Question(Message message,
			String question,
			Map<SimpleResponseRequest, Action> responses) {
		super(message, question, responses);
	}

	public Question(MessageType messageType,
			String question,
			Map<SimpleResponseRequest, Action> responses) {
		super(messageType.getMessage(), question, responses);
	}

	/**
	 * Question posed by default messageType
	 */
	public Question(String question, Map<SimpleResponseRequest, Action> responses) {
		super(Message.getMessageInstance(), question, responses);
	}

	

}
