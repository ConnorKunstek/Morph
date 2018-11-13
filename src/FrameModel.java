
/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */


public class FrameModel{

    public GridController getGridController() {
        return gridController;
    }

    private GridController gridController;

    public ImageController getImageController() {
        return imageController;
    }

    private ImageController imageController;

    public FrameModel(int gridDimension){
        gridController = new GridController(gridDimension);
        imageController = new ImageController();
    }


}
