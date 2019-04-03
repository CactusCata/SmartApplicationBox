package fr.cactuscata.smartapplication.questions.request;

import fr.cactuscata.smartapplication.helper.Pair;
import fr.cactuscata.smartapplication.questions.Action;

public class PairRequest extends Pair<ResponseRequest, Action> {

	public PairRequest add(ResponseType k1, Action k2) {
		super.add(k1.get(), k2);
		return this;
	}

}
