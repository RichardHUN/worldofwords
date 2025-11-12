package hu.unideb.inf.worldofwords.service;

import hu.unideb.inf.worldofwords.repository.GirlNamesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GirlNamesServiceImpl implements GirlNamesService {

    private final GirlNamesRepository repository;

    @Override
    public boolean isValidGirlName(String girlName) {
        return repository.findAll().getFirst().getGirlNames().contains(girlName);
    }

    @Override
    public List<String> allGirlNames() {
        return repository.findAll().getFirst().getGirlNames();
    }

}
