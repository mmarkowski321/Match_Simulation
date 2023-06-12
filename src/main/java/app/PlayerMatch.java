package app;

import java.util.Random;

public class PlayerMatch extends Match implements IMatch{
    private double homeScoreChance;
    private double awayScoreChance;
    double homeAttackStrength = homeTeam.getAttackStrength();
    double awayAttackStrength = awayTeam.getAttackStrength();
    double homeDefenceStrength = homeTeam.getDefenceStrength();
    double awayDefenceStrength = awayTeam.getDefenceStrength();
    double homeForm = homeTeam.getForm();
    double awayForm = awayTeam.getForm();
    double homeTactics = homeTeam.getTactics();
    double awayTactics = awayTeam.getTactics();


    public PlayerMatch(Team awayTeam, Team homeTeam){
        super(awayTeam,homeTeam);
        this.homeScoreChance =  ((homeAttackStrength + homeForm + homeTactics) / (awayDefenceStrength + awayForm ));
        this.awayScoreChance = ((awayAttackStrength + awayForm + awayTactics) / (homeDefenceStrength + homeForm ));
    }

    @Override
    public void simulate() {

        Random random = new Random();

//        homeScoreChance = ((homeAttackStrength + homeForm + homeTactics) / (awayDefenceStrength + awayForm ));
//        awayScoreChance = ((awayAttackStrength + awayForm + awayTactics) / (homeDefenceStrength + homeForm ));
        for (int minute = 1; minute <= 90; minute+=1){
            ourTeamPlay(random,awayTeam,homeTeam,minute);
        }
        System.out.println("Wyniki meczu: " + homeTeam.getName() + " " + getHomeGoals() + " - " +
                awayTeam.getName() + " " + getAwayGoals());
        setFinished(true);

        updatesAfterMatch(homeTeam,awayTeam,getHomeGoals(),getAwayGoals());
    }

    private void ourTeamPlay (Random random, Team awayTeam, Team homeTeam, int minute){
        //BYLO WCZESNIEJ gethomeScoreChance()
        if (random.nextDouble(40) < homeScoreChance) {
            System.out.println(minute + " minuta. Szansa na gola dla naszej drużyny!");
            goalPicture();
            if (czyGol(awayTeam.completeDefense(), true, true)) {
                setHomeGoals(getHomeGoals() + 1);

                System.out.println(minute + "': " + homeTeam.getName() + " zdobywa gola! " +
                        homeTeam.getName() + " " + getHomeGoals() + " - " + awayTeam.getName() + " " + getAwayGoals());
            }
        } else if (random.nextDouble(40) < awayScoreChance) {
            System.out.println(minute + " minuta. Szansa na gola dla przeciwnej drużyny!");
            if (czyGol(homeTeam.completeDefense(), true, false)) {
                setAwayGoals(getAwayGoals() + 1);
                System.out.println(minute + "': " + awayTeam.getName() + " zdobywa gola! " +
                        homeTeam.getName() + " " + getHomeGoals() + " - " + awayTeam.getName() + " " + getAwayGoals());
            }
        }
    }

    @Override
    public String getWinner() {
        if (!isFinished()){
            return null;
        }
        if (getHomeGoals() > getAwayGoals()){
            homeTeam.setWins(homeTeam.getWins()+1);
            homeTeam.setPoints(homeTeam.getPoints()+3);
            awayTeam.setLoses(awayTeam.getLoses()+1);
            homeTeam.setForm(homeTeam.getForm()+10);
            awayTeam.setForm(awayTeam.getForm()-10);
            return homeTeam.getName();
        } else if (getAwayGoals() > getHomeGoals()) {
            awayTeam.setWins(awayTeam.getWins()+1);
            awayTeam.setPoints(awayTeam.getPoints()+3);
            homeTeam.setLoses(homeTeam.getLoses()+1);
            homeTeam.setForm(homeTeam.getForm()-10);
            awayTeam.setForm(awayTeam.getForm()+10);
            return awayTeam.getName();
        }else {
            awayTeam.setDraw(awayTeam.getDraw()+1);
            homeTeam.setDraw(homeTeam.getDraw()+1);
            awayTeam.setPoints(awayTeam.getPoints()+1);
            homeTeam.setPoints(homeTeam.getPoints()+1);
            return "Remis";
        }
    }
}
