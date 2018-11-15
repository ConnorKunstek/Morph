import javax.swing.*;
import java.awt.*;

public class PointView extends JComponent {

    private PointController thisPoint, diag, right, bottom;
    private Color color;
    private int y, x;

    public PointView(PointController thisPoint, PointController rightPoint, PointController bottomPoint, PointController diagPoint){
        super();
        setThisPoint(thisPoint);
        setRight(rightPoint);
        setBottom(bottomPoint);
        setDiag(diagPoint);
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
        return bottom;
    }

    public void setRight(PointController right) {
        this.right = right;
    }

    public PointController getRight() {
        return right;
    }

    public void setDiag(PointController diag) {
        this.diag = diag;
    }

    public PointController getDiag() {
        return diag;
    }
}
