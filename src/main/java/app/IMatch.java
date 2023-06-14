package app;

import io.GetNumber;

import java.util.HashSet;
import java.util.Random;

public interface IMatch {
    void simulate();

    default  boolean ifGoal(HashSet<Integer> defencePoints, boolean ifPlayer, boolean playerIsShooting){
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
    default void goalPicture(){
        System.out.println("=====================");
        System.out.println("|| 1  2  3  4  5  6||");
        System.out.println("|| 7  8  9 10 11 12||");
        System.out.println("||13 14 15 16 17 18||");

    }


}
