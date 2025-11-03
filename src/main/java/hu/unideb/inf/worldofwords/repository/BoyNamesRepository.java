package hu.unideb.inf.worldofwords.repository;

import hu.unideb.inf.worldofwords.model.BoyNamesList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoyNamesRepository extends MongoRepository<BoyNamesList, String> {
}
