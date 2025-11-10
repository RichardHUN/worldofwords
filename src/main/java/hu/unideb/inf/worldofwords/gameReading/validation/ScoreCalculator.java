package hu.unideb.inf.worldofwords.gameReading.validation;

/**
 * ScoreCalculator handles all scoring logic for the game.
 * 
 * Scoring rules:
 * - Valid word in correct category: 10 points
 * - Word is 7+ letters long: +5 bonus points
 * - Answer submitted in under 5 seconds: +5 bonus points
 * - All categories correct: +20 bonus points
 */
public class ScoreCalculator {
    
    private static final int BASE_POINTS = 10;
    private static final int LONG_WORD_BONUS = 5;
    private static final int FAST_ANSWER_BONUS = 5;
    private static final int ALL_CORRECT_BONUS = 20;
    private static final int LONG_WORD_THRESHOLD = 7;
    private static final long FAST_ANSWER_THRESHOLD_MS = 5000; // 5 seconds
    
    /**
     * Calculate points for a single answer.
     * 
     * @param word The word entered by the player
     * @param isCorrect Whether the word is valid for the category
     * @param timeInMillis Time taken to answer in milliseconds
     * @return Points earned for this answer
     */
    public int calculateAnswerPoints(String word, boolean isCorrect, long timeInMillis) {
        if (!isCorrect) {
            return 0; // No points for incorrect answers
        }
        
        int points = BASE_POINTS;
        
        // Bonus for long words (7+ characters)
        if (word.length() >= LONG_WORD_THRESHOLD) {
            points += LONG_WORD_BONUS;
        }
        
        // Bonus for fast answers (under 5 seconds)
        if (timeInMillis < FAST_ANSWER_THRESHOLD_MS) {
            points += FAST_ANSWER_BONUS;
        }
        
        return points;
    }
    
    /**
     * Calculate total points for a round including the all-correct bonus.
     * 
     * @param answerPoints Array of points earned for each answer
     * @param totalCategories Total number of categories in the game
     * @return Total points for the round
     */
    public int calculateRoundTotal(int[] answerPoints, int totalCategories) {
        int total = 0;
        int correctCount = 0;
        
        for (int points : answerPoints) {
            total += points;
            if (points > 0) {
                correctCount++;
            }
        }
        
        // Bonus if all categories are correct
        if (correctCount == totalCategories) {
            total += ALL_CORRECT_BONUS;
        }
        
        return total;
    }
    
    /**
     * Get the maximum possible points for a single answer (with all bonuses).
     */
    public int getMaxPointsPerAnswer() {
        return BASE_POINTS + LONG_WORD_BONUS + FAST_ANSWER_BONUS;
    }
    
    /**
     * Get the all-correct bonus value.
     */
    public int getAllCorrectBonus() {
        return ALL_CORRECT_BONUS;
    }
}
