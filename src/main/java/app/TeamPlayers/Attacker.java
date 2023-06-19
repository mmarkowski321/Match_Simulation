package app.TeamPlayers;

public class Attacker extends Player{
    public Attacker(String name, String surname, int attacking, int defending) {
        super(name, surname, attacking+10, defending-10);
    }
    @Override
    public void displayPlayers() {
        System.out.println("Atakujacy: " + getName() + " " + getSurname());
    }
}
