package hu.unideb.inf.worldofwords.gameReading.gameReading;

import hu.unideb.inf.worldofwords.gameReading.core.LetterGenerator;

public class Main {
	public static void main(String[] args) {
		LetterGenerator letterGenerator = new LetterGenerator();
		Game game = new Game(letterGenerator);
		game.startGame();
	}
}
