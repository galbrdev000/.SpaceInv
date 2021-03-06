import java.awt.*;

/**
 * Created by galbrdev000 on 3/2/2017.
 */
public abstract class Entity {

    private Game game;
    private Color color;
    private int x, y, width, height;
    private double dx, dy;

    public Entity(Color color, int x, int y, int width, int height, Game game) {
        this.game = game;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;


        if (dx < 100) {
            dx = 6;
            dy = 0;


        }
    }

    public void move(){
        double nextLeft = x + dx;
        double nextRight = x + width + dx;
        double nextTop = y + dy;
        double nextBottom = y + height + dy;

        if (nextTop <= 0|| nextBottom > game.getWidth()) {
            dx*= -1;
            y+=15;
        }
        if (nextLeft <= 0|| nextRight > game.getWidth()) {
            dx*=-1;
            y+=15;
        }
        x+=dx;

    }

    public void playerMove(){
        setX(game.positionX);

    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }

    public boolean collides(Entity other){
        if (getBounds().intersects(other.getBounds())){
            return true;
        }
        return false;
    }

    public abstract void paint(Graphics g);

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}
