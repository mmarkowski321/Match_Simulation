package app;

import app.RunLigue;
import app.RunMatch;
import io.GetNumber;
import io.GetTeams;

public class Menu {
    GetNumber getNumber = new GetNumber();
    public int choice;
    public void displayManu(){
        GetTeams getTeams = new GetTeams();

        do {
            choice = getNumber.getMenuNumber();

            switch (choice) {
                case 1:
                    System.out.println("Wybrano opcję 1");
                    RunLigue runLigue = new RunLigue();
                    runLigue.roundRobin();
                    break;
                case 2:
                    System.out.println("Wybrano opcję 2");
                    RunMatch runMatch = new RunMatch();
                    runMatch.runMatch(false, getTeams.dataBaseTeams());
                    break;
                case 3:
                    System.out.println("Wybrano opcję 3");
                    RunMatch runMatch1 = new RunMatch();
                    runMatch1.runMatch(true, getTeams.dataBaseTeams());
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