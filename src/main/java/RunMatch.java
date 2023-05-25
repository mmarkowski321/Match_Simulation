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
            SoccerMatch soccerMatch = new SoccerMatch(teamsDataBase[homeTeam],teamsDataBase[awayTeam]);
            soccerMatch.simulate(true);
            soccerMatch.getWinner();
        }
        else{
            int[] numbers = getNumber.getNumberOfChosenTeams();

            SoccerMatch soccerMatch = new SoccerMatch(teamsDataBase[numbers[1]-1],teamsDataBase[numbers[0]-1]);
            soccerMatch.simulate(true);
            soccerMatch.getWinner();
        }

    }
}