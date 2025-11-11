package hu.unideb.inf.worldofwords.web;

import hu.unideb.inf.worldofwords.model.LeaderboardEntry;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface GameController {

    /**
     * Used to get the random letter for the game.
     * @return a random letter
     */
    @GetMapping("/game/letter")
    Character letter();

    /**
     * Used to submit the given answers for the game.
     * @param given the words given by the player
     */
    @PostMapping("/game/submit")
    void submit(@NonNull @RequestBody String given);

    /**
     * Used to get the current score of the player.
     * @return null if the player has not submitted any answers yet, otherwise the current score
     */
    @GetMapping("/game/score")
    Integer score();

    //temp
    @GetMapping("/testCountries")
    List<String> allCountries();

    @GetMapping("/testCities")
    List<String> allCities();

    @GetMapping("/testGirlNames")
    List<String> allGirlNames();

    @GetMapping("/testBoyNames")
    List<String> allBoyNames();

    @GetMapping("/testAnimals")
    List<String> allAnimals();


    @GetMapping("/testCountry")
    boolean testCountryExists(@RequestParam String country);

    @GetMapping("/testCity")
    boolean testCityExists(@RequestParam String city);

    @GetMapping("/testGirlName")
    boolean testGirlNameExists(@RequestParam String girlName);

    @GetMapping("/testBoyName")
    boolean testBoyNameExists(@RequestParam String boyName);

    @GetMapping("/testAnimal")
    boolean testAnimalExists(@RequestParam String animal);


    @GetMapping("/testLeaderboard")
    List<LeaderboardEntry> testLeaderboard();

}
