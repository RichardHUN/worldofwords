package gameReading.core;

import gameReading.io.*;
import gameReading.validation.*;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * GameCoordinator orchestrates the game flow and connects all components:
 * - InputOutputHandler for console I/O
 * - LetterGenerator for random letter generation
 * - ScoreValidator for word validation and scoring
 */
public class GameCoordinator {
    private final InputOutputHandler ioHandler;
    private final LetterGenerator letterGenerator;
    private final ScoreValidator scoreValidator;
    
    private final String[] categories = new String[]{
        "Country", "City", "Plant", "Animal", "Boy name", "Girl name"
    };
    
    private int cumulativeScore = 0;
    private int roundsPlayed = 0;
    private String username = "";
    
    public GameCoordinator(InputOutputHandler ioHandler, 
                          LetterGenerator letterGenerator,
                          ScoreValidator scoreValidator) {
        this.ioHandler = ioHandler;
        this.letterGenerator = letterGenerator;
        this.scoreValidator = scoreValidator;
    }
    
    /**
     * Start the game: welcome, get username, play rounds, and save scores.
     */
    public void startGame() {
        ioHandler.displayWelcome();
        username = ioHandler.promptForUsername();
        
        boolean keepPlaying = true;
        while (keepPlaying) {
            playRound();
            keepPlaying = ioHandler.promptPlayAgain();
        }
        
        int totalPossible = roundsPlayed * categories.length;
        ioHandler.displayFarewell(username, roundsPlayed, cumulativeScore, totalPossible);
        ioHandler.displayGoodbye();
    }
    
    /**
     * Play one round: generate letter, collect timed input, validate, score, display.
     */
    private void playRound() {
        char letter = letterGenerator.generateRandomLetter();
        ioHandler.displayRandomLetter(letter);
        
        Map<String, String> answers = new LinkedHashMap<>();
        Map<String, Boolean> correctness = new LinkedHashMap<>();
        
        boolean timedOut = collectAnswersWithTimeout(answers, letter, correctness);
        
        // Count the score from correctness map (already validated in parallel)
        int score = 0;
        for (Boolean isCorrect : correctness.values()) {
            if (isCorrect != null && isCorrect) {
                score++;
            }
        }
        
        ioHandler.displayRoundSummary(answers, correctness, categories);
        ioHandler.displayScore(score, categories.length, timedOut);
        
        cumulativeScore += score;
        roundsPlayed += 1;
    }
    
    /**
     * Collect answers from the user and validate them sequentially.
     * Returns false (no timeout for now).
     */
    private boolean collectAnswersWithTimeout(Map<String, String> answers, char letter, Map<String, Boolean> correctness) {
        // Simple sequential collection
        for (String category : categories) {
            ioHandler.promptForCategory(category);
            String userAnswer = ioHandler.readLine();
            answers.put(category, userAnswer);
        }
        
        // Validate all answers sequentially after collection
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Validating answers...");
        System.out.println("=".repeat(50));
        
        for (String category : categories) {
            String answer = answers.get(category);
            System.out.println("\n📝 Validating " + category + ": " + answer);
            boolean isValid = scoreValidator.validateWord(answer, letter, category);
            correctness.put(category, isValid);
        }
        
        return false; // No timeout
    }
}
