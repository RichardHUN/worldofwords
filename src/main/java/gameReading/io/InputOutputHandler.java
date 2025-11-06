package gameReading.io;

import java.util.Map;
import java.util.Scanner;

/**
 * InputOutputHandler is responsible for all console input/output operations.
 * It prints prompts, reads user input, and displays game results.
 */
public class InputOutputHandler {
    private final Scanner scanner;
    
    public InputOutputHandler() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Display welcome message.
     */
    public void displayWelcome() {
        System.out.println("Welcome to the Word-Start Game!");
    }
    
    /**
     * Prompt for and read username from console.
     * Returns the username or "(no username)" if empty/invalid.
     */
    public String promptForUsername() {
        System.out.print("Enter your username: ");
        try {
            String userInput = scanner.nextLine();
            if (userInput == null) userInput = "";
            userInput = userInput.trim();
            if (userInput.isEmpty()) {
                return "(no username)";
            } else {
                return userInput;
            }
        } catch (Exception exception) {
            return "(no username)";
        }
    }
    
    /**
     * Display the random letter for this round.
     */
    public void displayRandomLetter(char letter) {
        System.out.println();
        System.out.println("Random letter: " + letter);
    }
    
    /**
     * Prompt for a category answer from the user.
     */
    public void promptForCategory(String category) {
        String prompt = String.format("Enter a %s: ", category);
        System.out.print(prompt);
    }
    
    /**
     * Read a line of input from the console.
     */
    public String readLine() {
        try {
            String line = scanner.nextLine();
            if (line == null) return "";
            return line.trim();
        } catch (Exception exception) {
            return "";
        }
    }
    
    /**
     * Display timeout message.
     */
    public void displayTimeoutMessage() {
        System.out.println();
        System.out.println("Time's up! Moving to scoring with answers received so far.");
    }
    
    /**
     * Display interruption message.
     */
    public void displayInterruptionMessage(String message) {
        System.out.println();
        System.out.println("Input interrupted: " + message);
    }
    
    /**
     * Display the round summary with all answers and their correctness.
     */
    public void displayRoundSummary(Map<String, String> answers, Map<String, Boolean> correctness, String[] categories) {
        System.out.println();
        for (String category : categories) {
            String word = answers.getOrDefault(category, "");
            boolean isCorrect = correctness.get(category);
            String mark = isCorrect ? "Yes" : "No";
            String displayWord = (word == null || word.isEmpty()) ? "(no entry)" : word;
            System.out.printf("%-12s: %-20s %s\n", category, displayWord, mark);
        }
    }
    
    /**
     * Display the score for the current round.
     */
    public void displayScore(int score, int total, boolean timedOut) {
        System.out.println();
        if (timedOut) {
            System.out.println("Your score (time-limited): " + score + "/" + total);
        } else {
            System.out.println("Your score: " + score + "/" + total);
        }
    }
    
    /**
     * Ask user if they want to play again.
     * Returns true for yes, false for no.
     */
    public boolean promptPlayAgain() {
        while (true) {
            System.out.print("Play again? (Y/N): ");
            try {
                String reply = scanner.nextLine();
                if (reply == null) reply = "";
                reply = reply.trim();
                if (reply.equalsIgnoreCase("Y")) {
                    return true;
                } else if (reply.equalsIgnoreCase("N")) {
                    return false;
                } else {
                    System.out.println("Please enter Y or N.");
                }
            } catch (Exception exception) {
                System.out.println("Please enter Y or N.");
            }
        }
    }
    
    /**
     * Display farewell message with game statistics.
     */
    public void displayFarewell(String username, int roundsPlayed, int cumulativeScore, int totalPossible) {
        System.out.println();
        System.out.println("Thanks for playing, " + username + "!");
        System.out.println("Rounds played: " + roundsPlayed + ", Cumulative score: " + cumulativeScore + "/" + totalPossible);
    }
    
    /**
     * Ask user if they want to save scores to file.
     * Returns true for yes, false for no.
     */
    public boolean promptSaveScores() {
        while (true) {
            System.out.print("Save scores to scores.txt? (Y/N): ");
            try {
                String saveReply = scanner.nextLine();
                if (saveReply == null) saveReply = "";
                saveReply = saveReply.trim();
                if (saveReply.equalsIgnoreCase("Y")) {
                    return true;
                } else if (saveReply.equalsIgnoreCase("N")) {
                    return false;
                } else {
                    System.out.println("Please enter Y or N.");
                }
            } catch (Exception exception) {
                System.out.println("Please enter Y or N.");
            }
        }
    }
    
    /**
     * Display save success message.
     */
    public void displaySaveSuccess(String filename) {
        System.out.println("Saved to " + filename);
    }
    
    /**
     * Display save failure message.
     */
    public void displaySaveFailure(String errorMessage) {
        System.out.println("Failed to save scores: " + errorMessage);
    }
    
    /**
     * Display goodbye message.
     */
    public void displayGoodbye() {
        System.out.println("Goodbye.");
    }
}
