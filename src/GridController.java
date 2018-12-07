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

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Line2D;
import java.awt.event.*;
import javax.swing.Timer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @Class: GridController()
 * @Description: Creates grid for the application
 */

public class GridController extends JPanel{
    public BufferedImage image = null;
    public BufferedImage original = null;
    public BufferedImage image1 = null;
    public BufferedImage image2 = null;
    public PolygonController poly[][][];               //triangles
    public PointController p[][];                   //points
    private AlphaComposite Alpha1;
    private AlphaComposite Alpha2;

    //MorphTool
    private MorphTools MorptT;

    private Timer preview;
    private double tspeed;
    private double increments;
    private int frames;
    private int size;
    private int[][] neighbors ={
            {-1,-1},                //top-right
            {-1,0},                 //left
            {0,-1},                 //top
            {1,0},                  //right
            {0,1},                  //bottom
            {1,1}                   //bottom-right
    };

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public GridController(int s){
        int margin = 500/this.size;
        setGridSize(s);
        initializePoints(margin);
        initializePolygons();
    }

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public void setGridSize(int s){
        if(s == 5){
            this.setSize(s);
            super.setPreferredSize(new Dimension(400,400));
        }
        else if(s == 20){
            this.setSize(s);
            super.setPreferredSize(new Dimension(500,500));
        }
        else{
            this.setSize(10);
            super.setPreferredSize(new Dimension(450,450));
        }

    }

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public void initializePoints(int margin){
        p = new PointController[this.size][this.size];
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j <this.size; j++){
              int x = i * margin + 5;
              int y = j * margin + 5;
              p[i][j] = new PointController(x,y);
            }
        }
    }

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public void initializePolygons(){
        poly = new PolygonController[size - 1][size - 1][2]; //eliminates borders
        for(int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                poly[i][j][0] = new PolygonController(p[i][j],p[i+1][j],p[i+1][j+1]);
                poly[i][j][1] = new PolygonController(p[i][j],p[i][j+1],p[i+1][j+1]);

            }
        }
    }

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public void setSize(int size) {
        this.size = size;
    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(image1 != null && image2 != null){
            try{
                g2.setComposite(Alpha1);
                g2.setComposite(Alpha2);
                g2.drawImage(image1, 0,0,null);
                g2.drawImage(image2, 0,0,null);
            }catch( IllegalAccessError e){
                System.out.println("ERROR: " + e);
            }
        }
        else{

        }
    }
}
