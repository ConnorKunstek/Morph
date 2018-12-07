import java.awt.*;
import java.awt.geom.*;

/**
 * @Class: PolygonModel()
 * @Description: Creates PolygonModel
 */
public class PolygonModel {

    private Ellipse2D.Double[] triangle;
    /**
     * @Function:       constructor()
     * @Parameters:     Type:   PointController
     * @Returns:        NA
     * @Description:    Creates the PolygonModel
     *
     */
    public PolygonModel(PointController p1, PointController p2, PointController p3){
        this.triangle = new Ellipse2D.Double[3];    //creates new array of 2D Ellipse Points
        setPoints(p1.getModel(), p2.getModel(), p3.getModel());
    }


    /**
     * @Function:       setPoints()
     * @Parameters:     Type:   PointModel
     * @Returns:        NA
     * @Description:    sets indexes for private variable triangle
     *
     */
    public void setPoints(PointModel p1, PointModel p2, PointModel p3){
        this.triangle[0] = p1;
        this.triangle[1] = p2;
        this.triangle[2] = p3;
    }

    /**
     * @Function:       getTriangle()
     * @Parameters:     NA
     * @Returns:        Ellipse2D.Double[]
     * @Description:    returns the private variable triangle
     *
     */
    public Ellipse2D.Double[] getTriangle() {
        return triangle;
    }

    /**
     * @Function:       getX()
     * @Parameters:     Type: integer
     * @Returns:        double
     * @Description:    returns the position x of selected triangle index
     *
     */
    public double getX(int pointIndex){
        try{
            return triangle[pointIndex].getX();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ERROR: OUT OF BOUNDS");
            return (0.0);
        }
    }


    /**
     * @Function:       getY()
     * @Parameters:     Type: integer
     * @Returns:        double
     * @Description:    returns the position y of selected triangle index
     *
     */
    public double getY(int pointIndex){
        try{
            return triangle[pointIndex].getY();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ERROR: OUT OF BOUNDS");
            return (0.0);
        }
    }
}
