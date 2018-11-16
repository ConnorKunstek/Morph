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

public class GridModel {

    private int dim;
    private PointController[][] points;

    public GridModel(int dim){

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

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public PointController[][] getPoints() {return points; }
    public PointController getPoint(int row, int col){
        return points[row][col];
    }

}
