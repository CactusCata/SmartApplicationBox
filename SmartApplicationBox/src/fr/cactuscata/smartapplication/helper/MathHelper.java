package fr.cactuscata.smartapplication.helper;

import java.util.Random;

public class MathHelper {
	
	private static final Random random = new Random();

	public static float round(double calcul, int numberAfterDecimalPoint) {
		return (float) (((int) (calcul * Math.pow(10, numberAfterDecimalPoint) + 0.5)) / Math.pow(10, numberAfterDecimalPoint));
	}
	
	public static int random(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
	
}
