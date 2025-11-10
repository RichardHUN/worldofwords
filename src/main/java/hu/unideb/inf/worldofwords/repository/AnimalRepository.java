package hu.unideb.inf.worldofwords.repository;

import hu.unideb.inf.worldofwords.model.AnimalList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends MongoRepository<AnimalList, String> {
}
