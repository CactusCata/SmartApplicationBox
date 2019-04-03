package fr.cactuscata.smartapplication.helper;

import java.util.Arrays;

public class ArrayHelper {

	/**
	 * 
	 * Compact all arrays of array in an array.
	 * 
	 * @param arrays
	 *            to compact
	 * @return
	 */
	@SafeVarargs
	public static <T> T[] compact(T[]... arrays) {
		int finalLength = 0;
		for (T[] array : arrays) {
			finalLength += array.length;
		}

		T[] dest = null;
		int destPos = 0;

		for (T[] array : arrays) {
			if (dest == null) {
				dest = Arrays.copyOf(array, finalLength);
				destPos = array.length;
			} else {
				System.arraycopy(array, 0, dest, destPos, array.length);
				destPos += array.length;
			}
		}
		return dest;
	}
}
