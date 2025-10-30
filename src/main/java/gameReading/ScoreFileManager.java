package gameReading;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ScoreFileManager is responsible for saving game scores to a file.
 * Handles all file I/O operations related to score persistence.
 */
public class ScoreFileManager {
    private final String filename;
    
    /**
     * Create a ScoreFileManager with the default filename.
     */
    public ScoreFileManager() {
        this("scores.txt");
    }
    
    /**
     * Create a ScoreFileManager with a custom filename.
     */
    public ScoreFileManager(String filename) {
        this.filename = filename;
    }
    
    /**
     * Save the game scores to the file.
     * Appends a new line with username, rounds played, and score.
     * Returns true if successful, false otherwise.
     */
    public boolean saveScores(String username, int roundsPlayed, int cumulativeScore, int totalPossible) {
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(filename, true))) {
            fileWriter.printf("%s - Rounds: %d, Score: %d/%d%n", 
                            username, roundsPlayed, cumulativeScore, totalPossible);
            return true;
        } catch (IOException ioException) {
            return false;
        }
    }
    
    /**
     * Get the filename being used for saving scores.
     */
    public String getFilename() {
        return filename;
    }
}
