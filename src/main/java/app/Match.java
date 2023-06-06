package app;

import java.util.Random;

public class Match extends SoccerMatch{
    public Match(Team awayTeam, Team homeTeam) {
        super(awayTeam, homeTeam);
    }


    @Override
    public void simulate(boolean ifPlayer) {
        super.simulate(ifPlayer);
        Random random = new Random();
        Shots shots = new Shots();
        for (int minute = 1; minute <= 90; minute+=1) {
            if (ifPlayer) {
                //MY GRAMY
                ourTeamPlay(random,shots,awayTeam,homeTeam,minute);

            } else {
                //GRAJA BOTY
                oppositeTeamPlay(random,shots,awayTeam,homeTeam,minute);
            }
        }
        System.out.println("Wyniki meczu: " + homeTeam.getName() + " " + getHomeGoals() + " - " +
                awayTeam.getName() + " " + getAwayGoals());

        setFinished(true);
        //Aktualizowanie statystyk trafionych i straconych bramek dla pierwszej drużyny
        homeTeam.setGoalsScored(homeTeam.getGoalsScored()+getHomeGoals());
        homeTeam.setGoalsLosed(homeTeam.getGoalsLosed()+getAwayGoals());
        //Aktualizowanie statystyk trafionych i straconych bramek dla drugiej drużyny
        awayTeam.setGoalsScored(awayTeam.getGoalsScored()+getAwayGoals());
        awayTeam.setGoalsLosed(awayTeam.getGoalsLosed()+getHomeGoals());
        homeTeam.setGames(homeTeam.getGames()+1);
        awayTeam.setGames(awayTeam.getGames()+1);
    }
    private void ourTeamPlay(Random random,Shots shots,Team awayTeam,Team homeTeam, int minute){
        if (random.nextDouble(40)  < getHomeScoreChance()) {
            System.out.println(minute + " minuta. Szansa na gola dla naszej drużyny!");
            shots.goalPicture();
            if (shots.czyGol(awayTeam.wypelnijObrone(),true,true)) {
                setHomeGoals(getHomeGoals() + 1);

                System.out.println(minute + "': " + homeTeam.getName() + " zdobywa gola! " +
                        homeTeam.getName() + " " + getHomeGoals() + " - " + awayTeam.getName() + " " + getAwayGoals());
            }
        }
        else if (random.nextDouble(40) < getAwayScoreChance()) {
            System.out.println(minute + " minuta. Szansa na gola dla przeciwnej drużyny!");
            if (shots.czyGol(homeTeam.wypelnijObrone(),true,false)) {
                setAwayGoals(getAwayGoals() + 1);
                System.out.println(minute + "': " + awayTeam.getName() + " zdobywa gola! " +
                        homeTeam.getName() + " " + getHomeGoals() + " - " + awayTeam.getName() + " " + getAwayGoals());
            }
        }
    }
    private void oppositeTeamPlay(Random random,Shots shots,Team awayTeam,Team homeTeam, int minute){
        if (random.nextDouble(40)  < getHomeScoreChance()) {
            if (shots.czyGol(homeTeam.wypelnijObrone(),false,false)) {
                setHomeGoals(getHomeGoals() + 1);
            }
        }
        if (random.nextDouble(40)  < getAwayScoreChance()) {
            if (shots.czyGol(awayTeam.wypelnijObrone(),false,false)) {
                setAwayGoals(getAwayGoals() + 1);
            }
        }
    }
}
