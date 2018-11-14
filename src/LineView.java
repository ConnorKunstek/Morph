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
        System.out.println("("+point1.getModel().getRow()+", " + point1.getModel().getCol() + ")");
        setPoint2(point2);
        System.out.println("("+point2.getModel().getRow()+", " + point2.getModel().getCol() + ")");
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D)g;

        super.paintComponent(g2);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(10));
        g2.drawLine(point1.getModel().getRow(), point1.getModel().getCol(), point2.getModel().getRow(), point2.getModel().getCol());
    }
}
