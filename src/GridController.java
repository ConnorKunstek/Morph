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
    public BufferedImage pre = null;
    public BufferedImage post = null;
    public PolygonController poly[][][];               //triangles
    public PointController p[][];                   //points
    private AlphaComposite Alpha1;
    private AlphaComposite Alpha2;

    //MorphTool
    private MorphTools MorptT;

    private Timer preview;
    private double tspeed = 5;
    private double increments;
    private int f = 0;
    private int size;
    private int[][] neighbors ={
            {-1,-1},
            {1,0},
            {1,1},
            {0,1},
            {-1,0},
            {-1,-1}
    };

    /*
     * @Function:       constructor()
     * @Parameters:     Type: int
     * @Returns:        NA
     * @Description:    constructor for GridController
     */
    public GridController(int s){
        setGridSize(s);
        int margin = 500/this.size;
        initializePoints(margin);
        initializePolygons();
    }

    /*
     * @Function:       setGridSize()
     * @Parameters:     Type: int
     * @Returns:        NA
     * @Description:    sets the preferred size of the grid based on the value passed
     */
    public void setGridSize(int s){
        if(s == 5){
            this.setSize(s);
            super.setPreferredSize(new Dimension(400,400));
        }
        else if(s == 20){
            this.setSize(s);
            super.setPreferredSize(new Dimension(475,500));
        }
        else{
            this.setSize(10);
            super.setPreferredSize(new Dimension(450,450));
        }

    }

    /*
     * @Function:       initializePoints()
     * @Parameters:     Type: int
     * @Returns:        NA
     * @Description:    creates the points across the grid
     */
    public void initializePoints(int margin){
        p = new PointController[this.size][this.size];
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
              int x = i * margin + 5;
              int y = j * margin + 5;
              p[i][j] = new PointController(x,y);
            }
        }
    }

    /*
     * @Function:       initilizePolygons()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:    creates private variables for polygons in the grid on startup
     */
    public void initializePolygons(){
        poly = new PolygonController[size - 1][size - 1][2]; //eliminates borders
        for(int i = 0; i < this.size - 1; i++) {
            for (int j = 0; j < this.size - 1; j++) {
                poly[i][j][0] = new PolygonController(p[i][j],p[i+1][j],p[i+1][j+1]);
                poly[i][j][1] = new PolygonController(p[i][j],p[i][j+1],p[i+1][j+1]);

            }
        }
    }

    /*
     * @Function:       updatePolygons()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:    updates the current polygons in the grids from changes by the user
     */
    public void updatePolygons(){
        for(int i = 0; i < this.size - 1 ; i++) {
            for (int j = 0; j < this.size - 1; j++) {
                poly[i][j][0] = new PolygonController(p[i][j],p[i+1][j],p[i+1][j+1]);
                poly[i][j][1] = new PolygonController(p[i][j],p[i][j+1],p[i+1][j+1]);
            }
        }
    }

    /*
     * @Function:       setSize()
     * @Parameters:     Type: int
     * @Returns:        NA
     * @Description:    sets the current size of the grid
     */
    public void setSize(int size) {
        this.size = size;
    }


    /*
     * @Function:       paints image()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:    paint component for drawing points and lines or images
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(pre != null && post != null){
            try{
                g2.setComposite(this.Alpha1);
                g2.setComposite(this.Alpha2);
                g2.drawImage(pre, 0,0,null);
                g2.drawImage(post, 0,0,null);
            }catch( IllegalAccessError e){
                System.out.println("ERROR: " + e);
            }
        }
        else {
            g.drawImage(image,0,0,null);
            for(int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    if(j+1 < this.size){
                        g2.setColor(Color.BLACK);
                        g2.draw(new Line2D.Double(
                                p[i][j].getModel().getX() + 5,
                                p[i][j].getModel().getY() + 5,
                                p[i][j+1].getModel().getX() + 5,
                                p[i][j+1].getModel().getY() + 5
                                )
                        );
                    }
                    if(i+1 < this.size){
                        g2.draw(new Line2D.Double(
                                        p[i][j].getModel().getX() + 5,
                                        p[i][j].getModel().getY() + 5,
                                        p[i+1][j].getModel().getX() + 5,
                                        p[i+1][j].getModel().getY() + 5
                                )
                        );
                    }
                    if((j+1 < this.size) && (i+1 < this.size)){
                        g2.draw(new Line2D.Double(
                                        p[i][j].getModel().getX() + 5,
                                        p[i][j].getModel().getY() + 5,
                                        p[i+1][j+1].getModel().getX() + 5,
                                        p[i+1][j+1].getModel().getY() + 5
                                )
                        );
                    }

                    g2.setColor(p[i][j].getModel().getColor());
                    g2.fill(p[i][j].getModel());
                }
            }
        }
    }

    /*
     * @Function:       ()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
    public int[] getCurrentPoint(Point cp){
        for(int i = 1; i < this.size - 1; i++){
            for(int j = 1; j < this.size - 1; j++){
                //checks if the point is inside the polygon
                if(p[i][j].getModel().contains(cp.x, cp.y)){
                   int[] clickedPoint = {i,j};
                   return clickedPoint;
                }
            }
        }
        return null;
    }

    /*
     * @Function:       animateSteo()
     * @Parameters:     Type:   PointController Array
     * @Returns:        NA
     * @Description:
     */
    public boolean animationStep(PointController bottom[][], PointController top[][], double time){
        boolean done = false;

        for(int i = 1; i < this.size - 1; i++){
            for(int j = 1; j < this.size - 1; j++){
                if(this.increments <= 1){
                    double nx;
                    double ny;

                    nx = bottom[i][j].getModel().getX() + (time * (top[i][j].getModel().getX() - bottom[i][j].getModel().getX()));
                    ny = bottom[i][j].getModel().getY() + (time * (top[i][j].getModel().getY() - bottom[i][j].getModel().getY()));
                    p[i][j].getModel().setCurrentPos(nx,ny);

                }
                else{
                    done = true;
                }
            }
        }
        return done;
    }
    /*
     * @Function:       createAnimation()
     * @Parameters:     Type: GridController (this)
     * @Returns:        NA
     * @Description:    Creates the warps to generate between each pre and post images from triangles generated on
     * the board
     */
    public void createAnimation(GridController preI, GridController postI, boolean export){
        ActionListener s = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(animationStep(preI.p, postI.p, increments)){
                    preview.start();
                }
                else{
                    increments += 0.006666667;
                    for(int i = 0; i < preI.poly.length; i++){
                        for(int j = 0; j < preI.poly[0].length; j++){
                            MorptT.warpTriangle(preI.image, pre, preI.poly[i][j][0].getModel(), poly[i][j][0].getModel(),null,null);
                            MorptT.warpTriangle(preI.image, pre, preI.poly[i][j][1].getModel(), poly[i][j][1].getModel(),null,null);
                            MorptT.warpTriangle(postI.image, post, postI.poly[i][j][0].getModel(), poly[i][j][0].getModel(),null,null);
                            MorptT.warpTriangle(postI.image, post, postI.poly[i][j][1].getModel(), poly[i][j][1].getModel(),null,null);

                            pre.createGraphics();
                            if(increments >= 1){
                                increments = 1;
                            }
                            Alpha1 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)(1-increments));

                            post.createGraphics();
                            Alpha2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)(increments));
                            if(increments == 1){
                                increments++;
                            }

                        }
                    }
                }

                repaint();
                f++;

                if(export){

                }
            }
        };

        preview = new Timer(33, s);
        preview.start();
    }

    /*
     * @Function:       setImages()
     * @Parameters:     Type: String
     * @Returns:        NA
     * @Description:    sets the pre and post images when loading custom paths
     */
    public void setImages(String imgPath1, String imgPath2){
        try{
            pre = ImageIO.read(new File(imgPath1));
            post = ImageIO.read(new File(imgPath2));
            super.removeAll();
            super.revalidate();
            super.repaint();
        }catch(IOException e){
            System.out.println("ERROR: Couldn't open file");
        }

    }

    /*
     * @Function:       getImage()
     * @Parameters:     Type: String
     * @Returns:        boolean
     * @Description:    checks and sets the current image buffer to chosen file
     */
    public boolean getImage(String imgPath){
        try {
            this.image = ImageIO.read(new File(imgPath));
            this.original = this.image;
            this.removeAll();
            this.revalidate();
            this.repaint();
            return true;
        }catch(IOException e){
            System.out.println("ERROR: Could not open file");
            return false;
        }
    }

    /*
     * @Function:       changeIntensity()
     * @Parameters:     Type: float
     * @Returns:        NA
     * @Description:    changees the intensity of the image
     */
    public void changeIntensity(float intensity){
        RescaleOp operator = new RescaleOp(intensity/10, 0, null);
        image = operator.filter(original,null);
        repaint();
    }

    /*
     * @Function:       resetGrid()
     * @Parameters:     NA
     * @Returns:        NA
     * @Description:    resets the grid
     */
    public void resetGrid(){
        int margin = 500/this.size;
        setGridSize(this.size);
        initializePoints(margin);
        initializePolygons();
    }

    /*
     * @Function:       createPolygon()
     * @Parameters:     Type: int
     * @Returns:        Type: Polygon
     * @Description:    Creates temporary border for current selected point
     */
    public Polygon createPolygon(int xVal, int yVal){
        List<Double> xpoints = new ArrayList<>();
        List<Double> ypoints = new ArrayList<>();

        for (int i = 0; i < neighbors.length; i++){
            xVal += neighbors[i][0];
            yVal += neighbors[i][1];
            if (!(xVal < 0 || xVal >= size || yVal < 0 || yVal >= size)) {
                xpoints.add(p[xVal][yVal].getModel().getX());
                ypoints.add(p[xVal][yVal].getModel().getY());
            }
        }

        int[][] holder = new int[2][xpoints.size()];
        holder[0] = new int[xpoints.size()];
        holder[1] = new int[ypoints.size()];

        for (int i = 0; i < holder[0].length; i++){
            holder[0][i] = xpoints.get(i).intValue();
            holder[1][i] = ypoints.get(i).intValue();
        }
        Polygon temp = new Polygon(holder[0], holder[1], holder[0].length);

        return temp;
    }

}