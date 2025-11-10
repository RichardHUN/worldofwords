package hu.unideb.inf.worldofwords.gameReading.core;

import java.util.Random;

/**
 * LetterGenerator is responsible for producing random uppercase letters A-Z.
 * Separated from game I/O so generation logic is decoupled.
 */
public class LetterGenerator {
    private final Random random;

    public LetterGenerator() {
        this.random = new Random();
    }

    /**
     * Generate a random uppercase English letter A-Z.
     */
    public char generateRandomLetter() {
        return (char) ('A' + random.nextInt(26));
    }
}
