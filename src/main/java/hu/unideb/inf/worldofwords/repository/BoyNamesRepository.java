package hu.unideb.inf.worldofwords.repository;

import hu.unideb.inf.worldofwords.model.BoyNamesList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoyNamesRepository extends MongoRepository<BoyNamesList, String> {
}
