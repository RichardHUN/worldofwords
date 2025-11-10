package hu.unideb.inf.worldofwords.gameReading.validation;

//import gameReading.checkers.*;
import hu.unideb.inf.worldofwords.gameReading.checkers.CheckerByCategory;

import java.util.Map;

/**
 * ScoreValidator is responsible for validating words against the game rules
 * and calculating scores. It uses WordChecker for dictionary validation.
 */
public class ScoreValidator {
    
    /**
     * Validate that a word starts with the given letter (case-insensitive).
     * Routes to appropriate checker based on category:
     * - City/Country: uses CountryCityChecker
     * - Boy name/Girl name: uses NameChecker
     * - Other categories: uses WordChecker
     * Returns true if valid, false otherwise. Empty or null words are invalid.
     */
    public boolean validateWord(String word, char letter, String category) {
        if (word == null) return false;
        word = word.trim();
        if (word.isEmpty()) return false;
        
        // Check if first letter matches
        char firstCharacter = Character.toUpperCase(word.charAt(0));
        if (firstCharacter != Character.toUpperCase(letter)) {
            return false;
        }
        
        // Route to CheckerByCategory based on category
        switch (category) {
            case "Country":
                return CheckerByCategory.isValidCountry(word);
            case "City":
                return CheckerByCategory.isValidCity(word);
            case "Boy name":
                return CheckerByCategory.isValidMaleName(word);
            case "Girl name":
                return CheckerByCategory.isValidFemaleName(word);
            case "Animal":
                return CheckerByCategory.isValidAnimalName(word);
            case "Plant":
                return CheckerByCategory.isValidPlantName(word);
            default:
                return false; // Unknown category
        }
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
            boolean isCorrect = validateWord(input, letter, category);
            correctness.put(category, isCorrect);
            if (isCorrect) {
                score += 1;
            }
        }
        return score;
    }
}
