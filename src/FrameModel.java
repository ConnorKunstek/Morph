
/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */


public class FrameModel{
    private GridController gridPreContoller;
    private GridController gridPostContoller;
    private ImageController imageController;


    public GridController getGridPreContoller() {
        return gridPreContoller;
    }

    public GridController getGridPostContoller() {
        return gridPostContoller;
    }

    public ImageController getImageController() {
        return imageController;
    }

    public FrameModel(int gridDimension){
        gridPostContoller = new GridController(gridDimension);
        gridPreContoller = new GridController(gridDimension);
        imageController = new ImageController();
    }


}
