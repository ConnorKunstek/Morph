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

    private final int ONE_SECOND = 1000;

    private GridController gridPreController;
    private GridController gridPostController;
    private ImageController imageController;
    private SettingsController settingsController;

    Timer timer, timer2;
    int dim, frames, seconds, totalFrames, frameCounter, secondsCounter, framesPerSecond;

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
        setDim(dim);
        setFrames(30);
        setSeconds(2);
        gridPreController = new GridController(dim);
        gridPostController = new GridController(dim);
        //imageController = new ImageController();
        settingsController = new SettingsController(true);
    }

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public GridController getGridPreController() {return gridPreController;}

    public GridController getGridPostController() {
        return gridPostController;
    }

    public SettingsController getSettingsController() {
        return settingsController;
    }

    public ImageController getImageController() {
        return imageController;
    }

    public Timer getTimer2() {    return timer2; }
    public void setTimer2(Timer timer2) {   this.timer2 = timer2;  }

    public Timer getTimer() {   return timer; }
    public void setTimer(Timer timer) {   this.timer = timer;  }

    public int getFrames() {   return frames;  }
    public void setFrames(int frames) {   this.frames = frames; }

    public int getSeconds() {   return seconds; }
    public void setSeconds(int seconds) { this.seconds = seconds; }

    public int getTotalFrames() {  return totalFrames;  }
    public void setTotalFrames(int totalFrames) {  this.totalFrames = totalFrames; }

    public int getFrameCounter() {  return frameCounter;   }
    public void setFrameCounter(int frameCounter) {  this.frameCounter = frameCounter;   }

    public int getDim() {  return dim;  }
    public void setDim(int dim) {  this.dim = dim; }

    public int getSecondsCounter() {
        return secondsCounter;
    }

    public void setSecondsCounter(int secondsCounter) {
        this.secondsCounter = secondsCounter;
    }

    public int getOneSec() {
        return ONE_SECOND;
    }

    public int getFramesPerSecond() {
        return framesPerSecond;
    }

    public void setFramesPerSecond(int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
    }
}
