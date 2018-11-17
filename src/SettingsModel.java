import javax.swing.*;

public class SettingsModel {

    private JButton previewBut, startBut;
    private JSlider framesSli, secondsSli;
    private JLabel framesLabel, secondsLabel, framesPerSecLabel, empty;
    private int seconds, frames, frameNumber, framesPerSec;
    private boolean previewFlag;

    /**
     * @Function: constructor()
     * @Parameters:  previewFlag Type: Boolean
     * @Returns: N/A
     * @Description: creates model
     *
     */
    public SettingsModel(boolean previewFlag){
        init();
        setPreviewFlag(previewFlag);
    }
    /**
     * @Function: init()
     * @Parameters:  N/A
     * @Returns: N/A
     * @Description: sets up the buttons, sliders, and data inputs
     *
     */
    public void init(){
        previewBut = new JButton("Preview");
        startBut= new JButton("Start");
        framesSli = new JSlider(SwingConstants.HORIZONTAL,30,120,30);
        framesSli.setMinorTickSpacing(10);
        framesSli.setMajorTickSpacing(30);
        framesSli.setPaintTicks(true);
        framesSli.setPaintLabels(true);
        framesSli.setSnapToTicks(true);
        secondsSli = new JSlider(SwingConstants.HORIZONTAL,0,5,2);
        secondsSli.setMajorTickSpacing(1);
        secondsSli.setPaintTicks(true);
        secondsSli.setPaintLabels(true);
        secondsSli.setSnapToTicks(true);
        seconds = secondsSli.getValue();  // seconds = 2
        frames = framesSli.getValue(); // fps = 30
        framesPerSec = frames / seconds;

        secondsLabel = new JLabel("Seconds: " + seconds);
        framesLabel = new JLabel("Frames per second: " + frames);
        framesPerSecLabel = new JLabel("Frames Per Sec: " + framesPerSec);
        empty = new JLabel();

    }


    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public JSlider getSecondsSli() {
        return secondsSli;
    }
    public JSlider getFramesSli() {
        return framesSli;
    }

    public int getFrames() {
        return frames;
    }
    public int getSeconds() {
        return seconds;
    }

    public JButton getPreviewBut() {
        return previewBut;
    }
    public JButton getStartBut() {
        return startBut;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public boolean isPreviewFlag() { return previewFlag; }
    public void setPreviewFlag(boolean previewFlag) { this.previewFlag = previewFlag;  }

    public int getFrameNumber() { return frameNumber;  }
    public void incrementFrameNumber(){frameNumber++; }

    public JLabel getFramesLabel() {   return framesLabel;  }
    public JLabel getSecondsLabel() {  return secondsLabel;  }

    public void setFramesPerSecLabel(JLabel framesPerSecLabel) {this.framesPerSecLabel = framesPerSecLabel; }
    public JLabel getFramesPerSecLabel() {  return framesPerSecLabel;  }

    public int getFramesPerSec() {  return framesPerSec; }
    public void setFramesPerSec(int framesPerSec) { this.framesPerSec = framesPerSec;  }

    public JLabel getEmpty() {return empty; }
}