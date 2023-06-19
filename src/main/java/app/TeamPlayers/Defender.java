package app.TeamPlayers;

public class Defender extends Player{
    public Defender(String name, String surname, int attacking, int defending) {
        super(name, surname, attacking-10, defending+10);
    }
    @Override
    public void displayPlayers() {
        System.out.println("Obronca " + getName() + " " + getSurname());
    }
}
