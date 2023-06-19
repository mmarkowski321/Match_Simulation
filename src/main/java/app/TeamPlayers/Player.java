package app.TeamPlayers;

public class Player {
    private int attacking;
    private int defending;
    private String name;
    private String surname;
    public Player(String name,String surname,int attacking, int defending) {
        this.name = name;
        this.surname = surname;
        this.attacking = attacking;
        this.defending = defending;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAttacking() {
        return attacking;
    }

    public void setAttacking(int attacking) {
        this.attacking = attacking;
    }

    public int getDefending() {
        return defending;
    }

    public void setDefending(int defending) {
        this.defending = defending;
    }
    public void displayPlayers(){
        System.out.println("Gracz: " + name + " " + surname);
    }
}
