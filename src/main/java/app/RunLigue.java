package app;

import io.GetTeams;

public class RunLigue implements ILeague {
    public Team[] teamsDataBase;

    public RunLigue(Team[] teamsDataBase) {
        this.teamsDataBase = teamsDataBase;
    }

    public void roundRobin() {
        GetTeams getTeam = new GetTeams();
        Team myTeam = getTeam.makeTeam();

        Team[] teamsDataBase = getTeam.dataBaseTeams(myTeam);
        int n = teamsDataBase.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Round " + (i + 1));
            for (int j = 0; j < n / 2; j++) {
                int team1 = (i + j) % (n - 1);
                int team2 = (n - 1 - j + i) % (n - 1);
                if (j == 0) {
                    team2 = n - 1;
                    startMatch(teamsDataBase[team1],teamsDataBase[team2],myTeam);
                }
                else {
                    startMatch(teamsDataBase[team1],teamsDataBase[team2],myTeam);
                }
            }
        }
        table(teamsDataBase);
    }
    public void startMatch(Team team1, Team team2, Team myTeam){
        if (team1.equals(myTeam) || team2.equals(myTeam)) {
            PlayerMatch playerMatch = new PlayerMatch(team1,team2);
            playerMatch.simulate();
            playerMatch.updateStatistics();
            playerMatch.getWinner();
        } else {
            BotsMatch botsMatch = new BotsMatch(team1,team2);
            botsMatch.simulate();
            botsMatch.updateStatistics();
            botsMatch.getWinner();
        }
    }
}
