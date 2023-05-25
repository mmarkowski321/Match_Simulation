import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class GetTeams {
    public Team makeTeam() {
        GetNumber getNumber = new GetNumber();
        System.out.println("Stwórz własną drużyne!");
        String name = getNumber.getNameOfMyTeam();
        System.out.println("Dobra nazwa");
        System.out.println("Atak siła: ");
        int attackStrength = getNumber.getNumberOfSkill();
        System.out.println("Defensywna siła: ");
        int defensePoints = getNumber.getNumberOfSkill();
        System.out.println("Forma drużyny: ");
        int form = getNumber.getNumberOfSkill();
        System.out.println("Umiejętności taktyczne: " );
        int tactics = getNumber.getNumberOfSkill();
        System.out.println("Umiejętności bramkarza: ");
        int gkAccurity = getNumber.getGoalkeeperSkill();
        Team myTeam = new Team(name,attackStrength,defensePoints,form,tactics,gkAccurity,true);
        return myTeam;
    }


    public Team[] dataBaseTeams(Team myTeam) {


        Team[] dataTeams = new Team[6];
        BufferedReader bufferedReader = null;
        int i = 0;
        try {
            File file = new File("src/DataTeams");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");

                String teamName = values[0].trim();
                int value1 = Integer.parseInt(values[1].trim());
                int value2 = Integer.parseInt(values[2].trim());
                int value3 = Integer.parseInt(values[3].trim());
                int value4 = Integer.parseInt(values[4].trim());
                int value5 = Integer.parseInt(values[5].trim());
                boolean value6 = Boolean.parseBoolean(values[6].trim());
                Team team = new Team(teamName,value1,value2,value3,value4,value5,value6);
                dataTeams[i] = team;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        dataTeams[5] = myTeam;
        return dataTeams;
    }
    public Team[] dataBaseTeams() {


        Team[] dataTeams = new Team[5];
        BufferedReader bufferedReader = null;
        int i = 0;
        try {
            File file = new File("src/DataTeams");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");

                String teamName = values[0].trim();
                int value1 = Integer.parseInt(values[1].trim());
                int value2 = Integer.parseInt(values[2].trim());
                int value3 = Integer.parseInt(values[3].trim());
                int value4 = Integer.parseInt(values[4].trim());
                int value5 = Integer.parseInt(values[5].trim());
                boolean value6 = Boolean.parseBoolean(values[6].trim());
                Team team = new Team(teamName,value1,value2,value3,value4,value5,value6);
                dataTeams[i] = team;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataTeams;
    }



}
