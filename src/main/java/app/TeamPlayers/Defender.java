package app.TeamPlayers;

/**
 * The type Defender.
 */
public class Defender extends Player{
    /**
     * Instantiates a new Defender.
     *
     * @param name      the name
     * @param surname   the surname
     * @param attacking the attacking
     * @param defending the defending
     */
    public Defender(String name, String surname, int attacking, int defending) {
        super(name, surname, attacking-10, defending+10);
    }
    @Override
    public void displayPlayers() {
        System.out.println("Obronca " + getName() + " " + getSurname());
    }
}
