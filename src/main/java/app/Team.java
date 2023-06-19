package app;
import app.TeamPlayers.Player;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

public class Team {
    private final String name;
    private int attackStrength;
    private final int defenceStrength;
    private int form;
    private final int tactics;
    public int gkAccurity;
    private int wins;
    private int loses;
    private int goalsScored;
    private int goalsLosed;
    private int draw;
    private int points;
    private int games;
    private Player[] players = new Player[4];

    public Team(String name, int attackStrength, int defenceStrength, int form, int tactics,int gkAccurity) {
        this.name = name;
        this.attackStrength = getAttackStrength(players);
        this.defenceStrength = getDefenseStrength(players);
        this.form = form;
        this.tactics = tactics;
        this.gkAccurity=gkAccurity;
        this.wins = 0;
        this.loses = 0;
        this.goalsScored = 0;
        this.goalsLosed = 0;
        this.draw = 0;
        this.points = 0;
        this.games=0;
        this.players = players;
    }
    public void displayTeamPlayers(){
        System.out.println("\nSklad naszej druzyny: ");
        for (Player player : players) {
            player.displayPlayers();
        }
        System.out.println();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team team)) return false;
        return attackStrength == team.attackStrength && defenceStrength == team.defenceStrength && form == team.form && tactics == team.tactics && gkAccurity == team.gkAccurity && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attackStrength, defenceStrength, form, tactics, gkAccurity);
    }
    private int getAttackStrength(Player[] players) {
        int attack = 0;
        for (Player player : players) {
            attack += player.getAttacking();
        }
        attack = attack/4;
        return attack;
    }
    private int getDefenseStrength(Player[] players){
        int defense =0;
        for (Player player : players) {
            defense += player.getDefending();
        }
        defense = defense/4;
        return defense;
    }

    public String getName() {
        return name;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public int getDefenceStrength() {
        return defenceStrength;
    }

    public int getForm() {
        return form;
    }

    public int getTactics() {
        return tactics;
    }

    public int getGames() {
        return games;
    }

    public HashSet<Integer> completeDefense(){
        HashSet<Integer> defensePoints=new HashSet<>();
        Random generator = new Random();
        int i = 0;
        while (defensePoints.size() < gkAccurity) {
            defensePoints.add(generator.nextInt(18) + 1);
        }
        return defensePoints;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsLosed() {
        return goalsLosed;
    }

    public void setGoalsLosed(int goalsLosed) {
        this.goalsLosed = goalsLosed;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
}