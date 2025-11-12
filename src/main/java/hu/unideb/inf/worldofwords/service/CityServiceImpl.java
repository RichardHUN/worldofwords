package hu.unideb.inf.worldofwords.service;

import hu.unideb.inf.worldofwords.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    @Override
    public boolean isValidCity(String city) {
        return repository.findAll().getFirst().getCities().contains(city);
    }

    @Override
    public List<String> allCities() {
        return repository.findAll().getFirst().getCities();
    }


}
