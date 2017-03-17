/**
 * Created by galbrdev000 on 3/16/2017.
 */
public class Stats {
    private static boolean clicked = false;

    public static boolean isClicked() {
        return clicked;
    }

    public static void setClicked(boolean clicked) {
        Stats.clicked = clicked;
    }
}
