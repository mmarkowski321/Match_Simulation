package app;

import app.TeamPlayers.Player;
import com.diogonunes.jcolor.Attribute;
import io.GetNumber;

import java.util.HashSet;
import java.util.Random;

import static com.diogonunes.jcolor.Ansi.colorize;

/**
 * The type Player match.
 */
public class PlayerMatch extends Match implements IMatch{
    /**
     * Instantiates a new Player match.
     *
     * @param awayTeam the away team
     * @param homeTeam the home team
     */
    public PlayerMatch(Team awayTeam, Team homeTeam){
        super(awayTeam,homeTeam);
    }
    @Override
    public void simulate() {
        System.out.println("Zaczyna sie mecz: " + homeTeam.getName() + " vs " + awayTeam.getName());

        homeTeam.displayTeamPlayers();
        for (int minute = 1; minute <= 90; minute+=1){
            ourTeamPlay(getRandom(),awayTeam,homeTeam,minute);
        }
        System.out.println(colorize("Wyniki meczu: " + homeTeam.getName() + " " + getHomeGoals() + " - " +
                awayTeam.getName() + " " + getAwayGoals(), Attribute.TEXT_COLOR(28, 145, 245)));
        setFinished(true);

        updatesAfterMatch(homeTeam,awayTeam,getHomeGoals(),getAwayGoals());
    }

    private void ourTeamPlay (Random random, Team awayTeam, Team homeTeam, int minute){
        if (random.nextDouble(40) < getHomeScoreChance()) {
            System.out.println(minute + " minuta. Szansa na gola dla naszej drużyny!");
            goalPicture();
            if (ifGoal(awayTeam.completeDefense(), true, true)) {
                setHomeGoals(getHomeGoals() + 1);

                System.out.println(minute + "': " + homeTeam.getName() + " zdobywa gola! " +
                        homeTeam.getName() + " " + getHomeGoals() + " - " + awayTeam.getName() + " " + getAwayGoals());
            }
        } else if (random.nextDouble(40) < getAwayScoreChance()) {
            System.out.println(minute + " minuta. Szansa na gola dla przeciwnej drużyny!");
            if (ifGoal(homeTeam.completeDefense(), true, false)) {
                setAwayGoals(getAwayGoals() + 1);
                System.out.println(minute + "': " + awayTeam.getName() + " zdobywa gola! " +
                        homeTeam.getName() + " " + getHomeGoals() + " - " + awayTeam.getName() + " " + getAwayGoals());
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
