
/**
 * @Class: PointController()
 * @Description: Creates PointModel
 */


public class PointController {

    private PointModel model;


    /**
     * @Function: ()
     * @Parameters: Type:
     * @Returns:
     * @Description:
     *
     */
    public PointController(double x, double y){
        super();
        model = new PointModel(x,y);
    }

    /**
     * @Function:       getModal()
     * @Parameters:     NA
     * @Returns:        Type: PointModel
     * @Description:    Gets the current private variable PointModel
     *
     */
    public PointModel getModel() {
        return model;
    }
}
