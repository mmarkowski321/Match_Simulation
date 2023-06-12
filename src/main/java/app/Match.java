package app;


import io.GetNumber;

import java.util.HashSet;
import java.util.Random;

abstract class Match {
    final Team homeTeam;
    final Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private boolean isFinished;



    public Match(Team awayTeam, Team homeTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    public boolean isFinished() {
        return isFinished;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

//    public void goalPicture(){
//        System.out.println("=====================");
//        System.out.println("|| 1  2  3  4  5  6||");
//        System.out.println("|| 7  8  9 10 11 12||");
//        System.out.println("||13 14 15 16 17 18||");
//
//    }
//    public static boolean czyGol(HashSet<Integer> defencePoints, boolean ifPlayer, boolean playerIsShooting){
//        if (ifPlayer && playerIsShooting) {
//            GetNumber getNumberWhereToShot = new GetNumber();
//            int strzal = getNumberWhereToShot.getNumberWhereToShot();
//            System.out.println(strzal);
//            if (defencePoints.contains(strzal)) {
//                System.out.println("Nie ma gola, bramkarz swietnie obronił");
//                System.out.println();
//                return false;
//            } else {
//                System.out.println("Gooool!!!");
//                System.out.println();
//                return true;
//            }
//        }
//        else if (ifPlayer){
//            Random random = new Random();
//            int strzal = random.nextInt(18) + 1;
//
//            //        if (city.getName()!=null){name = city.getName();}else{name="N/A"}
//
//            if(defencePoints.contains(strzal)) {
//                System.out.println("nie ma gola, bramkarz swietnie obronił \n");
//                return false;
//            }
//            else{
//                {System.out.println("gooool!!!\n");}
//                return true;
//            }
//        }
//        else{
//            Random random = new Random();
//            int strzal = random.nextInt(18) + 1;
//            return !defencePoints.contains(strzal);
//        }
//    }
    public static void updatesAfterMatch(Team homeTeam, Team awayTeam, int homeGoals,int awayGoals){
        //Aktualizowanie statystyk trafionych i straconych bramek dla pierwszej drużyny
        homeTeam.setGoalsScored(homeTeam.getGoalsScored() + homeGoals);
        homeTeam.setGoalsLosed(homeTeam.getGoalsLosed() + awayGoals);
        //Aktualizowanie statystyk trafionych i straconych bramek dla drugiej drużyny
        awayTeam.setGoalsScored(awayTeam.getGoalsScored() + awayGoals);
        awayTeam.setGoalsLosed(awayTeam.getGoalsLosed() + homeGoals);
        homeTeam.setGames(homeTeam.getGames() + 1);
        awayTeam.setGames(awayTeam.getGames() + 1);
    }

}
