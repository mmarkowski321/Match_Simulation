package app;

import io.GetNumber;

import java.util.Random;

public class RunMatch {
    public void runMatch(boolean czyLosowy, Team[] teamsDataBase){
        GetNumber getNumber = new GetNumber();
        if(czyLosowy){
            Random generator = new Random();
            int homeTeam=generator.nextInt(5);
            int awayTeam=homeTeam;
            while (homeTeam==awayTeam){
                awayTeam=generator.nextInt(5);
            }
            Match match = new Match(teamsDataBase[homeTeam],teamsDataBase[awayTeam]);
            match.simulate(true);
            match.getWinner();
        }
        else{
            int[] numbers = getNumber.getNumberOfChosenTeams();

            Match match = new Match(teamsDataBase[numbers[1]-1],teamsDataBase[numbers[0]-1]);
            match.simulate(true);
            match.getWinner();
        }
    }
}