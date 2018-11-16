import java.awt.*;
import java.util.ArrayList;

/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class PointModel {

    private int row;
    private int col;
    private int x;
    private int y;
    private int oldX;
    private int oldY;
    private int dim;

    private PointController bottom;
    private PointController right;
    private PointController diag;

    private Boolean bottomBound;
    private Boolean rightBound;
    private Boolean diagBound;


    /**
     * @Function: constructor()
     * @Parameters: row num, col num, overall dim, and space between points Type: int, '', '', ''
     * @Returns: N/A
     * @Description: Holds data for PointController Class
     *
     */

    public PointModel(int row, int col, int dim, int space){

        setDim(dim);

        setRow(row);
        setCol(col);

        setX(col * space);
        setY(row * space);

        setRightBound(false);
        setBottomBound(false);
        setDiagBound(false);

        if(row >= dim - 1){
            setBottomBound(true);
        }
        if(col >= dim - 1){
            setRightBound(true);
        }
        if((row - col) >= dim -1)
            setDiagBound(true);
    }

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

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

    public int getX() {  return x; }
    public void setX(int x) {  this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getOldY() {   return oldY;  }
    public void setOldY(int oldY) { this.oldY = oldY;}

    public void setOldX(int oldX) {  this.oldX = oldX;}
    public int getOldX() { return oldX; }

    public PointController getBottom() {
        return this.bottom;
    }
    public void setBottom(PointController bottom) {
        this.bottom = bottom;
    }

    public PointController getRight() {
        return this.right;
    }
    public void setRight(PointController right) {
        this.right = right;
    }

    public PointController getDiag() {
        return diag;
    }
    public void setDiag(PointController diag) {this.diag = diag; }

    public Boolean getBottomBound() {   return bottomBound;  }
    public void setBottomBound(Boolean bottomBound) {this.bottomBound = bottomBound; }

    public Boolean getRightBound() {  return rightBound; }
    public void setRightBound(Boolean rightBound) {this.rightBound = rightBound;}

    public Boolean getDiagBound() {
        return diagBound;
    }

    public void setDiagBound(Boolean diagBound) {
        this.diagBound = diagBound;
    }

    public Point getPoint(){
        Point p = new Point(x, y);
        return p;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public int getDim() {
        return dim;
    }
}
