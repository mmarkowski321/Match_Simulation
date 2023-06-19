package io;

import com.diogonunes.jcolor.Attribute;

import java.util.Random;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;

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
    public void getCommand(boolean ifGoal) {
        String[] goalCommand = {
                "I to jest to, czego od niego oczekiwaliśmy! Fantastyczne wykonanie akcji i piękne trafienie. To będzie zapamiętane jako jedno z najlepszych goli sezonu!",
                "Wow, to było absolutnie nie do obrony! Kompletnie zaskoczył bramkarza i wpakował piłkę do siatki. Doskonała technika i precyzja.",
                "Co za moment! Zawodnik pokazał klasę, zachowując spokój i pewność siebie. To jest piłka nożna w najwyższej jakości.",
                "Piękne wykonanie akcji i perfekcyjny strzał! Chyba trudno o lepszy sposób na otwarcie wyniku w tym meczu. To naprawdę ważna bramka dla drużyny.",
                "Niesamowite! Bramkarz był bez szans! Zawodnik pokazał nie tylko technikę, ale także inteligencję taktyczną. To był prawdziwy gol dla kolekcji.",
                "Doskonale umieścił piłkę w siatce! Zawodnik pokazał, dlaczego jest jednym z najlepszych strzelców w lidze.",
                "To było jak z kosmosu! Piłka leciała jak pocisk i lądowała dokładnie w bramce. To jest mistrzowski strzał!",
                "Nie ma lepszego sposobu na zdobycie bramki! Precyzja, siła i determinacja - wszystko to było obecne w tym uderzeniu.",
                "Bramkarz był bezradny! To jest strzał, o którym będziemy mówić przez długi czas. Wspaniałe wykonanie!",
                "Co za wyczyn! To nie jest łatwe, ale on sprawił, że wyglądało jak dziecinnie proste. To jest klasa światowa!",
                "Bramkarz był w szoku! Strzał zaskoczył go całkowicie. Tego nie da się obronić!"
        };

        String[] noGoalCommand = {
                "Niestety, nie udało mu się. To był moment, w którym musiał być precyzyjny, ale piłka minęła bramkę o centymetry.",
                "Zawodnik z pewnością będzie miał koszmary po tej sytuacji. Strzał był dobrze wymierzony, ale niestety nie trafił do siatki.",
                "Trochę pecha w tym uderzeniu. Napastnik miał wszystko dobrze poukładane, ale bramkarz zdołał skutecznie sparować piłkę.",
                "Za chwilę wyrósłby bohater, ale niestety piłka przeleciała tuż obok słupka. Trudno uwierzyć w to niepowodzenie.",
                "Mogło być tak pięknie, ale to nietrafienie z pewnością zostanie zapamiętane. Cóż, czasami futbol jest nieprzewidywalny.",
                "Napastnik był bardzo blisko! Bramkarz zdołał jednak wybronić strzał. To był moment, który mógł zmienić losy meczu.",
                "Zdecydowanie brakowało precyzji w tym strzale. To musi być dla zawodnika duże rozczarowanie.",
                "Piłka poszybowała nad poprzeczką. Nie udało się w tej sytuacji, ale napastnik nie powinien się poddawać.",
                "Nietrafienie jest trudne do przyjęcia, zwłaszcza w takiej sytuacji. Zawodnik na pewno będzie chciał odkupić ten błąd.",
                "Napastnik był niebezpieczny, ale niestety piłka przeszła obok słupka. To musi być bolesne dla drużyny."
        };

        Random random = new Random();

        if (ifGoal) {
            int index = random.nextInt(goalCommand.length);
            System.out.println(colorize(goalCommand[index], Attribute.TEXT_COLOR(90, 225, 22)) + "\n");
        } else {
            int index = random.nextInt(noGoalCommand.length);
            System.out.println(colorize(noGoalCommand[index],Attribute.TEXT_COLOR(218, 45, 45)) + "\n");
        }
    }

}
