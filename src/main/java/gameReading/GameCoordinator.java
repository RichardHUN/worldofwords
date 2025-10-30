package gameReading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * GameCoordinator orchestrates the game flow and connects all components:
 * - InputOutputHandler for console I/O
 * - LetterGenerator for random letter generation
 * - ScoreValidator for word validation and scoring
 * - ScoreFileManager for saving scores to file
 */
public class GameCoordinator {
    private final InputOutputHandler ioHandler;
    private final LetterGenerator letterGenerator;
    private final ScoreValidator scoreValidator;
    private final ScoreFileManager fileManager;
    
    private final String[] categories = new String[]{
        "Country", "City", "Plant", "Animal", "Object", "Boy name", "Girl name"
    };
    
    private int cumulativeScore = 0;
    private int roundsPlayed = 0;
    private String username = "";
    
    public GameCoordinator(InputOutputHandler ioHandler, 
                          LetterGenerator letterGenerator,
                          ScoreValidator scoreValidator,
                          ScoreFileManager fileManager) {
        this.ioHandler = ioHandler;
        this.letterGenerator = letterGenerator;
        this.scoreValidator = scoreValidator;
        this.fileManager = fileManager;
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
        
        if (ioHandler.promptSaveScores()) {
            boolean saved = fileManager.saveScores(username, roundsPlayed, cumulativeScore, totalPossible);
            if (saved) {
                ioHandler.displaySaveSuccess(fileManager.getFilename());
            } else {
                ioHandler.displaySaveFailure("Unable to write to file");
            }
        }
        
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
        
        boolean timedOut = collectAnswersWithTimeout(answers);
        
        int score = scoreValidator.calculateScore(answers, letter, correctness, categories);
        
        ioHandler.displayRoundSummary(answers, correctness, categories);
        ioHandler.displayScore(score, categories.length, timedOut);
        
        cumulativeScore += score;
        roundsPlayed += 1;
    }
    
    /**
     * Collect answers from the user with a 60-second timeout.
     * Returns true if timeout occurred, false otherwise.
     */
    private boolean collectAnswersWithTimeout(Map<String, String> answers) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        });
        
        Callable<Void> inputTask = () -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (String category : categories) {
                ioHandler.promptForCategory(category);
                String userAnswer = null;
                try {
                    userAnswer = reader.readLine();
                } catch (IOException ioException) {
                    userAnswer = "";
                }
                if (userAnswer == null) userAnswer = "";
                userAnswer = userAnswer.trim();
                synchronized (answers) {
                    answers.put(category, userAnswer);
                }
            }
            return null;
        };
        
        Future<Void> inputFuture = executorService.submit(inputTask);
        boolean timedOut = false;
        
        try {
            inputFuture.get(60, TimeUnit.SECONDS);
        } catch (TimeoutException timeout) {
            timedOut = true;
            ioHandler.displayTimeoutMessage();
            inputFuture.cancel(true);
        } catch (InterruptedException | ExecutionException exception) {
            ioHandler.displayInterruptionMessage(exception.getMessage());
            inputFuture.cancel(true);
        } finally {
            executorService.shutdownNow();
        }
        
        return timedOut;
    }
}
