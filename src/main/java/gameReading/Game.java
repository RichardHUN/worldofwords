package gameReading;

import gameReading.core.LetterGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
// (removed unused time imports)
import java.util.LinkedHashMap;
import java.util.Map;
// removed dictionary imports
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Game class implements the backend logic for the word game.
 * It generates a random letter and asks the user for words in several categories.
 * Uses only Java standard library.
 */
public class Game {
    private final Scanner scanner;
    // letter generator is injected so generation is separated from CLI logic
    private final LetterGenerator generator;
    // Categories in order
    private final String[] categories = new String[]{
            "Country", "City", "Plant", "Animal", "Object", "Boy name", "Girl name"
    };

    // Track cumulative totals across rounds (optional improvement)
    private int cumulativeScore = 0;
    private int roundsPlayed = 0;
    // Store username to save with scores
    private String username = "";

    public Game(LetterGenerator generator) {
        this.scanner = new Scanner(System.in);
        this.generator = generator;
    }

    // Letter generation moved to LetterGenerator

    /**
     * Validate that the word starts with the given letter (case-insensitive).
     * Returns true if valid, false otherwise. Empty or null words are invalid.
     */
    public boolean validateWord(String word, char letter) {
        if (word == null) return false;
        word = word.trim();
        if (word.isEmpty()) return false;
        char firstCharacter = Character.toUpperCase(word.charAt(0));
        return firstCharacter == Character.toUpperCase(letter);
    }

    

    /**
     * Play one round: generate letter, prompt user for each category, validate and score.
     */
    public void playRound() {
    char letter = generator.generateRandomLetter();
        System.out.println();
        System.out.println("Random letter: " + letter);

        Map<String, String> answers = new LinkedHashMap<>();
        Map<String, Boolean> correctness = new LinkedHashMap<>();

        // Use an executor to gather all inputs for the round in a separate daemon thread
        ExecutorService executorService = Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true); // don't block JVM exit if thread remains blocked on IO
            return thread;
        });

        Callable<Void> inputTask = () -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (String category : categories) {
                String prompt = String.format("Enter a %s: ", category);
                System.out.print(prompt);
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
            // Wait up to 60 seconds for the whole round's inputs
            inputFuture.get(60, TimeUnit.SECONDS);
        } catch (TimeoutException timeout) {
            timedOut = true;
            System.out.println();
            System.out.println("Time's up! Moving to scoring with answers received so far.");
            // attempt to cancel the task; underlying read may still block but thread is daemon
            inputFuture.cancel(true);
        } catch (InterruptedException | ExecutionException exception) {
            // If something else went wrong, print and continue with what we have
            System.out.println();
            System.out.println("Input interrupted: " + exception.getMessage());
            inputFuture.cancel(true);
        } finally {
            executorService.shutdownNow();
        }

        int score = 0;

        // Build correctness and score from whatever answers we have (partial if timed out)
        for (String category : categories) {
            String input;
            synchronized (answers) {
                input = answers.getOrDefault(category, "");
            }
            boolean isCorrect = validateWord(input, letter);
            correctness.put(category, isCorrect);
            if (isCorrect) score += 1;
        }

        // Display summary for this round
        System.out.println();
        for (String category : categories) {
            String word = answers.getOrDefault(category, "");
            boolean isCorrect = correctness.get(category);
            String mark = isCorrect ? "Yes" : "No";
            String displayWord = (word == null || word.isEmpty()) ? "(no entry)" : word;
            System.out.printf("%-12s: %-20s %s\n", category, displayWord, mark);
        }
        System.out.println();
        if (timedOut) {
            System.out.println("Your score (time-limited): " + score + "/" + categories.length);
        } else {
            System.out.println("Your score: " + score + "/" + categories.length);
        }

        // Update cumulative
        cumulativeScore += score;
        roundsPlayed += 1;
    }

    /**
     * Start the game loop: play rounds until user chooses to stop.
     * After exit, offer to save cumulative score to scores.txt.
     */
    public void startGame() {
        System.out.println("Welcome to the Word-Start Game!");

        // Ask for username once at the start
        System.out.print("Enter your username: ");
        try {
            String userInput = scanner.nextLine();
            if (userInput == null) userInput = "";
            userInput = userInput.trim();
            if (userInput.isEmpty()) {
                username = "(no username)";
            } else {
                username = userInput;
            }
        } catch (Exception exception) {
            username = "(no username)";
        }
        boolean keepPlaying = true;

        while (keepPlaying) {
            playRound();

            // Ask to play again
            String reply = null;
            while (true) {
                System.out.print("Play again? (Y/N): ");
                try {
                    reply = scanner.nextLine();
                } catch (Exception exception) {
                    reply = "";
                }
                if (reply == null) reply = "";
                reply = reply.trim();
                if (reply.equalsIgnoreCase("Y")) {
                    keepPlaying = true;
                    break;
                } else if (reply.equalsIgnoreCase("N")) {
                    keepPlaying = false;
                    break;
                } else {
                    System.out.println("Please enter Y or N.");
                }
            }
        }

    System.out.println();
    System.out.println("Thanks for playing, " + username + "!");
    System.out.println("Rounds played: " + roundsPlayed + ", Cumulative score: " + cumulativeScore + "/" + (roundsPlayed * categories.length));

        // Offer to save to file (saves username and scores)
        String saveReply = null;
        while (true) {
            System.out.print("Save scores to scores.txt? (Y/N): ");
            try {
                saveReply = scanner.nextLine();
            } catch (Exception exception) {
                saveReply = "";
            }
            if (saveReply == null) saveReply = "";
            saveReply = saveReply.trim();
            if (saveReply.equalsIgnoreCase("Y")) {
                saveScores();
                break;
            } else if (saveReply.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Please enter Y or N.");
            }
        }

        System.out.println("Goodbye.");
    }

    /**
     * Save the cumulative score and timestamp to scores.txt in the current working directory.
     */
    private void saveScores() {
        String filename = "scores.txt";
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(filename, true))) {
            fileWriter.printf("%s - Rounds: %d, Score: %d/%d%n", username, roundsPlayed, cumulativeScore, roundsPlayed * categories.length);
            System.out.println("Saved to " + filename);
        } catch (IOException ioException) {
            System.out.println("Failed to save scores: " + ioException.getMessage());
        }
    }
}
