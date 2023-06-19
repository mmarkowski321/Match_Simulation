package app;

import io.GetNumber;
import io.GetTeams;

import java.util.Random;

public class Menu {
    GetNumber getNumber = new GetNumber();
    public int choice;
    public void displayMenu(){
        GetTeams getTeams = new GetTeams();
        RunLigue runLigue = new RunLigue(getTeams.dataBaseTeams());
        do {
            choice = getNumber.getMenuNumber();

            switch (choice) {
                case 1:
                    System.out.println("Wybrano opcję 1");
                    runLigue.roundRobin();
                    break;
                case 2:
                    System.out.println("Wybrano opcję 2");
                    runSingleMatch(false, runLigue);
                    break;
                case 3:
                    System.out.println("Wybrano opcję 3");
                    runSingleMatch(true, runLigue);
                    break;
                case 4:
                    System.out.println("Wyjście z programu");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór");
                    break;
            }
        } while (choice != 4);
    }
    private void runSingleMatch(boolean czyLosowy, RunLigue runLigue){
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