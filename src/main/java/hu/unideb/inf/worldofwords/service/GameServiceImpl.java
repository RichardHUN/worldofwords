package hu.unideb.inf.worldofwords.service;

import hu.unideb.inf.worldofwords.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

/*@AllArgsConstructor
@RequiredArgsConstructor*/
@Service
public class GameServiceImpl implements GameService {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final GirlNamesRepository girlNamesRepository;
    private final BoyNamesRepository boyNamesRepository;
    private final AnimalRepository animalRepository;

    public GameServiceImpl(CountryRepository countryRepository, CityRepository cityRepository, GirlNamesRepository girlNamesRepository, BoyNamesRepository boyNamesRepository, AnimalRepository animalRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.girlNamesRepository = girlNamesRepository;
        this.boyNamesRepository = boyNamesRepository;
        this.animalRepository = animalRepository;
    }

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
}
