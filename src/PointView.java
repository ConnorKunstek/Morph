import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;


/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class PointView extends JComponent {

    private int x;
    private int y;
    private boolean isChosen;
    private int id;
    private PointController thisPoint, diag, right, bottom;
    private Color color;

    /**
     * @Function: constructor()
     * @Parameters: this point and neighbor points and mouse listeners Type: PointControllers and mouse listeners
     * @Returns: N/A
     * @Description: creates each point's and lines visuals
     *
     */

    public PointView(PointController thisPoint,
                     PointController rightPoint,
                     PointController bottomPoint,
                     PointController diagPoint)
    {
        super();
        //set points
        setThisPoint(thisPoint);
        setRight(rightPoint);
        setBottom(bottomPoint);
        setDiag(diagPoint);

        this.setPreferredSize(new Dimension(500, 500));
        this.setVisible(true);
    }


    /**
     * @Function: paint()
     * @Parameters: Grapics type: graphics
     * @Returns: N/A
     * @Description: paints dot and needed lines
     *
     */
    @Override
    public void paintComponent(Graphics g){

        //Dots
        super.paintComponent(g);
        if(
            thisPoint.getModel().getRow() != 0 &&
            thisPoint.getModel().getRow() != thisPoint.getModel().getDim()-1 &&
            thisPoint.getModel().getCol() != 0 &&
            thisPoint.getModel().getCol() != thisPoint.getModel().getDim()-1)
        {
            g.setColor(getColor());
            g.fillOval(thisPoint.getModel().getX() - 5, thisPoint.getModel().getY() - 5, 10, 10);
        }
        //Lines
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));

        //Right Line
        if(getRight() != null) {
            g.drawLine( getThisPoint().getModel().getX(),
                        getThisPoint().getModel().getY(),
                        getRight().getModel().getX(),
                        getRight().getModel().getY()
            );
        }

        //Bottom Line
        if(getBottom() != null){
            g.drawLine( getThisPoint().getModel().getX(),
                        getThisPoint().getModel().getY(),
                        getBottom().getModel().getX(),
                        getBottom().getModel().getY()
            );
        }

        //Diagonal Line
        if(getDiag() != null){
            g.drawLine( getThisPoint().getModel().getX(),
                        getThisPoint().getModel().getY(),
                        getDiag().getModel().getX(),
                        getDiag().getModel().getY()
            );
        }
    }

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public void setDotColor(Color color){this.color = color; repaint();}
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
