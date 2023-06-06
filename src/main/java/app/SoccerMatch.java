package app;


public class SoccerMatch {
    final Team homeTeam;
    final Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private boolean isFinished;

    private double homeScoreChance;
    private double awayScoreChance;

    public SoccerMatch(Team awayTeam, Team homeTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void simulate(boolean ifPlayer) {
        double homeAttackStrength = homeTeam.getAttackStrength();
        double awayAttackStrength = awayTeam.getAttackStrength();
        double homeDefenceStrength = homeTeam.getDefenceStrength();
        double awayDefenceStrength = awayTeam.getDefenceStrength();
        double homeForm = homeTeam.getForm();
        double awayForm = awayTeam.getForm();
        double homeTactics = homeTeam.getTactics();
        double awayTactics = awayTeam.getTactics();


        if(ifPlayer) System.out.println("Zaczyna sie mecz: " + homeTeam.getName() + " vs " + awayTeam.getName());
        homeScoreChance = ((homeAttackStrength + homeForm + homeTactics) / (awayDefenceStrength + awayForm ));
        awayScoreChance = ((awayAttackStrength + awayForm + awayTactics) / (homeDefenceStrength + homeForm ));
        if (ifPlayer) {
            System.out.printf("Szanse na sytuacje podbramkowe dla %s %.2f%% w kazdej minucie\n",homeTeam.getName(),homeScoreChance*100/40);
            System.out.printf("Szanse na sytuacje podbramkowe dla %s %.2f%% w kazdej minucie\n",awayTeam.getName(),awayScoreChance*100/40);
        }
    }

    public String getWinner() {
        if (!isFinished) {
            return null;
        }

        if (homeGoals > awayGoals) {
            homeTeam.setWins(homeTeam.getWins()+1);
            homeTeam.setPoints(homeTeam.getPoints()+3);
            awayTeam.setLoses(awayTeam.getLoses()+1);
            homeTeam.setForm(homeTeam.getForm()+10);
            awayTeam.setForm(awayTeam.getForm()-10);
            return homeTeam.getName();
        } else if (awayGoals > homeGoals) {
            awayTeam.setWins(awayTeam.getWins()+1);
            awayTeam.setPoints(awayTeam.getPoints()+3);
            homeTeam.setLoses(homeTeam.getLoses()+1);
            homeTeam.setForm(homeTeam.getForm()-10);
            awayTeam.setForm(awayTeam.getForm()+10);
            return awayTeam.getName();
        } else {
            awayTeam.setDraw(awayTeam.getDraw()+1);
            homeTeam.setDraw(homeTeam.getDraw()+1);
            awayTeam.setPoints(awayTeam.getPoints()+1);
            homeTeam.setPoints(homeTeam.getPoints()+1);
            return "Remis";
        }
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

    public double getHomeScoreChance() {
        return homeScoreChance;
    }
    public double getAwayScoreChance() {
        return awayScoreChance;
    }
    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}