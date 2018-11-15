
/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */

public class PointModel {

    private int row;

    private PointController top;
    private PointController left;
    private PointController diag;
    private Boolean bound;
    private Boolean topBound;
    private Boolean bottomBound;




    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    private int col;

    public PointController getTop() {
        return top;
    }

    public void setTop(PointController top) {
        this.top = top;
    }

    public PointController getLeft() {
        return left;
    }

    public void setLeft(PointController left) {
        this.left = left;
    }

    public PointController getDiag() {
        return diag;
    }

    public void setDiag(PointController diag) {
        this.diag = diag;
    }

    public Boolean getBound() {
        return bound;
    }

    public void setBound(Boolean bound) {
        this.bound = bound;
    }

    public Boolean getTopBound() {
        return topBound;
    }

    public void setTopBound(Boolean topBound) {
        this.topBound = topBound;
    }

    public Boolean getBottomBound() {
        return bottomBound;
    }

    public void setBottomBound(Boolean bottomBound) {
        this.bottomBound = bottomBound;
    }

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
