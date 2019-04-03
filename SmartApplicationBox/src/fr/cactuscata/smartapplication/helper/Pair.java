package fr.cactuscata.smartapplication.helper;

import java.util.HashMap;
import java.util.Map;

public class Pair<K1, K2> {

	private final Map<K1, K2> map = new HashMap<>();

	public final Pair<K1, K2> add(K1 k1, K2 k2) {
		map.put(k1, k2);
		return this;
	}

	public final Map<K1, K2> get() {
		return this.map;
	}

}
