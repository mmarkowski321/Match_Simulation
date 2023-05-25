import java.util.Scanner;

public class GetNumber {
    Scanner scan;

    public GetNumber() {
        this.scan = new Scanner(System.in);
    }

    public int[] getNumberOfChosenTeams() {
        System.out.printf("1-Real Madryt\n2-FC Barcelona\n3-Chelsea\n4-Manchester_City\n5-Bayern Monachium\n");
        System.out.println("Wybierz swoja druzyne: ");
        int choice1 = this.scan.nextInt();
        System.out.println("Wybierz druzyne rywala: ");
        int choice2 = this.scan.nextInt();
        int[] numbers = new int[2];
        if ((choice1 > 5 || choice1 < 1) || (choice2 > 5 || choice2 < 1)){
            System.out.println("Liczba poza zakresem");
            return getNumberOfChosenTeams();
        }else{
            if (choice2 == choice1) {
                System.out.println("Wybrales dwa takie same numery, wybierz dwa rozne");
                return this.getNumberOfChosenTeams();
            } else {
                numbers[0] = choice1;
                numbers[1] = choice2;
                return numbers;
            }
        }
    }

    public int getMenuNumber() {
        System.out.printf("Wybierz tryb gry: \n-rozegraj pelna lige(wybierz 1)\n-zagraj mecz wybranymi zespolami(wybierz 2)\n-zagraj mecz losowymi zespolami(wybierz 3)\n-zakoncz program(wybierz 4)\n");
        int shot = this.scan.nextInt();
        if (shot <= 4 && shot >= 1) {
            return shot;
        } else {
            System.out.println("Liczba poza zakresem, sproboj wpisac inna");
            return this.getMenuNumber();
        }
    }

    public int getEndNumber() {
        System.out.printf("Czy chcesz zagrac jeszcze w inny tryb?");
        int shot = this.scan.nextInt();
        if (shot <= 1 && shot >= 0) {
            return shot;
        } else {
            System.out.println("Liczba poza zakresem, sproboj wpisac inna");
            return this.getNumberWhereToShot();
        }
    }

    public int getNumberWhereToShot() {
        System.out.println("Wyceluj w bramke podajac odpowiednia liczbe: ");
        int shot = this.scan.nextInt();
        if (shot <= 18 && shot >= 1) {
            return shot;
        } else {
            System.out.println("Liczba poza zakresem, sproboj wpisac inna");
            return this.getNumberWhereToShot();
        }
    }

    public int getNumberOfSkill() {
        System.out.println("Wpisz wartosc 0 - 100");
        int skill = this.scan.nextInt();
        if (skill <= 100 && skill >= 0) {
            return skill;
        } else {
            System.out.println("Liczba poza zakresem, sproboj wpisac inna");
            return this.getNumberOfSkill();
        }
    }

    public String getNameOfMyTeam() {
        System.out.println("Wpisz nazwe twojej druzyny");
        String nameOfMyTeam = this.scan.nextLine();
        return nameOfMyTeam;
    }

    public int getGoalkeeperSkill() {
        System.out.println("Wpisz wartosc skillu bramkarza 0 - 18");
        int skill = this.scan.nextInt();
        if (skill <= 18 && skill >= 0) {
            return skill;
        } else {
            System.out.println("Liczba poza zakresem, sproboj wpisac inna");
            return this.getGoalkeeperSkill();
        }
    }
}
