/**
 * @Class: PointModel()
 * @Description: Creates PolygonController
 */
public class PolygonController {

    private PolygonModel model;

    /**
     * @Function:       constructor()
     * @Parameters:     Type: PointController
     * @Returns:        NA
     * @Description:    constructor for point controller
     *
     */
    public PolygonController(PointController p1, PointController p2, PointController p3){
        super();
        this.model = new PolygonModel(p1,p2,p3);
    }

    /**
     * @Function:       getModel()
     * @Parameters:     NA
     * @Returns:        PolygonModel
     * @Description:    returns private variable model
     *
     */
    public PolygonModel getModel() {
        return model;
    }
}
