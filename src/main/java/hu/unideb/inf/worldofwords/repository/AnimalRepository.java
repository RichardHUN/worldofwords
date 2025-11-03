package hu.unideb.inf.worldofwords.repository;

import hu.unideb.inf.worldofwords.model.AnimalList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalRepository extends MongoRepository<AnimalList, String> {
}
