import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import java.util.Hashtable;

public class SettingsModel {

    private JButton previewBut, startBut;
    private JSlider framesSli, secondsSli;
    private JLabel framesLabel, secondsLabel, totalFramesLabel, empty;
    private int seconds, frames, frameNumber, totalFrames;
    private boolean previewFlag;

    public SettingsModel(boolean previewFlag){
        init();
        setPreviewFlag(previewFlag);
    }

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
        totalFrames = seconds * frames;

        secondsLabel = new JLabel("Seconds: " + seconds);
        framesLabel = new JLabel("Frames per second: " + frames);
        totalFramesLabel = new JLabel("Total Frames: " + totalFrames);
        empty = new JLabel();

    }

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

    public void setTotalFramesLabel(JLabel totalFramesLabel) {this.totalFramesLabel = totalFramesLabel; }
    public JLabel getTotalFramesLabel() {  return totalFramesLabel;  }

    public int getTotalFrames() {  return totalFrames; }
    public void setTotalFrames(int totalFrames) { this.totalFrames = totalFrames;  }

    public JLabel getEmpty() {return empty; }
}