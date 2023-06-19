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
    private final double homeScoreChance;
    private final double awayScoreChance;
    private final Random random = new Random();
    public Match(Team awayTeam, Team homeTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        homeScoreChance =  ((double) (homeTeam.getAttackStrength() + homeTeam.getForm() + homeTeam.getTactics()) / (awayTeam.getDefenceStrength() + awayTeam.getForm()));
        awayScoreChance = ((double) (awayTeam.getAttackStrength() + awayTeam.getForm() + awayTeam.getTactics()) / (homeTeam.getDefenceStrength() + homeTeam.getForm()));
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

    public double getHomeScoreChance() {
        return homeScoreChance;
    }
    public double getAwayScoreChance() {
        return awayScoreChance;
    }

    public Random getRandom() {
        return random;
    }

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
    public abstract void simulate();
}
