package hu.unideb.inf.worldofwords.repository;

import hu.unideb.inf.worldofwords.model.Leaderboard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardRepository extends MongoRepository<Leaderboard, String> {
}
