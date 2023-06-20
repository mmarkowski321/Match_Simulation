package app;
import app.TeamPlayers.Player;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

/**
 * The type Team.
 */
public class Team {
    private final String name;
    private int attackStrength;
    private final int defenceStrength;
    private int form;
    private final int tactics;
    /**
     * The Gk accurity.
     */
    public int gkAccurity;
    private int wins;
    private int loses;
    private int goalsScored;
    private int goalsLosed;
    private int draw;
    private int points;
    private int games;
    private Player[] players = new Player[4];

    /**
     * Instantiates a new Team.
     *
     * @param name       the name
     * @param form       the form
     * @param tactics    the tactics
     * @param gkAccurity the gk accurity
     * @param players    the players
     */
    public Team(String name, int form, int tactics,int gkAccurity, Player[] players) {
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

    /**
     * Display team players.
     */
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

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets attack strength.
     *
     * @return the attack strength
     */
    public int getAttackStrength() {
        return attackStrength;
    }

    /**
     * Gets defence strength.
     *
     * @return the defence strength
     */
    public int getDefenceStrength() {
        return defenceStrength;
    }

    /**
     * Gets form.
     *
     * @return the form
     */
    public int getForm() {
        return form;
    }

    /**
     * Gets tactics.
     *
     * @return the tactics
     */
    public int getTactics() {
        return tactics;
    }

    /**
     * Gets games.
     *
     * @return the games
     */
    public int getGames() {
        return games;
    }

    /**
     * Complete defense hash set.
     *
     * @return the hash set
     */
    public HashSet<Integer> completeDefense(){
        HashSet<Integer> defensePoints=new HashSet<>();
        Random generator = new Random();
        int i = 0;
        while (defensePoints.size() < gkAccurity) {
            defensePoints.add(generator.nextInt(18) + 1);
        }
        return defensePoints;
    }

    /**
     * Gets wins.
     *
     * @return the wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Sets wins.
     *
     * @param wins the wins
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Gets loses.
     *
     * @return the loses
     */
    public int getLoses() {
        return loses;
    }

    /**
     * Sets loses.
     *
     * @param loses the loses
     */
    public void setLoses(int loses) {
        this.loses = loses;
    }

    /**
     * Gets goals scored.
     *
     * @return the goals scored
     */
    public int getGoalsScored() {
        return goalsScored;
    }

    /**
     * Sets goals scored.
     *
     * @param goalsScored the goals scored
     */
    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    /**
     * Gets goals losed.
     *
     * @return the goals losed
     */
    public int getGoalsLosed() {
        return goalsLosed;
    }

    /**
     * Sets goals losed.
     *
     * @param goalsLosed the goals losed
     */
    public void setGoalsLosed(int goalsLosed) {
        this.goalsLosed = goalsLosed;
    }

    /**
     * Sets attack strength.
     *
     * @param attackStrength the attack strength
     */
    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    /**
     * Gets draw.
     *
     * @return the draw
     */
    public int getDraw() {
        return draw;
    }

    /**
     * Sets draw.
     *
     * @param draw the draw
     */
    public void setDraw(int draw) {
        this.draw = draw;
    }

    /**
     * Gets points.
     *
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets points.
     *
     * @param points the points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Sets form.
     *
     * @param form the form
     */
    public void setForm(int form) {
        this.form = form;
    }

    /**
     * Sets games.
     *
     * @param games the games
     */
    public void setGames(int games) {
        this.games = games;
    }

    /**
     * Get players player [ ].
     *
     * @return the player [ ]
     */
    public Player[] getPlayers() {
        return players;
    }

}