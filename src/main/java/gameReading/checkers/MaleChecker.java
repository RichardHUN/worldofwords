package gameReading.checkers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * MaleChecker validates male names by checking against a pre-loaded list.
 * Uses HashSet for O(1) lookup time - very fast!
 */
public class MaleChecker {
    private static Set<String> maleNames = null;
    private static final String MALE_NAMES_FILE = "gameReading/checkers/maleNames.txt";
    
    /**
     * Loads male names from file into a HashSet (only once).
     * This makes lookups extremely fast.
     */
    private static void loadMaleNames() {
        if (maleNames != null) {
            return; // Already loaded
        }
        
        maleNames = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MALE_NAMES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Trim whitespace and add lowercase version for case-insensitive matching
                String name = line.trim().toLowerCase();
                if (!name.isEmpty()) {
                    maleNames.add(name);
                }
            }
            System.out.println("✅ Loaded " + maleNames.size() + " male names");
        } catch (IOException e) {
            System.out.println("⚠️ Error loading male names: " + e.getMessage());
            maleNames = new HashSet<>(); // Empty set to avoid null pointer
        }
    }
    
    /**
     * Checks if the given name is a valid male name.
     * Very fast O(1) lookup using HashSet.
     * Case-insensitive comparison.
     * 
     * @param name The name to check
     * @return true if name exists in maleNames.txt, false otherwise
     */
    public static boolean isValidMaleName(String name) {
        // Load names on first use (lazy loading)
        if (maleNames == null) {
            loadMaleNames();
        }
        
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        
        // Check in HashSet (very fast!)
        return maleNames.contains(name.trim().toLowerCase());
    }
}
