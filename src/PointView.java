import javax.swing.*;
import java.awt.*;

public class PointView extends JComponent {

    public PointView(int x, int y){
        super();
        setX(x);
        setY(y);
        this.setVisible(true);
    }

    private Color color;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(getColor());
        g.fillOval(0, 0, 10, 10);
    }

    public void setColor(Color color){this.color = color; repaint();}
    public Color getColor(){return this.color;}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private int x;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int y;

}
