package fr.cactuscata.smartapplication.questions.request;

import java.util.Arrays;

import fr.cactuscata.smartapplication.helper.ArrayHelper;

public class ResponseRequest {

	private final String[] responsesRequest;

	public ResponseRequest(String responseRequest, String... responsesRequest) {
		this.responsesRequest = ArrayHelper
				.compact(new String[]{responseRequest}, responsesRequest);
	}

	public final boolean contains(String key) {
		if (key == null) return false;
		for (String rp : this.responsesRequest) {
			if (key.equalsIgnoreCase(rp)) { return true; }
		}
		return false;
	}

	/**
	 * Present the first argument
	 */
	@Override
	public final String toString() {
		return this.responsesRequest[0];
	}
	
	public final String displayAllKeyWord() {
		return Arrays.asList(this.responsesRequest).toString();
	}
	
}
