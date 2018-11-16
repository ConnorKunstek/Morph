


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
