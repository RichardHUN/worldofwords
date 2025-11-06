package gameReading;

import gameReading.core.*;
import gameReading.io.*;
import gameReading.validation.*;

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
