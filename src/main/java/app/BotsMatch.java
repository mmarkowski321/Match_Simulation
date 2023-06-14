package app;


import java.util.Random;

public class BotsMatch extends Match implements IMatch{
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



    public BotsMatch(Team homeTeam, Team awayTeam){
        super(homeTeam,awayTeam);
        this.homeScoreChance =  ((homeAttackStrength + homeForm + homeTactics) / (awayDefenceStrength + awayForm ));
        this.awayScoreChance = ((awayAttackStrength + awayForm + awayTactics) / (homeDefenceStrength + homeForm ));
        }

    @Override
    public void simulate() {
        Random random = new Random();
        for (int minute = 1; minute <= 90; minute += 1) {
            botTeamsPlay(random,awayTeam, homeTeam);
        }
        System.out.println("Wyniki meczu: " + homeTeam.getName() + " " + getHomeGoals() + " - " +
                awayTeam.getName() + " " + getAwayGoals());
        setFinished(true);
        updatesAfterMatch(homeTeam, awayTeam, getHomeGoals(), getAwayGoals());

    }
    private void botTeamsPlay(Random random, Team awayTeam, Team homeTeam){
        if (random.nextDouble(40)  < homeScoreChance) {
            if (czyGol(homeTeam.completeDefense(),false,false)) {
                setHomeGoals(getHomeGoals() + 1);
            }
        }
        if (random.nextDouble(40)  < awayScoreChance) {
            if (czyGol(awayTeam.completeDefense(),false,false)) {
                setAwayGoals(getAwayGoals() + 1);
            }
        }
    }


}
