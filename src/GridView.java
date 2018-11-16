import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;



/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class GridView extends JPanel {

    /**
     * @Function: constructor()
     * @Parameters: points, and dimension Type: array of arrays of pointControllers and int
     * @Returns: N/A
     * @Description:
     *
     */
    public GridView(PointController[][] points, int dim) {

        super();

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


    public void testMouse(){ System.out.println("GridView Function Called"); }

}
