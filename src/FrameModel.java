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

/**
 * @Class: FrameModel()
 * @Description: Holds Frame data
 */

public class FrameModel{

    public final static int ONE_SECOND = 1000;

    private GridController gridPreController;
    private GridController gridPostController;
    private ImageController imageController;
    private SettingsController settingsController;

    private int dim, framesPerSec, secondsCounter, frameCounter;

    private boolean previewing, previewed;

    private Timer timer, timer2;

    /**
     * @Function: constructor()
     * @Parameters: mesh dimmension Type: int
     * @Returns: N/A
     * @Description: Creates the pre and post grids
     *
     *
     * @TODO add pre and post images (Part 2)
     *
     */

    public FrameModel(int dim){
        gridPostController = new GridController(dim);
        gridPreController = new GridController(dim);
        //imageController = new ImageController();
        settingsController = new SettingsController(true);
    }

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public GridController getGridPreContoller() {return gridPreController;}

    public GridController getGridPostContoller() {
        return gridPostController;
    }

    public SettingsController getSettingsController() {
        return settingsController;
    }

    public ImageController getImageController() {
        return imageController;
    }

    public int getDim() {return dim; }
    public void setDim(int dim) { this.dim = dim; }

    public int getFrameCounter() { return frameCounter; }
    public void setFrameCounter(int frameCounter) { this.frameCounter = frameCounter; }

    public int getFramesPerSec() { return framesPerSec; }
    public void setFramesPerSec(int framesPerSec) { this.framesPerSec = framesPerSec; }

    public int getSecondsCounter() { return secondsCounter; }
    public void setSecondsCounter(int secondsCounter) { this.secondsCounter = secondsCounter; }

    public Timer getTimer() { return timer; }
    public void setTimer(Timer timer) { this.timer = timer; }

    public Timer getTimer2() { return timer2; }
    public void setTimer2(Timer timer2) { this.timer2 = timer2; }

    public boolean isPreviewed() { return previewed; }
    public void setPreviewed(boolean previewed) { this.previewed = previewed; }

    public boolean isPreviewing() { return previewing; }
    public void setPreviewing(boolean previewing) { this.previewing = previewing; }

    public int getOneSec(){ return ONE_SECOND; }
}
