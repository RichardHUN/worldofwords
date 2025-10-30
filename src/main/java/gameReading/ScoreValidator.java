package gameReading;

import java.util.Map;

/**
 * ScoreValidator is responsible for validating words against the game rules
 * and calculating scores.
 */
public class ScoreValidator {
    
    /**
     * Validate that a word starts with the given letter (case-insensitive).
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
     * Calculate the score for a round based on the answers and letter.
     * Returns the number of correct answers.
     * Also populates the correctness map for each category.
     */
    public int calculateScore(Map<String, String> answers, char letter, 
                             Map<String, Boolean> correctness, String[] categories) {
        int score = 0;
        for (String category : categories) {
            String input = answers.getOrDefault(category, "");
            boolean isCorrect = validateWord(input, letter);
            correctness.put(category, isCorrect);
            if (isCorrect) {
                score += 1;
            }
        }
        return score;
    }
}
