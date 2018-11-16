
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

import javax.swing.JPanel;
import java.awt.*;


/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class GridView extends JPanel {

    /**
     * @Function: constructor()
     * @Parameters: points, and dimension Type: array of arrays of pointControllers and int
     * @Returns: N/A
     * @Description:
     *
     */
    public GridView(PointController[][] points, int dim) {

        super();

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

//        this.setLayout(new FlowLayout());

//        this.setLayout(new GridLayout(dim, dim, 10, 10));

        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){

                c.weightx = 0.5;
                c.weighty = 0.5;
                c.gridy = row;
                c.gridx = col;
//                c.ipadx = 25;
//                c.ipady = 25;
                this.add(points[row][col].getView(), c);

//                this.add(points[row][col].getView());
            }
        }
        this.setPreferredSize(new Dimension(500, 500));
        this.setVisible(true);
    }

    public void testMouse(){ System.out.println("GridView Function Called"); }
}
