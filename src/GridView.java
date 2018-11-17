import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;


/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class GridView extends JPanel implements MouseMotionListener,MouseListener {

    /**
     * @Function: constructor()
     * @Parameters: points, and dimension Type: array of arrays of pointControllers and int
     * @Returns: N/A
     * @Description:
     *
     */
    private boolean isDrag;
    private boolean hasPoint;
    private GridController controller;


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("MousePressed");
        if(!isDrag){
            Point p = e.getPoint();
            int x = (int)p.getX();
            int y = (int)p.getY();
            isDrag = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isDrag = false;
        hasPoint = false;
        debug();
        System.out.println("MouseReleased");

        controller.updateCurrentPointColor(Color.BLACK);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Mouse Event Dragged:");
        debug();
        if(isDrag){
            if(hasPoint){
                if(controller.checkCurrentNeighbors()){
                    controller.updateCurrentPoint(e.getPoint());
                    controller.updateCurrentPointColor(Color.RED);
                }
                else{
                    controller.updateCurrentPoint(controller.getPreviousPoint());
                }
            }
            else{
                System.out.println("Mouse Event Dragged:");
                System.out.println(e.getPoint());
                if(controller.checkCurrentPoints(e.getPoint())){
                    hasPoint = true;
                }
            }

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    /**
     * @Function: constructor()
     * @Parameters: points Type: Array of PointController[][] | dim Type: Int | c Type: GridController
     * @Returns: N/A
     * @Description: creates view for the grid of points
     *
     */
    public GridView(PointController[][] points, int dim, GridController c) {

        super();
        isDrag = false;
        controller = c;
        addMouseListener(this);
        addMouseMotionListener(this);

        this.setLayout(new FlowLayout());
        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){

                this.add(points[row][col].getView());
            }
        }
        this.setSize(500, 500);
        this.setVisible(true);
    }

    /**
     * @Function: debug()
     * @Parameters: NA
     * @Returns: N/A
     * @Description: prints out in the console the current status of booleans set
     * for dragging and containing a point
     */
    public void debug(){
        System.out.println("/***************************************/");
        System.out.println("/ Current| isDrag: \t\t" + isDrag );
        System.out.println("/ Current| hasPointDrag: \t\t" + hasPoint );
    }

}
