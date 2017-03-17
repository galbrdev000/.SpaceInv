import java.awt.*;

/**
 * Created by galbrdev000 on 3/2/2017.
 */
public class Ship extends Entity{

    public Ship(Color color, int x, int y, int width, int height, Game game){
        super(color, x, y, width, height, game);

    }

    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(),getY(),getWidth(),getHeight());

    }
}
