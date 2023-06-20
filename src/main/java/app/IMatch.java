package app;
import static com.diogonunes.jcolor.Ansi.colorize;

import com.diogonunes.jcolor.Attribute;
import io.GetNumber;

import java.util.HashSet;
import java.util.Random;

/**
 * The interface Match.
 */
public interface IMatch {
    /**
     * If goal boolean.
     *
     * @param defencePoints    the defence points
     * @param ifPlayer         the if player
     * @param playerIsShooting the player is shooting
     * @return the boolean
     */
    boolean ifGoal(HashSet<Integer> defencePoints, boolean ifPlayer, boolean playerIsShooting);

    /**
     * Goal picture.
     */
    default void goalPicture() {
        System.out.println(colorize("=====================", Attribute.TEXT_COLOR(90, 225, 22)));
        System.out.println(colorize("||", Attribute.TEXT_COLOR(90, 225, 22)) + colorize(" 1  2  3  4  5  6", Attribute.TEXT_COLOR(218, 45, 45)) + colorize("||", Attribute.TEXT_COLOR(90, 225, 22)));
        System.out.println(colorize("||", Attribute.TEXT_COLOR(90, 225, 22)) + colorize(" 7  8  9 10 11 12", Attribute.TEXT_COLOR(218, 45, 45)) + colorize("||", Attribute.TEXT_COLOR(90, 225, 22)));
        System.out.println(colorize("||", Attribute.TEXT_COLOR(90, 225, 22)) + colorize("13 14 15 16 17 18", Attribute.TEXT_COLOR(218, 45, 45)) + colorize("||", Attribute.TEXT_COLOR(90, 225, 22)));
    }

}
