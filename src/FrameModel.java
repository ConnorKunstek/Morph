
/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */


public class FrameModel{

    public Grid getGrid() {
        return grid;
    }

    private Grid grid;

    public Image getImage() {
        return image;
    }

    private Image image;

    public FrameModel(int gridDimmesion){
        grid = new Grid(gridDimmesion);
        image = new Image();
    }
}
