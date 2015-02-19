package de.uks.beast.editor.testutil;

import java.util.Random;

public class RandomValueGenerator {

	private final static Random random = new Random();

	private int generateIntFromNullTo(int max) {
		return randInt(0, max);
	}

	public static int randInt(int min, int max) {
		int randomNum = random.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public static void main(String[] args) {
		RandomValueGenerator rvg = new RandomValueGenerator();
		for (int i = 0; i < 10; i++) {
			System.out.println(rvg.generateIntFromNullTo(100));
		}
	}
}
