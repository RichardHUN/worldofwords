package gameReading;

import gameReading.core.LetterGenerator;

public class Main {
	public static void main(String[] args) {
		LetterGenerator letterGenerator = new LetterGenerator();
		Game game = new Game(letterGenerator);
		game.startGame();
	}
}
