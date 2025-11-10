package hu.unideb.inf.worldofwords.repository;

import hu.unideb.inf.worldofwords.model.CityList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<CityList, String> {
}
