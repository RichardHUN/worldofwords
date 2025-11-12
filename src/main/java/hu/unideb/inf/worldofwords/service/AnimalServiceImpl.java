package hu.unideb.inf.worldofwords.service;

import hu.unideb.inf.worldofwords.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository repository;

    @Override
    public boolean isValidAnimal(String animal) {
        return repository.findAll().getFirst().getAnimals().contains(animal);
    }

    @Override
    public List<String> allAnimals() {
        return repository.findAll().getFirst().getAnimals();
    }

}
