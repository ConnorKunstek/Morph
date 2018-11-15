import javax.swing.*;
import java.awt.*;

public class PointView extends JComponent {

    public PointView(int x, int y, boolean right, boolean bottom){
        super();
        setX(x);
        setY(y);
        setRight(right);
        setBottom(bottom);
        this.setLocation(x, y);
        this.setVisible(true);
    }

    private Color color;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(getColor());
        g.fillOval(0, 0, 10, 10);
//        if(!isBottom() && !isRight()) {
//            g.drawRect(5, 5, 50, 50);
//        }

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

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    private boolean right;

    public boolean isBottom() {
        return bottom;
    }

    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }

    private boolean bottom;

}
