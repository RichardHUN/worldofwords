package hu.unideb.inf.worldofwords.web;

import hu.unideb.inf.worldofwords.model.LeaderboardEntry;
import hu.unideb.inf.worldofwords.service.*;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class GameControllerImpl implements GameController{

    private final AnimalService animalService;
    private final BoyNamesService boyNamesService;
    private final GirlNamesService girlNamesService;
    private final LeaderboardService leaderboardService;
    private final CountryService countryService;
    private final CityService cityService;

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
        return countryService.allCountries();
    }

    @Override
    public List<String> allCities() {
        return cityService.allCities();
    }

    @Override
    public List<String> allGirlNames() {
        return girlNamesService.allGirlNames();
    }

    @Override
    public List<String> allBoyNames() {
        return boyNamesService.allBoyNames();
    }

    @Override
    public List<String> allAnimals() {
        return animalService.allAnimals();
    }

    @Override
    public boolean testCountryExists(String country) {
        return countryService.isValidCountry(country);
    }

    @Override
    public boolean testCityExists(String city) {
        return cityService.isValidCity(city);
    }

    @Override
    public boolean testGirlNameExists(String girlName) {
        return girlNamesService.isValidGirlName(girlName);
    }

    @Override
    public boolean testBoyNameExists(String boyName) {
        return boyNamesService.isValidBoyName(boyName);
    }

    @Override
    public boolean testAnimalExists(String animal) {
        return animalService.isValidAnimal(animal);
    }


    @Override
    public List<LeaderboardEntry> testLeaderboard() {
        return leaderboardService.getLeaderboard();
    }

    @Override
    public LeaderboardEntry updateLeaderboard(LeaderboardEntry entry) {
        return leaderboardService.updateLeaderboard(entry);
    }

    @Override
    public Optional<LeaderboardEntry> testLeaderboard(String playerName) {
        return leaderboardService.findByPlayerName(playerName);
    }

}
