package Match_Fixtures;

public class Match {
    Team homeTeam;
    Team awayTeam;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return homeTeam.name + " vs " + awayTeam.name;
    }
}
