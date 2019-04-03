package fr.cactuscata.smartapplication.helper;

import java.util.List;

public class StringUtils {

	public static String join(Object[] toJoin, Object toAdd, Object prefix, Object suffix, int indexToStart, int indexToStop) {
		StringBuilder builder = new StringBuilder();

		while (indexToStart < indexToStop) {
			builder.append(prefix).append(toJoin[indexToStart]).append(suffix);
			if (indexToStart + 1 != indexToStop)
				builder.append(toAdd);
			indexToStart++;
		}
		return builder.toString();
	}

	public static String join(Object[] toJoin, Object toAdd, int indexToStart) {
		return join(toJoin, toAdd, toJoin.length);
	}

	public static String join(Object[] toJoin, Object toAdd) {
		return join(toJoin, toAdd, 0);
	}

	public static String join(List<?> list, Object toAdd, int indexToStart, int indexToStop) {
		return join(list.toArray(new Object[0]), toAdd, "", "", indexToStart, indexToStop);
	}

	public static String join(List<?> list) {
		return join(list.toArray(new Object[0]), "");
	}

	public static Object join(List<?> list, String prefix, String suffix, String separator) {
		final StringBuilder builder = new StringBuilder();
		for (int i = 0, j = list.size(); i < j; i++) {
			builder.append(String.format("%s%s%s", prefix, list.get(i).toString(), suffix));
			if (i != j)
				builder.append(separator);
		}

		return builder.toString();
	}

}
