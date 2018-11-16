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

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("MouseClicked");
        debug();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("MousePressed");
        if(!isDrag){
            Point p = e.getPoint();
            int x = (int)p.getX();
            int y = (int)p.getY();
            System.out.println("( " + x +", " + y + ")");
            isDrag = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isDrag = false;
        hasPoint = false;
        controller.updateCurrentPointColor(Color.BLACK);
        System.out.println("MouseReleased");
        debug();

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
                controller.updateCurrentPoint(e.getPoint());
                controller.updateCurrentPointColor(Color.RED);
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

    private GridController controller;
    public GridView(PointController[][] points, int dim, GridController c) {

        super();
        isDrag = false;
        controller = c;
        addMouseListener(this);
        addMouseMotionListener(this);
//        this.setLayout(new GridLayout(dim, dim, 10, 10));
//        this.setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//        c.fill = GridBagConstraints.HORIZONTAL;

        this.setLayout(new FlowLayout());
        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){

//                c.weightx = 5;
//                c.weighty = 5;
//                c.gridx = row;
//                c.gridy = col;
//                c.ipadx = 5;
//                c.ipady = 5;
//                this.add(points[row][col].getView(), c);

                this.add(points[row][col].getView());
            }
        }
        this.setSize(1000, 1000);
        this.setVisible(true);
    }
    public void debug(){
        System.out.println("/***************************************/");
        System.out.println("/ Current| isDrag: \t\t" + isDrag );
        System.out.println("/ Current| hasPointDrag: \t\t" + hasPoint );
    }

}
