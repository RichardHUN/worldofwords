package hu.unideb.inf.worldofwords.repository;

import hu.unideb.inf.worldofwords.model.GirlNamesList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GirlNamesRepository extends MongoRepository<GirlNamesList, String> {
}
