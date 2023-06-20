package app;

import io.GetNumber;
import io.GetTeams;

import java.util.Random;

/**
 * The type Run ligue.
 */
public class RunLigue {
    /**
     * The Teams data base.
     */
    public Team[] teamsDataBase;

    /**
     * Instantiates a new Run ligue.
     *
     * @param teamsDataBase the teams data base
     */
    public RunLigue(Team[] teamsDataBase) {
        this.teamsDataBase = teamsDataBase;
    }

    /**
     * Round robin.
     */
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

    /**
     * Start match.
     *
     * @param team1  the team 1
     * @param team2  the team 2
     * @param myTeam the my team
     */
    public void startMatch(Team team1, Team team2, Team myTeam){
        if (team1.equals(myTeam) || team2.equals(myTeam)) {
            Match playerMatch = new PlayerMatch(team1,team2);
            playerMatch.simulate();
            playerMatch.updateStatistics();
            playerMatch.getWinner();
        } else {
            Match botsMatch = new BotsMatch(team1,team2);
            botsMatch.simulate();
            botsMatch.updateStatistics();
            botsMatch.getWinner();
        }
    }
    private void table(Team[] teamsDataBase){
        Team[] sortingTeams = teamsDataBase;
        for (int j = 0; j < sortingTeams.length - 1; j++) {
            for (int i = 0; i < sortingTeams.length - 1; i++) {
                if (sortingTeams[i].getPoints() < sortingTeams[i + 1].getPoints()) {
                    Team a = sortingTeams[i];
                    sortingTeams[i] = sortingTeams[i + 1];
                    sortingTeams[i + 1] = a;
                } else if (sortingTeams[i].getPoints() == sortingTeams[i + 1].getPoints()) {
                    if (sortingTeams[i].getGoalsScored() - sortingTeams[i].getGoalsLosed() < sortingTeams[i + 1].getGoalsScored() - sortingTeams[i + 1].getGoalsLosed()) {
                        Team a = sortingTeams[i];
                        sortingTeams[i] = sortingTeams[i + 1];
                        sortingTeams[i + 1] = a;
                    }
                }
            }
        }
        System.out.printf("Team             | games | points | wins | draws | loses | goals | \n");
        for (int i = 0 ; i < sortingTeams.length; i ++)
        {
            System.out.printf("%-16s | %5d | %6d | %4d | %5d | %5d | %+5d |\n",sortingTeams[i].getName(),sortingTeams[i].getGames(),sortingTeams[i].getPoints(),sortingTeams[i].getWins(),sortingTeams[i].getDraw(),sortingTeams[i].getLoses(),sortingTeams[i].getGoalsScored()-sortingTeams[i].getGoalsLosed());
        }
    }

    /**
     * Run single match.
     *
     * @param czyLosowy the czy losowy
     * @param runLigue  the run ligue
     */
    public void runSingleMatch(boolean czyLosowy, RunLigue runLigue){
        Team[] teamsDataBase = runLigue.teamsDataBase;
        GetNumber getNumber = new GetNumber();
        if(czyLosowy){
            Random generator = new Random();
            int homeTeam=generator.nextInt(teamsDataBase.length-1);
            int awayTeam=homeTeam;
            while (homeTeam==awayTeam){
                awayTeam=generator.nextInt(teamsDataBase.length-1);
            }
            Match playerMatch = new PlayerMatch(teamsDataBase[homeTeam],teamsDataBase[awayTeam]);
            playerMatch.simulate();
            playerMatch.getWinner();
        }
        else{
            int[] numbers = getNumber.getNumberOfChosenTeams();

            Match playerMatch = new PlayerMatch(teamsDataBase[numbers[1]-1],teamsDataBase[numbers[0]-1]);
            playerMatch.simulate();
            playerMatch.getWinner();
        }
    }
}
