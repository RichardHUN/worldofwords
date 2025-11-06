package gameReading.checkers;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class PlantAnimalChecker {

    // Returns true only if word is valid AND is an animal
    public static boolean isValid(String word, String category) {
        try {
            String apiUrl = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word.toLowerCase();
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int status = conn.getResponseCode();
            if (status != 200) {
                conn.disconnect();
                return false; // Not a valid word
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
            reader.close();
            conn.disconnect();

            // Parse JSON using Gson
            JsonArray jsonArray = JsonParser.parseString(sb.toString()).getAsJsonArray();
            JsonArray meanings = jsonArray.get(0).getAsJsonObject().getAsJsonArray("meanings");

            // Check definitions for animal keywords
            for (int i = 0; i < meanings.size(); i++) {
                JsonArray definitions = meanings.get(i).getAsJsonObject().getAsJsonArray("definitions");
                for (int j = 0; j < definitions.size(); j++) {
                    String def = definitions.get(j).getAsJsonObject()
                                    .get("definition").getAsString().toLowerCase();
                    
                    List<String> sentenceWords = List.of(def.split("\\s+"));
                    List<String> plantOrAnimalList = (category.equals("Plant")? PlantsAnimalsKeyWords.getPlantsKeyWords() : PlantsAnimalsKeyWords.getAnimalsKeyWords());    
                    
                    if(sentenceWords.stream()
                .anyMatch(e ->
                    plantOrAnimalList.stream()
                            .map(String::toLowerCase)
                            .anyMatch(target ->
                                e.contains(target) || target.contains(e)
                            )
                ) || plantOrAnimalList.contains(word))
                {
                    return true; // Valid word and classified as animal/plant
                }
                }
            }

        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }

        return false; // Either invalid word or not an animal
    }
}
