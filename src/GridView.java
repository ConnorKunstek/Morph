import javax.swing.JPanel;
import java.awt.*;

/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */

public class GridView extends JPanel {

    public GridView(PointController[][] points, int dim) {
        super();

//        this.setLayout(new GridLayout(dim, dim, 10, 10));
        //this.setLayout(new GridBagLayout());
        this.setLayout(new FlowLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){
                c.weightx = 25;
                c.weighty = 25;
                c.gridx = row;
                c.gridy = col;
                c.ipadx = 25;
                c.ipady = 25;
                this.add(points[row][col].getView());

                //System.out.println("Point: (" + points[row][col].getView().getX() +", " + points[row][col].getView().getY() + ")");
//                if(!points[row][col].getModel().getTopBound()) {
//                    this.add(points[row][col].getModel().getTopLine().getView());
//                }
//                if(!points[row][col].getModel().getLeftBound()) {
//                    this.add(points[row][col].getModel().getLeftLine().getView());
//                }
//                if(!points[row][col].getModel().getRightBound() && !points[row][col].getModel().getTopBound()) {
//                    this.add(points[row][col].getModel().getDiagLine().getView());
//                }
            }
        }

        //this.setLayout(null);

//        for (int row = 0; row < dim; row++) {
//            for (int col = 0; col < dim; col++) {
//                if (!points[row][col].getModel().getTopBound()) {
//                    this.add(points[row][col].getModel().getTopLine().getView());
//                }
//                if (!points[row][col].getModel().getLeftBound()) {
//                    this.add(points[row][col].getModel().getLeftLine().getView());
//                }
//                if (!points[row][col].getModel().getRightBound() && !points[row][col].getModel().getTopBound()) {
//                    this.add(points[row][col].getModel().getDiagLine().getView());
//                }
//            }
//        }

        this.setSize(1000, 1000);
        this.setVisible(true);
    }
}
