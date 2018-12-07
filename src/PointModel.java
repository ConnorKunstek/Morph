import java.awt.geom.Ellipse2D;
import java.awt.*;
/**
 * @Class: PointModel()
 * @Description: Creates PointModel
 */

public class PointModel extends Ellipse2D.Double{

    private double x,y;
    private Color pointColor;
    /**
     * @Function: constructor()
     * @Parameters: row num, col num, overall dim, and space between points Type: int, '', '', ''
     * @Returns: N/A
     * @Description: Holds data for PointController Class
     *
     */

    public PointModel(double x, double y){
        height = 10;
        width = 10;
        setX(x);
        setY(y);
        setColor(Color.BLACK);

    }


    ////////////////////////////////GETTERS AND SETTERS//////////////////////////////////////////////////////////////////

    /**
     * @Function:       setX()
     * @Parameters:     Type: double
     * @Returns:        NA
     * @Description:    Sets the private variable x
     *
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @Function:       setY()
     * @Parameters:     Type: double
     * @Returns:        NA
     * @Description:    Sets the private variable y
     *
     */
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * @Function:       setColor()
     * @Parameters:     Type: Color
     * @Returns:        NA
     * @Description:    sets the private variable pointColor
     *
     */
    public void setColor(Color c){
        this.pointColor = c;
    }

    /**
     * @Function:       getColor()
     * @Parameters:     NA
     * @Returns:        Type: Color
     * @Description:    returns the current color of the object
     *
     */
    public Color getColor(){
        return this.pointColor;
    }

    /**
     * @Function:       setCurrentPos()
     * @Parameters:     Type: double
     * @Returns:        NA
     * @Description:    sets the private variables x and y
     *
     */
    public void setCurrentPos(double x, double y){
        setX(x);
        setY(y);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }
}
