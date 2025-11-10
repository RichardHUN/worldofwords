package hu.unideb.inf.worldofwords.repository;

import hu.unideb.inf.worldofwords.model.CityList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<CityList, String> {
}
