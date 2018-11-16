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

    private GridController gridPreController;
    private GridController gridPostController;
    private ImageController imageController;
    private SettingsController settingsController;

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
        gridPostController = new GridController(dim);
        gridPreController = new GridController(dim);
        //imageController = new ImageController();
        settingsController = new SettingsController(true);
    }

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public GridController getGridPreContoller() {return gridPreController;}

    public GridController getGridPostContoller() {
        return gridPostController;
    }

    public SettingsController getSettingsController() {
        return settingsController;
    }

    public ImageController getImageController() {
        return imageController;
    }
}
