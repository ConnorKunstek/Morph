import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class PointView extends JComponent {
    private int x;
    private int y;
    private boolean isChosen;
    private int id;
    private PointController thisPoint, diag, right, bottom;
    private Color color;



    public PointView(PointController thisPoint, PointController rightPoint, PointController bottomPoint, PointController diagPoint, MouseMotionAdapter MMA, MouseListener ML){
        super();
        setThisPoint(thisPoint);
        setRight(rightPoint);
        setBottom(bottomPoint);
        setDiag(diagPoint);
        this.addMouseMotionListener(MMA);
        this.addMouseListener(ML);
        this.setPreferredSize(new Dimension(500, 500));
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.setColor(getColor());
        g.fillOval(thisPoint.getModel().getX(), thisPoint.getModel().getY(), 10, 10);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(getColor());
        g2.setStroke(new BasicStroke(2));
        if(getRight() != null) {
            g.drawLine(getThisPoint().getModel().getX(), getThisPoint().getModel().getY(), getRight().getModel().getX(), getRight().getModel().getY());
        }
        if(getBottom() != null){
            g.drawLine(getThisPoint().getModel().getX(), getThisPoint().getModel().getY(), getBottom().getModel().getX(), getBottom().getModel().getY());
        }
        if(getDiag() != null){
            g.drawLine(getThisPoint().getModel().getX(), getThisPoint().getModel().getY(), getDiag().getModel().getX(), getDiag().getModel().getY());
        }
    }

    public void setColor(Color color){this.color = color; repaint();}

    public Color getColor(){return this.color;}

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

    public void setThisPoint(PointController thisPoint) {
        this.thisPoint = thisPoint;
    }

    public PointController getThisPoint() {
        return thisPoint;
    }

    public void setBottom(PointController bottom) {
        this.bottom = bottom;
    }

    public PointController getBottom() {
        return this.bottom;
    }

    public PointController getRight() {
        return right;
    }

    public void setRight(PointController right) {
        this.right = right;
    }

    public PointController getDiag() {
        return diag;
    }

    public void setDiag(PointController diag) {
        this.diag = diag;
    }
}
