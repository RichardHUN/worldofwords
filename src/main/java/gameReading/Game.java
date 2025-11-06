package gameReading;

import gameReading.core.*;
import gameReading.io.*;
import gameReading.validation.*;

public class Game {
    private final GameCoordinator coordinator;
    
    public Game(LetterGenerator letterGenerator) {
        InputOutputHandler ioHandler = new InputOutputHandler();
        ScoreValidator scoreValidator = new ScoreValidator();
        ScoreFileManager fileManager = new ScoreFileManager();
        
        this.coordinator = new GameCoordinator(ioHandler, letterGenerator, scoreValidator, fileManager);
    }
    
    public void startGame() {
        coordinator.startGame();
    }
}
