package hu.unideb.inf.worldofwords.service;

import hu.unideb.inf.worldofwords.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    @Override
    public boolean isValidCountry(String country) {
        return repository.findAll().getFirst().getCountries().contains(country);
    }

    @Override
    public List<String> allCountries() {
        return repository.findAll().getFirst().getCountries();
    }

}
