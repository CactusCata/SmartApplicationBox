package fr.cactuscata.smartapplication.questions;

import java.util.Map;

import fr.cactuscata.smartapplication.helper.Pair;
import fr.cactuscata.smartapplication.msg.Message;
import fr.cactuscata.smartapplication.msg.MessageType;
import fr.cactuscata.smartapplication.questions.request.ResponseRequest;

public class ElaborateQuestion<R extends ResponseRequest> {

	private final Message message;
	private final Map<R, Action> responses;
	private final String question;

	public ElaborateQuestion(Message message, String question, Map<R, Action> responses) {
		this.message = message;
		this.question = question;
		this.responses = responses;
	}

	public ElaborateQuestion(Message message, String question, Pair<R, Action> responses) {
		this(message, question, responses.get());
	}

	public ElaborateQuestion(MessageType messageType, String question, Map<R, Action> responses) {
		this(messageType.getMessage(), question, responses);
	}

	public ElaborateQuestion(MessageType messageType, String question, Pair<R, Action> responses) {
		this(messageType, question, responses.get());
	}

	/**
	 * Question posed by default messageType
	 */
	public ElaborateQuestion(String question, Map<R, Action> responses) {
		this(Message.getMessageInstance(), question, responses);
	}

	public ElaborateQuestion(String question, Pair<R, Action> responses) {
		this(question, responses.get());
	}

	/**
	 * Ask the user for perform an {@link Action} If the response of answer is
	 * null, re ask the question
	 */
	public final void question() {
		String answer = message.getInput(question);

		for (R r : this.responses.keySet()) {
			if (r.contains(answer)) {
				this.responses.get(r).perform();
				return;
			}
		}

		// If response is unknown, re ask
		message.sendMessage(
				"La réponse \"%s\" n'est pas correcte, veuillez choisir entre les choix suivants: %s",
				answer,
				this.responses.keySet());
		this.question();

	}

}