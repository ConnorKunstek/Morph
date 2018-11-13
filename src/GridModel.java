
/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */

public class GridModel {

    public Point[][] getPoints() {
        return points;
    }

    private Point[][] points;

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    private int dim;

    public GridModel(int dim){

        setDim(dim);

        points = new Point[dim][dim];

        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){
                points[row][col] = new Point(row, col, dim);
            }
        }
    }

    public Point getPoint(int row, int col){
        return points[row][col];
    }

}
