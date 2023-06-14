package app;

import io.GetNumber;
import io.GetTeams;

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
                    runLigue.runSingleMatch(false, runLigue);
                    break;
                case 3:
                    System.out.println("Wybrano opcję 3");
                    runLigue.runSingleMatch(true, runLigue);
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



}