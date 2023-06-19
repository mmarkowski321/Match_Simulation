package app;


import com.diogonunes.jcolor.Attribute;
import io.GetNumber;

import java.util.HashSet;
import java.util.Random;

import static com.diogonunes.jcolor.Ansi.colorize;

public class BotsMatch extends Match implements IMatch{
    public BotsMatch(Team homeTeam, Team awayTeam){
        super(homeTeam,awayTeam);
        }

    @Override
    public void simulate() {

        for (int minute = 1; minute <= 90; minute += 1) {
            botsTeamsPlay(getRandom(),awayTeam, homeTeam);
        }
        System.out.println(colorize("Wyniki meczu: " + homeTeam.getName() + " " + getHomeGoals() + " - " +
                awayTeam.getName() + " " + getAwayGoals(), Attribute.TEXT_COLOR(28, 145, 245)));
        setFinished(true);
        updatesAfterMatch(homeTeam, awayTeam, getHomeGoals(), getAwayGoals());

    }
    private void botsTeamsPlay(Random random, Team awayTeam, Team homeTeam){
        if (random.nextDouble(40)  < getHomeScoreChance()) {
            if (ifGoal(homeTeam.completeDefense(),false,false)) {
                setHomeGoals(getHomeGoals() + 1);
            }
        }
        if (random.nextDouble(40)  < getAwayScoreChance()) {
            if (ifGoal(awayTeam.completeDefense(),false,false)) {
                setAwayGoals(getAwayGoals() + 1);
            }
        }
    }

    @Override
    public boolean ifGoal(HashSet<Integer> defencePoints, boolean ifPlayer, boolean playerIsShooting) {
        GetNumber getNumberWhereToShot = new GetNumber();
        if (ifPlayer && playerIsShooting) {

            int strzal = getNumberWhereToShot.getNumberWhereToShot();
            System.out.println(strzal);
            if (defencePoints.contains(strzal)) {
                getNumberWhereToShot.getCommand(false);
                return false;
            } else {
                getNumberWhereToShot.getCommand(true);
                return true;
            }
        }
        else if (ifPlayer){
            Random random = new Random();
            int strzal = random.nextInt(18) + 1;

            if(defencePoints.contains(strzal)) {
                getNumberWhereToShot.getCommand(false);
                return false;
            }
            else{
                getNumberWhereToShot.getCommand(true);
                return true;
            }
        }
        else{
            Random random = new Random();
            int strzal = random.nextInt(18) + 1;
            return !defencePoints.contains(strzal);
        }

    }
}
