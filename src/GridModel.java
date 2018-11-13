
/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */

public class GridModel {

    public PointController[][] getPoints() {
        return points;
    }

    private PointController[][] points;

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    private int dim;

    public GridModel(int dim){

        setDim(dim);

        points = new PointController[dim][dim];

        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){
                points[row][col] = new PointController(row, col, dim);
            }
        }
    }

    public PointController getPoint(int row, int col){
        return points[row][col];
    }

}
