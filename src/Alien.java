import java.awt.*;

/**
 * Created by galbrdev000 on 3/2/2017.
 */
public class Alien extends Entity {

private double dx, dy;

public Alien(Color color, int x, int y, int diameter, Game game){
        super(color, x, y, diameter, diameter, game);
    }

    public void paint (Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }



}
