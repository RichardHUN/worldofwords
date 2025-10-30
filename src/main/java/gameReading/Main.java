package gameReading;

/**
 * Main entry point for the Word-Start Game.
 * Creates and connects all game components, then starts the game.
 */
public class Main {
	public static void main(String[] args) {
		// Create all components
		InputOutputHandler ioHandler = new InputOutputHandler();
		LetterGenerator letterGenerator = new LetterGenerator();
		ScoreValidator scoreValidator = new ScoreValidator();
		ScoreFileManager fileManager = new ScoreFileManager();
		
		// Connect them through the coordinator
		GameCoordinator coordinator = new GameCoordinator(ioHandler, letterGenerator, scoreValidator, fileManager);
		
		// Start the game
		coordinator.startGame();
	}
}
