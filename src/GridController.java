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
        if((p.getX() == -1) && (p.getY() == -1)){
            currentPoint = p;
            return true;
        }
        else{
            return false;
        }
    }

    public void updateCurrentPoint(Point e){
        currentPoint = e;
        model.setNewPoint(currentPoint);
        model.updatePoint();
    }
}
