

//act as overall program driver

/**
 * proposed file/class hierarchy
 *
 * Morph->Frame->Grid->Point->Dot
 *                   ->GridLine ->Line
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
}
