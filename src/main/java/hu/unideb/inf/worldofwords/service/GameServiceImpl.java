package hu.unideb.inf.worldofwords.service;

import hu.unideb.inf.worldofwords.model.Leaderboard;
import hu.unideb.inf.worldofwords.model.LeaderboardEntry;
import hu.unideb.inf.worldofwords.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class GameServiceImpl implements GameService {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final GirlNamesRepository girlNamesRepository;
    private final BoyNamesRepository boyNamesRepository;
    private final AnimalRepository animalRepository;
    private final LeaderboardRepository leaderboardRepository;

    @Override
    public List<String> allCountries() {
        return countryRepository.findAll().getFirst().getCountries();
    }

    @Override
    public List<String> allCities() {
        return cityRepository.findAll().getFirst().getCities();
    }

    @Override
    public List<String> allGirlNames() {
        return girlNamesRepository.findAll().getFirst().getGirlNames();
    }

    @Override
    public List<String> allBoyNames() {
        return boyNamesRepository.findAll().getFirst().getBoyNames();
    }

    @Override
    public List<String> allAnimals() {
        return animalRepository.findAll().getFirst().getAnimals();
    }

    @Override
    public boolean isValidCountry(String country) {
        return countryRepository.findAll().getFirst().getCountries().contains(country);
    }

    @Override
    public boolean isValidCity(String city) {
        return cityRepository.findAll().getFirst().getCities().contains(city);
    }

    @Override
    public boolean isValidGirlName(String girlName) {
        return girlNamesRepository.findAll().getFirst().getGirlNames().contains(girlName);
    }

    @Override
    public boolean isValidBoyName(String boyName) {
        return boyNamesRepository.findAll().getFirst().getBoyNames().contains(boyName);
    }

    @Override
    public boolean isValidAnimal(String animal) {
        return animalRepository.findAll().getFirst().getAnimals().contains(animal);
    }

    @Override
    public List<LeaderboardEntry> getLeaderboard() {
        return leaderboardRepository.findAll().getFirst().getLeaderboard()
                .stream()
                .sorted(Comparator.comparingInt(LeaderboardEntry::getScore).reversed())
                .toList();
    }

    @Override
    public List<LeaderboardEntry> updateLeaderboard(LeaderboardEntry entry) {
        List<LeaderboardEntry> leaderboardEntryList = new ArrayList<>(getLeaderboard());
        leaderboardEntryList.add(entry);

        leaderboardRepository.deleteAll();
        saveLeaderboard(new Leaderboard(leaderboardEntryList));

        return getLeaderboard();
    }

    @Override
    public Leaderboard saveLeaderboard(Leaderboard leaderboard) {
        return leaderboardRepository.save(leaderboard);
    }
}
