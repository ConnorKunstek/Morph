
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;


/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */

public class PointModel {

    private int row;

    private PointController bottom;
    private PointController right;
    private PointController diag;
    private Boolean bound;
    private Boolean topBound;
    private Boolean bottomBound;
    private Boolean rightBound;
    private int col;


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

    public PointController getBottom() {
        return this.bottom;
    }

    public void setBottom(PointController bottom) {
        this.bottom = bottom;
    }

    public PointController getRight() {
        return this.right;
    }

    public void setLeft(PointController right) {
        this.right = right;
    }

    public PointController getDiag() {
        return diag;
    }

    public void setDiag(PointController diag) {
        this.diag = diag;
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

    public Boolean getLeftBound() {
        return leftBound;
    }

    public void setLeftBound(Boolean leftBound) {
        this.leftBound = leftBound;
    }

    private Boolean leftBound;

    private LineController diagLine;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private int x;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int y;


    public PointModel(int row, int col, int dim, int space){
        setRow(row);
        setCol(col);

        setX(col * space);
        setY(row * space);

        setTopBound(false);
        setLeftBound(false);
        setRightBound(false);
        setBottomBound(false);

        if(row == 0){
            setTopBound(true);
        }
        if(row == dim -1){
            setBottomBound(true);
        }
        if(col == 0){
            setLeftBound(true);
        }
        if(col == dim - 1){
            setRightBound(true);
        }
    }
}
