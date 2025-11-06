package gameReading.checkers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NameChecker {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static boolean isLegitName(String name) {
        try {
            String apiUrl = "https://api.nationalize.io/?name=" + name.trim().toLowerCase();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // Check if response is successful
            if (response.statusCode() != 200) {
                return false;
            }
            
            String body = response.body();
            
            // Check if the API found any country matches (not an empty array)
            // Valid names have: "country":[{...}]
            // Invalid/unknown names have: "country":[]
            return body.contains("\"country\":[{") && !body.contains("\"country\":[]");
        } catch (Exception e) {
            System.out.println("⚠️ Name checker error: " + e.getMessage());
            return false;
        }
    }
}
