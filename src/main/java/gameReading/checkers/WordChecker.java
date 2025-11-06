package gameReading.checkers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WordChecker {

    public static boolean isLegitWord(String word) {
        try {
            word = word.toLowerCase().trim();
            String apiUrl = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int statusCode = connection.getResponseCode();
            connection.disconnect();

            return statusCode == 200; // 200 = word exists
        } catch (IOException e) {
            System.out.println("⚠️ Network error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String[] testWords = {"apple", "apopllkjf", "banana", "heloo"};

        for (String word : testWords) {
            if (isLegitWord(word)) {
                System.out.println("✅ " + word + " is a real English word.");
            } else {
                System.out.println("❌ " + word + " is NOT a real word.");
            }
        }
    }
}
