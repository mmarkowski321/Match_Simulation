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
        int numberOfTeams = teamsDataBase.length;
        for (int index1 = 0; index1 < numberOfTeams - 1; index1++) {
            System.out.println("Round " + (index1 + 1));
            for (int index2 = 0; index2 < numberOfTeams / 2; index2++) {
                int team1 = (index1 + index2) % (numberOfTeams - 1);
                int team2 = (numberOfTeams - 1 - index2 + index1) % (numberOfTeams - 1);
                if (index2 == 0) {
                    team2 = numberOfTeams - 1;
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
