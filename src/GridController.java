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

import java.awt.event.*;

/**
 * @Class: GridController()
 * @Description: Creates Grid View and Model
 */

public class GridController implements ActionListener {

    GridView view;
    GridModel model;

    /**
     * @Function: constructor()
     * @Parameters: Mesh dimmension Type: int
     * @Returns: N/A
     * @Description: Creates grid view and model
     *
     */
    public GridController(int dim){
        model = new GridModel(dim);
        view = new GridView(model.getPoints(), dim);
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
