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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class FrameController implements ActionListener {

    private FrameModel model;
    private FrameView view;
    private int dim;

    /**
     * @Function: constructor()
     * @Parameters: dimmension of grid Type: int
     * @Returns: N/A
     * @Description: Creates FrameModel and FrameView
     *
     */

    public FrameController(int dim){

        setDim(dim);

        model = new FrameModel(dim);
        view = new FrameView(
                model.getGridPreContoller().getView(),
                model.getGridPostContoller().getView(),
                model.getSettingsController().getView()
        );

//        FrameView view = new FrameView(model.getGrid().getView(), model.getImage().getView());
//        FrameView view = new FrameView(model.getGrid().getView());
//        FrameView view = new FrameView(model.getImageController().getView());

    }

//    public void preview(){
//
//
//        for(int row = 0; row < dim; row++) {
//
//            model.getGridPreContoller().getModel().getPoint(row, col).set
//
//        }
//    }

    public void actionPerformed(ActionEvent e){}

    public void setDim(int dim) {
        this.dim = dim;
    }

    public int getDim() {
        return dim;
    }
}
