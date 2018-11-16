/**
 * Connor Kunstek (@ConnorKunstek) and Nick Sladic (@Nickadiemus)
 * CS335 Project 3 - Image Morphing Part 1
 *
 *
 * Take a pre-image, morph into post-image using triangulated mesh overlay
 *
 * to run
 *         $ javac *.class
 *         $ java Morph
 */


/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class PointModel {

    private int row;
    private int col;
    private int x;
    private int y;

    private PointController bottom;
    private PointController right;
    private PointController diag;

    private Boolean topBound;
    private Boolean leftBound;
    private Boolean bottomBound;
    private Boolean rightBound;


    /**
     * @Function: constructor()
     * @Parameters: row num, col num, overall dim, and space between points Type: int, '', '', ''
     * @Returns: N/A
     * @Description: Holds data for PointController Class
     *
     */

    public PointModel(int row, int col, int dim, int space){

        setRow(row);
        setCol(col);

        setX(col * space);
        setY(row * space);

        setTopBound(false);
        setLeftBound(false);
        setRightBound(false);
        setBottomBound(false);

        if(row < 1){
            setTopBound(true);
        }
        if(col < 1){
            setLeftBound(true);
        }
        if(row >= dim - 1){
            setBottomBound(true);
        }
        if(col >= dim - 1){
            setRightBound(true);
        }
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

    public void setLeftBound(Boolean leftBound) { this.leftBound = leftBound;  }
    public Boolean getLeftBound() {return leftBound; }

    public void setTopBound(Boolean topBound) {this.topBound = topBound;}
    public Boolean getTopBound() {return topBound; }

    public Boolean getBottomBound() {   return bottomBound;  }
    public void setBottomBound(Boolean bottomBound) {this.bottomBound = bottomBound; }

    public Boolean getRightBound() {  return rightBound; }
    public void setRightBound(Boolean rightBound) {this.rightBound = rightBound;}
}
