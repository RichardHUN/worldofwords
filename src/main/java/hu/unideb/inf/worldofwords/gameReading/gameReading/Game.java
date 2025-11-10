package hu.unideb.inf.worldofwords.gameReading.gameReading;

import hu.unideb.inf.worldofwords.gameReading.core.GameCoordinator;
import hu.unideb.inf.worldofwords.gameReading.core.LetterGenerator;
import hu.unideb.inf.worldofwords.gameReading.io.InputOutputHandler;
import hu.unideb.inf.worldofwords.gameReading.validation.ScoreValidator;

public class Game {
    private final GameCoordinator coordinator;
    
    public Game(LetterGenerator letterGenerator) {
        InputOutputHandler ioHandler = new InputOutputHandler();
        ScoreValidator scoreValidator = new ScoreValidator();
        
        this.coordinator = new GameCoordinator(ioHandler, letterGenerator, scoreValidator);
    }
    
    public void startGame() {
        coordinator.startGame();
    }
}
