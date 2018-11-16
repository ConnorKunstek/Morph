import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */

/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class GridModel {

    private int dim;
    private MouseListener mouseListener;
    private MouseMotionAdapter mouseMotionAdapter;
    private PointController[][] points;

    public GridModel(int dim){

        setDim(dim);

        points = new PointController[dim][dim];

        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){
                points[row][col] = new PointController(row, col, dim);
            }
        }
        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){
                points[row][col].setNeighbors(points);
                points[row][col].createView();
            }
        }
    }

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public PointController[][] getPoints() {return points; }

    public int getDim() {return dim;}
    public void setDim(int dim) { this.dim = dim; }

    public MouseListener getMouseListener() { return mouseListener; }

    public MouseMotionAdapter getMouseMotionAdapter() { return mouseMotionAdapter; }

    public PointController getPoint(int row, int col){
        return points[row][col];
    }

}
