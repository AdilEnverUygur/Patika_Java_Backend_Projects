package Match_Fixtures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FixtureGenerator {
    public static void main(String[] args) {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Galatasaray"));
        teams.add(new Team("Bursaspor"));
        teams.add(new Team("Fenerbahçe"));
        teams.add(new Team("Beşiktaş"));
        teams.add(new Team("Başakşehir"));
        teams.add(new Team("Trabzonspor"));
        teams.add(new Team("Boluspor"));
        // ... Add more teams

        if (teams.size() % 2 != 0) {
            teams.add(new Team("Bay"));
        }

        Collections.shuffle(teams, new Random());

        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                matches.add(new Match(teams.get(i), teams.get(j)));
            }
        }

        int round = 1;
        for (int i = 0; i < matches.size(); i += teams.size() - 1) {
            System.out.println("Round " + round);
            for (int j = i; j < i + teams.size() - 1; j++) {
                System.out.print(matches.get(j) + " ");
            }
            System.out.println();
            round++;
        }
    }
}
