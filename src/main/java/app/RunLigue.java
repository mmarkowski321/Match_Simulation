package app;

import io.GetTeams;

public class RunLigue {


    public RunLigue() {
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
                    Match match = new Match(teamsDataBase[team1], teamsDataBase[team2]);
                    if (teamsDataBase[team1].ifPlayer || teamsDataBase[team2].ifPlayer) {
                        match.simulate(true);
                        match.getWinner();
                    } else {
                        match.simulate(false);
                        match.getWinner();
                    }
                }
                else {
                    Match match = new Match(teamsDataBase[team1], teamsDataBase[team2]);
                    if (teamsDataBase[team1].ifPlayer || teamsDataBase[team2].ifPlayer) {
                        match.simulate(true);
                        match.getWinner();
                    } else {
                        match.simulate(false);
                        match.getWinner();
                    }
                }
            }
        }
        Table table = new Table(teamsDataBase);
        table.printTable();
    }
}
