
/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */

public class PointModel {

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    private int row;

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    private int col;

    public Point getTop() {
        return top;
    }

    public void setTop(Point top) {
        this.top = top;
    }

    private Point top;

    public Point getLeft() {
        return left;
    }

    public void setLeft(Point left) {
        this.left = left;
    }

    private Point left;

    public Point getDiag() {
        return diag;
    }

    public void setDiag(Point diag) {
        this.diag = diag;
    }

    private Point diag;

    public Boolean getBound() {
        return bound;
    }

    public void setBound(Boolean bound) {
        this.bound = bound;
    }

    private Boolean bound;

    public Boolean getTopBound() {
        return topBound;
    }

    public void setTopBound(Boolean topBound) {
        this.topBound = topBound;
    }

    private Boolean topBound;

    public Boolean getBottomBound() {
        return bottomBound;
    }

    public void setBottomBound(Boolean bottomBound) {
        this.bottomBound = bottomBound;
    }

    private Boolean bottomBound;

    public Boolean getRightBound() {
        return rightBound;
    }

    public void setRightBound(Boolean rightBound) {
        this.rightBound = rightBound;
    }

    private Boolean rightBound;

    public Boolean getLeftBound() {
        return leftBound;
    }

    public void setLeftBound(Boolean leftBound) {
        this.leftBound = leftBound;
    }

    private Boolean leftBound;

    public PointModel(int row, int col, int dim){
        setRow(row);
        setCol(col);

        setBound(false);
        setTopBound(false);
        setLeftBound(false);
        setRightBound(false);
        setBottomBound(false);

        if(row == 0){
            setTopBound(true);
            setBound(true);
        }
        if(row == dim -1){
            setBottomBound(true);
            setBound(true);
        }
        if(col == 0){
            setLeftBound(true);
            setBound(true);
        }
        if(row == dim -1){
            setRightBound(true);
            setBound(true);
        }
    }
}
