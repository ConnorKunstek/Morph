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
/**
 * @Class: FrameModel()
 * @Description: Holds Frame data
 */

public class FrameModel{

    private GridController gridPreContoller;
    private GridController gridPostContoller;
    private ImageController imageController;

    /**
     * @Function: constructor()
     * @Parameters: mesh dimmension Type: int
     * @Returns: N/A
     * @Description: Creates the pre and post grids
     *
     *
     * @TODO add pre and post images (Part 2)
     *
     */

    public FrameModel(int dim){
        gridPostContoller = new GridController(dim);
        gridPreContoller = new GridController(dim);
        //imageController = new ImageController();
    }

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public GridController getGridPreContoller() {return gridPreContoller;}

    public GridController getGridPostContoller() {
        return gridPostContoller;
    }

    public ImageController getImageController() {
        return imageController;
    }
}
