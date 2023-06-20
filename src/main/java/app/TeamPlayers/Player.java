package app.TeamPlayers;

/**
 * The type Player.
 */
public class Player {
    private int attacking;
    private int defending;
    private String name;
    private String surname;

    /**
     * Instantiates a new Player.
     *
     * @param name      the name
     * @param surname   the surname
     * @param attacking the attacking
     * @param defending the defending
     */
    public Player(String name,String surname,int attacking, int defending) {
        this.name = name;
        this.surname = surname;
        this.attacking = attacking;
        this.defending = defending;
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
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets attacking.
     *
     * @return the attacking
     */
    public int getAttacking() {
        return attacking;
    }

    /**
     * Sets attacking.
     *
     * @param attacking the attacking
     */
    public void setAttacking(int attacking) {
        this.attacking = attacking;
    }

    /**
     * Gets defending.
     *
     * @return the defending
     */
    public int getDefending() {
        return defending;
    }

    /**
     * Sets defending.
     *
     * @param defending the defending
     */
    public void setDefending(int defending) {
        this.defending = defending;
    }

    /**
     * Display players.
     */
    public void displayPlayers(){
        System.out.println("Gracz: " + name + " " + surname);
    }
}
