package hu.unideb.inf.worldofwords.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardEntry {

    private String playerName;
    private int score;

}
