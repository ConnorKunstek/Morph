
import java.awt.event.*;
import java.awt.Point;

/**
 * @Class: FrameController()
 * @Description: Creates program
 */


public class PointController extends Point implements ActionListener {

    private PointView view;
    private PointModel model;


    /**
     * @Function: cosntructor()
     * @Parameters: row, col, dim Type: in, '', ''
     * @Returns: N/A
     * @Description: creates model
     *
     */

    public PointController(int row, int col, int dim){
        super();
        model = new PointModel(row, col, dim, 50);
    }

    /**
     * @Function: ()
     * @Parameters: Type:
     * @Returns: N/A
     * @Description: creates view
     *
     *
     * NEEDS TO BE CALLED LAST, after constructor and after setNeighbors
     *
     * view is created last because it needs each point and their neighbors (set in constructor and setNeighbors)
     */
    public void createView(){

        view = new PointView(this, model.getRight(), model.getBottom(), model.getDiag());
    }

    /**
     * @Function: setNeighbors()
     * @Parameters: Type:
     * @Returns: N/A
     * @Description: Saves point to the right, bottom, and right-down diagonal to the points model
     *
     *
     * NEEDS TO BE CALLED 2ND, after Constructor and before View is created
     */
    public void setNeighbors(PointController[][] points){
        if(!model.getRightBound()){
            setRight(points[model.getRow()][model.getCol()+1]);
        }else{
            setRight(null);
        }
        if(!model.getBottomBound()){
            setBottom(points[model.getRow()+1][model.getCol()]);
        }else{
            setBottom(null);
        }
        if(!model.getRightBound() && !model.getBottomBound()){
            setDiag(points[model.getRow()+1][model.getCol()+1]);
        }else{
            setDiag(null);
        }
    }



    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public PointModel getModel() {
        return model;
    }

    public PointView getView() {
        return view;
    }

    public void setBottom(PointController point){
        getModel().setBottom(point);
    }

    public void setRight(PointController point){
        getModel().setRight(point);
    }

    public void setDiag(PointController point){
        getModel().setDiag(point);
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("THIS IS E: " + e);
    }

}
