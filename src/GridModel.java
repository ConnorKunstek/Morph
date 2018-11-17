
import java.awt.*;
import java.util.Hashtable;


/**
 * @Class: GridModel()
 * @Description: Creates program
 */

public class GridModel {

    private int dim;
    private PointController[][] points;
    private PointController cur;
    private PointController prev;
    /**
     * @Function: constructor()
     * @Parameters: dim Type: int
     * @Returns: N/A
     * @Description: creates the data stored for manipulation based on view and controller
     * responses
     */
    public GridModel(int dim){

        setDim(dim);
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

    /**
     * @Function: setNewPoint()
     * @Parameters: c Type: Point
     * @Returns: N/A
     * @Description: Sets the new point of the current selected point while dragging
     *
     */
    public void setNewPoint(Point c){
        int x = (int)c.getX();
        int y = (int)c.getY();
        debugCur();
        prev = cur;
        cur.getModel().setX(x);
        cur.getModel().setY(y);

    }
    /**
     * @Function: changePointColor()
     * @Parameters: color Type: Color
     * @Returns: N/A
     * @Description: Changes the current point chosen to red to show visually selected point
     */
    public void changePointColor(Color color){
        cur.getView().setDotColor(color);
    }

    /**
     * @Function: updatePoint()
     * @Parameters: N/A
     * @Returns: N/A
     * @Description: calls the respected function of the point chosen to repaint the updated coordinates
     *
     */
    public void updatePoint(){
        cur.getView().repaint();
    }

    /**
     * @Function: checkPoints()
     * @Parameters: curr Type: Point
     * @Returns: Point
     * @Description: checks if the current point is within the buffer of the point clicked on. It will
     * return the point if found and set the current point of the model's class to the point. Else it will
     * return a point out of bounds if not found
     */
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
                    prev = points[r][c];
                    return cp;
                }
            }
        }
        return p;

    }

    /**
     * @Function: checkCurrentPoint()
     * @Parameters: checkpoint, curpoint Type: Point
     * @Returns: boolean
     * @Description: buffer for checking if a user selects a point
     */
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

    /**
     * @Function: checkIfInsideNeighbors()
     * @Parameters: NA
     * @Returns: boolean
     * @Description: checks if the current point being moved is inside the hexagonal bounds of the mesh
     */
    public boolean checkIfInsideNeighbors(){
        int curr = cur.getModel().getRow();
        int curc = cur.getModel().getCol();
        Hashtable<String, Point > nb = getItsNeighbors(curr,curc);
        System.out.println("CheckIfInsideNeighbors");
        if(checkInBounds(nb)){
            System.out.println("INSIDE OF BOUNDS");
            return true;
        }
        else{
            System.out.println("OUTSIDE OF BOUNDS");
            return false;
        }
    }

    /**
     * @Function: getItsNeighbors()
     * @Parameters: r, c Type: int
     * @Returns: Hashtable
     * @Description: gets the surrounding neighbors of the current point in the array
     *
     */
    public Hashtable<String, Point > getItsNeighbors(int r, int c){
        Hashtable<String, Point > hashbounds = new Hashtable<>();
        PointController topbound = points[r-1][c-1];
        PointController bottombound = points[r][c];
        hashbounds.put("NW", topbound.getModel().getPoint());
        hashbounds.put("N", topbound.getModel().getRight().getModel().getPoint());
        hashbounds.put("W", topbound.getModel().getBottom().getModel().getPoint());
        hashbounds.put("S", bottombound.getModel().getBottom().getModel().getPoint());
        hashbounds.put("E", bottombound.getModel().getRight().getModel().getPoint());
        hashbounds.put("SE",bottombound.getModel().getDiag().getModel().getPoint());

        return hashbounds;
    }

    /**
     * @Function: checkInBounds()
     * @Parameters: b Type: HashTable<String, Point>
     * @Returns: boolean
     * @Description: returns true if the current point is inside the polygon created from the surrounding neighbors
     */
    public boolean checkInBounds(Hashtable<String, Point> b){
        //NW to N bound
        Polygon bound;
        int xp[] = {
                (int)b.get("NW").getX(),
                (int)b.get("N").getX(),
                (int)b.get("E").getX(),
                (int)b.get("SE").getX(),
                (int)b.get("S").getX(),
                (int)b.get("W").getX()
        };
        int yp[] = {
                (int)b.get("NW").getY(),
                (int)b.get("N").getY(),
                (int)b.get("E").getY(),
                (int)b.get("SE").getY(),
                (int)b.get("S").getY(),
                (int)b.get("W").getY()
        };

        bound = new Polygon(xp,yp,xp.length);
        for(int i = 0; i < xp.length; i++){
            System.out.println("(" + xp[i] + "," + yp[i] + ")");
        }
        if(bound.contains(cur.getModel().getX(),cur.getModel().getY())){
            return true;
        }
        else{
            cur = prev;
            return false;
        }

    }
    /**
     * @Function: debugPoint()
     * @Parameters: c Type: Point
     * @Returns: N/A
     * @Description: debugger for a point
     *
     */
    public void debugPoint(Point c){
        System.out.println("Current Point: (" + (int)c.getX() + ", " + (int)c.getY() + ")");
    }
    /**
     * @Function: debugCur()
     * @Parameters: Type:
     * @Returns: N/A
     * @Description: returns current and previous points positions from the model object
     */
    public void debugCur(){
        System.out.println("Current: (" + cur.getModel().getX() + ", " + cur.getModel().getY() + ")");
        System.out.println("Previous: (" + prev.getModel().getX() + ", " + prev.getModel().getY() + ")");
    }

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public PointController[][] getPoints() {return points; }
    public int getDim() {return dim;}

    public void setDim(int dim) { this.dim = dim; }

    public PointController getPoint(int row, int col){
        return points[row][col];
    }

    public Point getPrev(){
        return prev.getModel().getPoint();
    }
}
