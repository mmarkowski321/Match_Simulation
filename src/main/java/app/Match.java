package app;


import io.GetNumber;

import java.util.HashSet;
import java.util.Random;

/**
 * The type Match.
 */
abstract class Match {
    /**
     * The Home team.
     */
    final Team homeTeam;
    /**
     * The Away team.
     */
    final Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private boolean isFinished;
    private final double homeScoreChance;
    private final double awayScoreChance;
    private final Random random = new Random();

    /**
     * Instantiates a new Match.
     *
     * @param awayTeam the away team
     * @param homeTeam the home team
     */
    public Match(Team awayTeam, Team homeTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        homeScoreChance =  ((double) (homeTeam.getAttackStrength() + homeTeam.getForm() + homeTeam.getTactics()) / (awayTeam.getDefenceStrength() + awayTeam.getForm()));
        awayScoreChance = ((double) (awayTeam.getAttackStrength() + awayTeam.getForm() + awayTeam.getTactics()) / (homeTeam.getDefenceStrength() + homeTeam.getForm()));
    }

    /**
     * Is finished boolean.
     *
     * @return the boolean
     */
    public boolean isFinished() {
        return isFinished;
    }

    /**
     * Gets home goals.
     *
     * @return the home goals
     */
    public int getHomeGoals() {
        return homeGoals;
    }

    /**
     * Sets home goals.
     *
     * @param homeGoals the home goals
     */
    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    /**
     * Gets away goals.
     *
     * @return the away goals
     */
    public int getAwayGoals() {
        return awayGoals;
    }

    /**
     * Sets away goals.
     *
     * @param awayGoals the away goals
     */
    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    /**
     * Sets finished.
     *
     * @param finished the finished
     */
    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    /**
     * Gets home score chance.
     *
     * @return the home score chance
     */
    public double getHomeScoreChance() {
        return homeScoreChance;
    }

    /**
     * Gets away score chance.
     *
     * @return the away score chance
     */
    public double getAwayScoreChance() {
        return awayScoreChance;
    }

    /**
     * Gets random.
     *
     * @return the random
     */
    public Random getRandom() {
        return random;
    }

    /**
     * Updates after match.
     *
     * @param homeTeam  the home team
     * @param awayTeam  the away team
     * @param homeGoals the home goals
     * @param awayGoals the away goals
     */
    protected static void updatesAfterMatch(Team homeTeam, Team awayTeam, int homeGoals, int awayGoals){
        //Aktualizowanie statystyk trafionych i straconych bramek dla pierwszej drużyny
        homeTeam.setGoalsScored(homeTeam.getGoalsScored() + homeGoals);
        homeTeam.setGoalsLosed(homeTeam.getGoalsLosed() + awayGoals);
        //Aktualizowanie statystyk trafionych i straconych bramek dla drugiej drużyny
        awayTeam.setGoalsScored(awayTeam.getGoalsScored() + awayGoals);
        awayTeam.setGoalsLosed(awayTeam.getGoalsLosed() + homeGoals);
        homeTeam.setGames(homeTeam.getGames() + 1);
        awayTeam.setGames(awayTeam.getGames() + 1);
    }

    /**
     * Gets winner.
     *
     * @return the winner
     */
    protected String getWinner() {
        if (!isFinished()){
            return null;
        }
        if (getHomeGoals() > getAwayGoals()){
            return homeTeam.getName();
        } else if (getAwayGoals() > getHomeGoals()) {
            return awayTeam.getName();
        }else {
            return "Remis";
        }
    }

    /**
     * Update statistics.
     */
    protected void updateStatistics(){
        if (getHomeGoals() > getAwayGoals()){
            homeTeam.setWins(homeTeam.getWins()+1);
            homeTeam.setPoints(homeTeam.getPoints()+3);
            awayTeam.setLoses(awayTeam.getLoses()+1);
            if (homeTeam.getForm() < 90) homeTeam.setForm(homeTeam.getForm()+10);
            if (awayTeam.getForm() > 10 ) awayTeam.setForm(awayTeam.getForm()-10);
        } else if (getAwayGoals() > getHomeGoals()) {
            awayTeam.setWins(awayTeam.getWins()+1);
            awayTeam.setPoints(awayTeam.getPoints()+3);
            homeTeam.setLoses(homeTeam.getLoses()+1);
            if (awayTeam.getForm() < 90) awayTeam.setForm(awayTeam.getForm()+10);
            if (homeTeam.getForm() > 10 ) homeTeam.setForm(homeTeam.getForm()-10);
        }else {
            awayTeam.setDraw(awayTeam.getDraw()+1);
            homeTeam.setDraw(homeTeam.getDraw()+1);
            awayTeam.setPoints(awayTeam.getPoints()+1);
            homeTeam.setPoints(homeTeam.getPoints()+1);
        }
    }

    /**
     * Simulate.
     */
    public abstract void simulate();
}
