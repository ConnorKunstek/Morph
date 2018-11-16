
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */

/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class GridModel {

    private int dim;
    private MouseListener mouseListener;
    private MouseMotionListener mouseMotionListener;
    private PointController[][] points;
    private PointController cur;

    public GridModel(int dim){

        setDim(dim);
//        setupListeners();
        points = new PointController[dim][dim];

        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){
                points[row][col] = new PointController(row, col, dim);
            }
        }
        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){
                points[row][col].setNeighbors(points);
                points[row][col].createView();
            }
        }
    }

    public void setNewPoint(Point c){
        int x = (int)c.getX();
        int y = (int)c.getY();
        cur.getModel().setX(x);
        cur.getModel().setY(y);
    }
    public void updatePoint(){
        cur.getView().repaint();
    }

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public PointController[][] getPoints() {return points; }

    public int getDim() {return dim;}
    public void setDim(int dim) { this.dim = dim; }

    public MouseListener getMouseListener() { return mouseListener; }

    public MouseMotionListener getMouseMotionListener() { return mouseMotionListener; }

    public PointController getPoint(int row, int col){
        return points[row][col];
    }

    public Point checkPoints(Point curr){
        Point p = new Point(-1,-1);
        for(int r = 0; r < points.length; r++){
            for(int c = 0; c < points.length; c++){
                int curx = points[r][c].getModel().getX();
                int cury = points[r][c].getModel().getY();
                Point cp = new Point(curx,cury);
                if(checkCurrentPoint(cp,curr)){
                    System.out.println("Found!!!!");
                    cur = points[r][c];
                    return cp;
                }
            }
        }

        return p;

    }

    public boolean checkCurrentPoint(Point checkpoint, Point curpoint){
        int xcheck = (int)checkpoint.getX();
        int ycheck = (int)checkpoint.getY();
        int cpx = (int)curpoint.getX();
        int cpy = (int)curpoint.getY();
        if((xcheck-5 <= cpx) && (cpx <= xcheck+5) && (ycheck-5 <= cpy) && (cpy <= ycheck+5)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkIfInsideNeighbors(){
        int curr = cur.getModel().getRow();
        int curc = cur.getModel().getCol();
        ArrayList<PointController> nb = getItsNeighbors(curr,curc);
        return true;
    }

    public ArrayList<PointController> getItsNeighbors(int r, int c){
        ArrayList<PointController> n = null;
        if(points[r][c].getModel().getBottomBound()){
            n.add(points[r][c].getModel().getBottom());
        }
        if(points[r][c].getModel().getRightBound()){
            n.add(points[r][c].getModel().getRight());
        }
        if(points[r][c].getModel().get)

        return n;
    }


}
