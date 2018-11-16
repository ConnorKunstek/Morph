
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

    public void updateCurrentPoint(Point e){
        currentPoint = e;
        model.setNewPoint(currentPoint);
        model.updatePoint();
    }
}
