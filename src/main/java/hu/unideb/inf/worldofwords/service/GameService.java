package hu.unideb.inf.worldofwords.service;

import hu.unideb.inf.worldofwords.model.LeaderboardEntry;

import java.util.List;

public interface GameService {

    List<String> allCountries();

    List<String> allCities();

    List<String> allGirlNames();

    List<String> allBoyNames();

    List<String> allAnimals();

    boolean isValidCountry(String country);

    boolean isValidCity(String city);

    boolean isValidGirlName(String girlName);

    boolean isValidBoyName(String boyName);

    boolean isValidAnimal(String animal);

    List<LeaderboardEntry> getLeaderboard();

}
