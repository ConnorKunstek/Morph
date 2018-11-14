
import java.awt.Point;


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

    public PointController getTop() {
        return top;
    }

    public void setTop(PointController top) {
        this.top = top;
    }

    private PointController top;

    public PointController getLeft() {
        return left;
    }

    public void setLeft(PointController left) {
        this.left = left;
    }

    private PointController left;

    public PointController getDiag() {
        return diag;
    }

    public void setDiag(PointController diag) {
        this.diag = diag;
    }

    private PointController diag;

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

    private LineController topLine;

    public LineController getTopLine(){
        return this.topLine;
    }

    public void setTopLine(PointController point1, PointController point2){
        System.out.println("Top line");
        topLine = new LineController(point1, point2);
    }

    private LineController leftLine;

    public LineController getLeftLine(){
        return this.leftLine;
    }

    public void setLeftLine(PointController point1, PointController point2){
        System.out.println("left line");
        leftLine = new LineController(point1, point2);
    }

    private LineController diagLine;

    public LineController getDiagLine(){
        return this.diagLine;
    }

    public void setDiagLine(PointController point1, PointController point2){
        System.out.println("diagonal line");
        diagLine = new LineController(point1, point2);
    }


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
        if(col == dim - 1){
            setRightBound(true);
            setBound(true);
        }
    }
}
