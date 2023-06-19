package io;

import app.TeamPlayers.Attacker;
import app.TeamPlayers.Defender;
import app.TeamPlayers.Player;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class PlayerDataReader {
    public Player[] readPlayersFromFile() {
        Player[] players = new Player[20];
        try (BufferedReader reader = new BufferedReader(new FileReader("src/DataPlayers"))) {
            String line;
            int positionInTable = 0;

            while ((line = reader.readLine()) != null && positionInTable < players.length) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String firstName = data[0].trim();
                    String lastName = data[1].trim();
                    int score1 = Integer.parseInt(data[2].trim());
                    int score2 = Integer.parseInt(data[3].trim());
                    String position = data[4].trim();
                    if (position.equalsIgnoreCase("A")) {
                        players[positionInTable] = new Attacker(firstName, lastName, score1, score2);
                    } else if (position.equalsIgnoreCase("D")) {
                        players[positionInTable] = new Defender(firstName, lastName, score1, score2);
                    } else {
                        continue;
                    }
                    positionInTable++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return players;
    }
}
