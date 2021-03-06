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
 * Morph.java
 *          main Driver
 *          creates JFrame
 */

/**
 * @Class: Morph ()
 * @Description: Creates program
 */

public class Morph {

    /**
     * @Function: constructor()
     * @Parameters: None Type: N/a
     * @Returns: N/A
     * @Description: Creates FrameController with default grid dimension 10x10
     *
     */

    public Morph(){
        FrameController frame = new FrameController(10);
    }

    /**
     * @Function: constructor()
     * @Parameters: Custom Mesh dimmension Type: String (later casted to int)
     * @Returns: N/A
     * @Description: Takes custom mesh dimension and creates FrameController
     *
     */

    public Morph(String num){
        FrameController frame = new FrameController(Integer.parseInt(num));
    }

    /**
     * @Function: main ()
     * @Parameters: Command Line Type: N/a
     * @Returns: N/A
     * @Description: Run program,
     *               Mesh is 10x10 Grid by default
     *               Use first Command Line Arg to changes this number
     *
     */

    public static void main(String[] args) {

        if(args.length != 0) {
            Morph M = new Morph(args[0]);
        }else{
            Morph m = new Morph();
        }

    }
}
