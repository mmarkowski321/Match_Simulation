package io;


import app.Team;
import app.TeamPlayers.Attacker;
import app.TeamPlayers.Defender;
import app.TeamPlayers.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class GetTeams {
    public Team makeTeam() {
        GetNumber getNumber = new GetNumber();
        Player[] players = new Player[4];
        System.out.println("Stwórz własną drużyne!");
        String name = getNumber.getNameOfMyTeam();
        System.out.println("Dobra nazwa");
        for (int i = 1;i < 5; i++){
            String poz = " gracza";
            System.out.println("Podaj imie "+ i + poz);
            String name1 = getNumber.getString();
            System.out.println("Podaj nazwisko "+ i + poz);
            String lastName = getNumber.getString();
            System.out.println("Podaj sile ataku (0-100) "+ i + poz);
            int attacking = getNumber.getNumberOfSkill();
            System.out.println("Podaj sile obrony (0-100) "+ i + poz);
            int defending = getNumber.getNumberOfSkill();
            if (i < 3){
                Attacker player = new Attacker(name1,lastName,attacking,defending);
                players[i-1] = player;
            }
            else{
                Defender player = new Defender(name1,lastName,attacking,defending);
                players[i-1] = player;
            }
        }
        System.out.println("Forma drużyny (0-100): ");
        int form = getNumber.getNumberOfSkill();
        System.out.println("Umiejętności taktyczne druzyny (0-100): " );
        int tactics = getNumber.getNumberOfSkill();
        System.out.println("Umiejętności bramkarza (0-18): ");
        int gkAccurity = getNumber.getGoalkeeperSkill();

        Team myTeam = new Team(name,form,tactics,gkAccurity,players);
        return myTeam;
    }


    public Team[] dataBaseTeams(Team myTeam) {


        Team[] dataTeams = new Team[6];
        BufferedReader bufferedReader = null;
        int i = 0;
        PlayerDataReader playerDataReader = new PlayerDataReader();
        Player[] players = playerDataReader.readPlayersFromFile();
        int indexInPlayerTable = 0;
        try {
            File file = new File("src/DataTeams");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                Player[] currentPlayers = new Player[4];
                String teamName = values[0].trim();
                int value1 = Integer.parseInt(values[1].trim());
                int value2 = Integer.parseInt(values[2].trim());
                int value3 = Integer.parseInt(values[3].trim());
                for (int indexInCurrentPl = 0; indexInCurrentPl < 4; indexInCurrentPl ++) {
                    currentPlayers[indexInCurrentPl] = players[indexInPlayerTable];
                    indexInPlayerTable++;
                }
                Team team = new Team(teamName,value1,value2,value3,currentPlayers);
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
        PlayerDataReader playerDataReader = new PlayerDataReader();
        Player[] players = playerDataReader.readPlayersFromFile();
        int indexInPlayerTable = 0;
        int i = 0;
        try {
            File file = new File("src/DataTeams");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                Player[] currentPlayers = new Player[4];
                String teamName = values[0].trim();
                int value1 = Integer.parseInt(values[1].trim());
                int value2 = Integer.parseInt(values[2].trim());
                int value3 = Integer.parseInt(values[3].trim());

                for (int indexInCurrentPl = 0; indexInCurrentPl < 4; indexInCurrentPl++) {
                    currentPlayers[indexInCurrentPl] = players[indexInPlayerTable];
                    indexInPlayerTable++;
                }
                    Team team = new Team(teamName, value1, value2, value3, currentPlayers);
                    dataTeams[i] = team;
                    i++;
                }
            } catch(IOException e){
                e.printStackTrace();
            } finally{
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

