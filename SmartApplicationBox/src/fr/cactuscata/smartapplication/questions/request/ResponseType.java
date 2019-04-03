package fr.cactuscata.smartapplication.questions.request;

import java.util.HashMap;
import java.util.Map;

import fr.cactuscata.smartapplication.questions.Action;

public enum ResponseType {

	TRUE("yes", "y", "oui", "o"), FALSE("no", "n", "non");

	private final ResponseRequest rr;

	private ResponseType(String responseRequest, String... responsesRequest) {
		this.rr = new ResponseRequest(responseRequest, responsesRequest);
	}

	public static Map<ResponseRequest, Action> convertToResponseRequest(
			Map<ResponseType, Action> map) {
		Map<ResponseRequest, Action> nmap = new HashMap<>();

		map.entrySet().forEach(entry -> nmap.put(entry.getKey().get(), entry.getValue()));

		return nmap;
	}
	
	public ResponseRequest get() {
		return this.rr;
	}

}
