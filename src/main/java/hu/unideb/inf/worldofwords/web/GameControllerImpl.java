package hu.unideb.inf.worldofwords.web;

import hu.unideb.inf.worldofwords.model.LeaderboardEntry;
import hu.unideb.inf.worldofwords.service.GameService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GameControllerImpl implements GameController{

    private final GameService service;

    /**
     * Used to get the random letter for the game.
     *
     * @return a random letter
     */
    @Override
    public Character letter() {
        return null;
    }

    /**
     * Used to submit the given answers for the game.
     *
     * @param given the words given by the player
     */
    @Override
    public void submit(@NonNull String given) {

    }

    /**
     * Used to get the current score of the player.
     *
     * @return null if the player has not submitted any answers yet, otherwise the current score
     */
    @Override
    public Integer score() {
        return 0;
    }

    @Override
    public List<String> allCountries() {
        return service.allCountries();
    }

    @Override
    public List<String> allCities() {
        return service.allCities();
    }

    @Override
    public List<String> allGirlNames() {
        return service.allGirlNames();
    }

    @Override
    public List<String> allBoyNames() {
        return service.allBoyNames();
    }

    @Override
    public List<String> allAnimals() {
        return service.allAnimals();
    }


    @Override
    public boolean testCountryExists(String country) {
        return service.isValidCountry(country);
    }

    @Override
    public boolean testCityExists(String city) {
        return service.isValidCity(city);
    }

    @Override
    public boolean testGirlNameExists(String girlName) {
        return service.isValidGirlName(girlName);
    }

    @Override
    public boolean testBoyNameExists(String boyName) {
        return service.isValidBoyName(boyName);
    }

    @Override
    public boolean testAnimalExists(String animal) {
        return service.isValidAnimal(animal);
    }


    @Override
    public List<LeaderboardEntry> testLeaderboard() {
        return service.getLeaderboard();
    }

    @Override
    public List<LeaderboardEntry> updateLeaderboard(LeaderboardEntry entry) {
        return service.updateLeaderboard(entry);
    }
}
