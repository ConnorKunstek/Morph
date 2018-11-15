import javax.swing.*;
import java.awt.*;

public class LineView extends JComponent {

    public PointController getPoint1() {
        return point1;
    }

    public void setPoint1(PointController point1) {
        this.point1 = point1;
    }

    private PointController point1;

    public PointController getPoint2() {
        return point2;
    }

    public void setPoint2(PointController point2) {
        this.point2 = point2;
    }

    private PointController point2;

    public LineView(PointController point1, PointController point2){
        super();
        setPoint1(point1);
        //System.out.println("("+point1.getModel().getY()+", " + point1.getModel().getX() + ")");
        setPoint2(point2);
        //System.out.println("("+point2.getModel().getY()+", " + point2.getModel().getX() + ")");
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g){

        //System.out.println("("+point1.getModel().getY()+", " + point1.getModel().getX() + ")");
        //System.out.println("("+point2.getModel().getY()+", " + point2.getModel().getX() + ")");

        Graphics2D g2 = (Graphics2D)g;

        //super.paintComponent(g2);
//        g2.setColor(Color.RED);
//        g2.drawOval(point1.getModel().getY(), point1.getModel().getX(), 10, 10);
        System.out.println("("+point1.getModel().getX()+", " + point1.getModel().getY() + ")");
        System.out.println("("+point2.getModel().getX()+", " + point2.getModel().getY() + ")");
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(10));
        g2.drawLine(point1.getModel().getY(), point1.getModel().getX(), point2.getModel().getY(), point2.getModel().getX());
    }
}
