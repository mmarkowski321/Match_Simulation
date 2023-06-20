package app.TeamPlayers;

/**
 * The type Attacker.
 */
public class Attacker extends Player{
    /**
     * Instantiates a new Attacker.
     *
     * @param name      the name
     * @param surname   the surname
     * @param attacking the attacking
     * @param defending the defending
     */
    public Attacker(String name, String surname, int attacking, int defending) {
        super(name, surname, attacking+10, defending-10);
    }
    @Override
    public void displayPlayers() {
        System.out.println("Atakujacy: " + getName() + " " + getSurname());
    }
}
