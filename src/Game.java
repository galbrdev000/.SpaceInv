import com.sun.media.jfxmedia.events.PlayerStateEvent;
import com.sun.org.glassfish.external.statistics.Stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by galbrdev000 on 3/2/2017.
 */
public class Game extends JPanel implements ActionListener{

    Timer timer;
    int positionX, positionY;
    int r = 800;
    private static boolean clicked = false;


    public static boolean isClicked() {
        return clicked;
    }

    public static void setClicked(boolean click) {
        clicked = click;
    }

    ArrayList<Entity> entities;

    public Game() {

        setPreferredSize(new Dimension(r, r));
        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                positionX = e.getX();

            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                clicked = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                positionX = e.getX();
            }
        });




        //SETS UP JFRAME
        JFrame frame = new JFrame();
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setTitle("Space_Game");
        frame.setLocationRelativeTo(null);
        setBackground(Color.black);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        collisions();
        entities.get(0).playerMove();
        for(int i = 1; i < entities.size(); i++){
            entities.get(i).move();
        }
        repaint();
    }
    public void init() {

        entities = new ArrayList<Entity>();

        entities.add(new Ship(Color.WHITE, getWidth()/2, getHeight()-3 * 40, 40, 40, this));
        entities.add(new Bullet(Color.RED, (int) (25 + (getWidth() - 100 ) * Math.random()), (int) (25 + (getHeight() - 50) * Math.random()), 5, 20, this));
        for(int i = 0; i < 20; i++) {
            entities.add(new Alien(Color.GREEN, getWidth() / 2 + 60 * i , getHeight() / 2 - 350, 40, this));
            entities.add(new Alien(Color.GREEN, getWidth() / 2 + 60 * i , getHeight() / 2 - 300, 40, this));
            entities.add(new Alien(Color.GREEN, getWidth() / 2 + 60 * i , getHeight() / 2 - 250, 40, this));
            entities.add(new Alien(Color.GREEN, getWidth() / 2 + 60 * i , getHeight() / 2 - 200, 40, this));
            entities.add(new Alien(Color.GREEN, getWidth() / 2 + 60 * i , getHeight() / 2 - 150, 40, this));
            entities.add(new Alien(Color.GREEN, getWidth() / 2 + 60 * i , getHeight() / 2 - 150, 40, this));
        }
}


    private void run() {
        timer = new Timer(1000/60, this);

        timer.start();
    }

    public void collisions(){


    }
    public void paint(Graphics g){
        super.paint(g);
        for( Entity obj : entities){
            obj.paint(g);
        }
            }



    public static void main(String[] args){
        Game game = new Game();
        game.init();
        game.run();
    }

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){

        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s,g2d).getWidth();
        int start = width/2 - stringLen/2;
        g2d.drawString(s, start + XPos, YPos);
    }
}
