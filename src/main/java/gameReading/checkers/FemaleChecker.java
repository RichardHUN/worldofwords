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
public class FemaleChecker {
    private static Set<String> femaleNames = null;
    private static final String FEMALE_NAMES_FILE = "gameReading/checkers/femaleNames.txt";

    /**
     * Loads male names from file into a HashSet (only once).
     * This makes lookups extremely fast.
     */
    private static void loadFemaleNames() {
        if (femaleNames != null) {
            return; // Already loaded
        }

        femaleNames = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FEMALE_NAMES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Trim whitespace and add lowercase version for case-insensitive matching
                String name = line.trim().toLowerCase();
                if (!name.isEmpty()) {
                    femaleNames.add(name);
                }
            }
            System.out.println("✅ Loaded " + femaleNames.size() + " female names");
        } catch (IOException e) {
            System.out.println("⚠️ Error loading female names: " + e.getMessage());
            femaleNames = new HashSet<>(); // Empty set to avoid null pointer
        }
    }
    
    /**
     * Checks if the given name is a valid male name.
     * Very fast O(1) lookup using HashSet.
     * Case-insensitive comparison.
     * 
     * @param name The name to check
     * @return true if name exists in femaleNames.txt, false otherwise
     */
    public static boolean isValidFemaleName(String name) {
        if (femaleNames == null) {
            loadFemaleNames();
        }
        
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        
        // Check in HashSet (very fast!)
        return femaleNames.contains(name.trim().toLowerCase());
    }
}
