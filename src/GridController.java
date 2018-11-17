
import java.awt.*;
import java.awt.event.*;


/**
 * @Class: GridController()
 * @Description: Creates Grid View and Model
 */

public class GridController implements ActionListener {

    GridView view;
    GridModel model;
    Point currentPoint = null;

    /**
     * @Function: constructor()
     * @Parameters: Mesh dimmension Type: int
     * @Returns: N/A
     * @Description: Creates grid view and model
     *
     */
    public GridController(int dim){
        model = new GridModel(dim);
        view = new GridView(model.getPoints(), dim, this);
    }

    /**
     * @Function: checkCurrentPoints()
     * @Parameters: cur Type: Point
     * @Returns: boolean
     * @Description: calls model function to check for points
     *
     */
    public boolean checkCurrentPoints(Point cur){
        Point p = model.checkPoints(cur);
        if(((int)p.getX() == -1) && ((int)p.getY() == -1)){
            currentPoint = p;
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * @Function: updateCurrentPoints()
     * @Parameters: e Type: Point
     * @Returns: N/A
     * @Description: calls the model function to update the current point
     *
     */
    public void updateCurrentPoint(Point e){
        currentPoint = e;
        model.debugCur();
        model.setNewPoint(currentPoint);
        model.updatePoint();
    }

    /**
     * @Function: checkCurrentNeighbors()
     * @Parameters: NA
     * @Returns: boolean
     * @Description: calls the model function to check if the current point is inside its neighbors
     *
     */
    public boolean checkCurrentNeighbors(){
        if(model.checkIfInsideNeighbors()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @Function: updateCurrentPointColor()
     * @Parameters: color Type: Color
     * @Returns: N/A
     * @Description: calls the model function to update the current color of selected point
     *
     */
    public void updateCurrentPointColor(Color color){
        model.changePointColor(color);
        model.updatePoint();
    }

    /**
     * @Function: getPreviousPoint()
     * @Parameters: NA
     * @Returns: Point
     * @Description: calls the model function to get the previous point selected
     *
     * NOTE: WILL BE USED TO RESET POINT IF A USER HITS A BOUNDS ( NOT YET IMPLEMENTED )
     *
     */
    public Point getPreviousPoint(){
        return model.getPrev();
    }


    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public GridView getView() {
        return view;
    }

    public GridModel getModel() {
        return model;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(e);
    }

}
