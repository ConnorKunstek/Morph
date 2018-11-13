

//act as overall program driver

/**
 * proposed file/class hierarchy
 *
 * MVC:
 *   C      V     C      M      V
 * Morph->Frame->Grid->Point->Dot
 *                      M           V
 *                   ->GridLine->Line
 *                 V
 *             ->Image
 *
 * Morph creates Frame
 * Frame extends JFrame, holds image and grid
 * Image loads/saves image
 * Grid creates Points and GridLines
 * Point holds logic for each individual point (ei control point or not, neighbors)
 * Dot extends JComponent, holds image of dot for each point
 * GridLine holds logic for each line between each point
 * Line extends JComponent, creates actual line image
 *
 *
 */

public class Morph {

    public Morph(){
        Frame fcontroller = new Frame();
    }

    public static void main(String[] args) {
        Morph M = new Morph();
    }
}
