package hu.unideb.inf.worldofwords.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Leaderboard")
public class Leaderboard {

    private List<LeaderboardEntry> leaderboard;

}
