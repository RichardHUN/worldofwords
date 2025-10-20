package hu.unideb.inf.worldofwords.repository;

import hu.unideb.inf.worldofwords.model.CountryList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<CountryList, String> {
}
