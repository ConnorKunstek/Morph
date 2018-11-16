/**
 * Connor Kunstek (@ConnorKunstek) and Nick Sladic (@Nickadiemus)
 * CS335 Project 3 - Image Morphing Part 1
 *
 *
 * Take a pre-image, morph into post-image using triangulated mesh overlay
 *
 * to run
 *         $ javac *.class
 *         $ java Morph
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;


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
     * @Function: cosntructor()
     * @Parameters: this point and neighbor points and mouse listeners Type: PointControllers and mouse listeners
     * @Returns: N/A
     * @Description: creates each point's and lines visuals
     *
     */

    public PointView(
                    PointController thisPoint,
                    PointController rightPoint,
                    PointController bottomPoint,
                    PointController diagPoint,

                    MouseMotionAdapter MMA,
                    MouseListener ML
    ){
        super();

        //set points
        setThisPoint(thisPoint);
        setRight(rightPoint);
        setBottom(bottomPoint);
        setDiag(diagPoint);

        //add mouse listeners
        this.addMouseMotionListener(MMA);
        this.addMouseListener(ML);

        this.setSize(50, 50);
        this.setPreferredSize(new Dimension(50, 50));
        this.setMinimumSize(new Dimension(50, 50));
        this.setMaximumSize(new Dimension(50, 50));
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

        super.paintComponent(g);

        //dots
        if(     !thisPoint.getModel().getTopBound() &&
                !thisPoint.getModel().getLeftBound() &&
                !thisPoint.getModel().getRightBound() &&
                !thisPoint.getModel().getBottomBound())
        {
            g.setColor(getColor());
            g.fillOval(thisPoint.getModel().getX(), thisPoint.getModel().getY(), 10, 10);
        }

        //Lines
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(getColor());
        g2.setStroke(new BasicStroke(2));

        //Right Line
        if(getRight() != null) {
            g.drawLine( getThisPoint().getModel().getX()+5,
                        getThisPoint().getModel().getY()+5,
                        getRight().getModel().getX()+5,
                        getRight().getModel().getY()+5
            );
        }

        //Bottom Line
        if(getBottom() != null){
            g.drawLine( getThisPoint().getModel().getX()+5,
                        getThisPoint().getModel().getY()+5,
                        getBottom().getModel().getX()+5,
                        getBottom().getModel().getY()+5
            );
        }

        //Diagonal Line
        if(getDiag() != null){
            g.drawLine( getThisPoint().getModel().getX()+5,
                        getThisPoint().getModel().getY()+5,
                        getDiag().getModel().getX()+5,
                        getDiag().getModel().getY()+5
            );
        }
    }

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

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
