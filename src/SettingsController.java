import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingsController extends JPanel{

    private JButton previewBut, startBut;
    private JSlider framesSli, secondsSli;
    private JLabel framesLabel, secondsLabel, totalFramesLabel, empty;
    private int seconds, frames, frameNumber, totalFrames;
    private boolean previewFlag;


    public SettingsController(boolean previewFlag){
        super();

        setPreviewBut(new JButton("Preview"));
        setStartBut(new JButton("Start"));
        setFramesSli(new JSlider(SwingConstants.HORIZONTAL,30,120,30));
        getFramesSli().setMinorTickSpacing(10);
        getFramesSli().setMajorTickSpacing(30);
        getFramesSli().setPaintTicks(true);
        getFramesSli().setPaintLabels(true);
        getFramesSli().setSnapToTicks(true);
        setSecondsSli(new JSlider(SwingConstants.HORIZONTAL,0,5,2));
        getSecondsSli().setMajorTickSpacing(1);
        getSecondsSli().setPaintTicks(true);
        getSecondsSli().setPaintLabels(true);
        getSecondsSli().setSnapToTicks(true);
        setSeconds(getSecondsSli().getValue());  // seconds = 2
        setFrames(getFramesSli().getValue()); // fps = 30
        setTotalFrames(getSeconds() * getFrames());

        setSecondsLabel(new JLabel("Seconds: " + getSeconds()));
        setFramesLabel(new JLabel("Frames per second: " + getFrames()));
        setTotalFramesLabel(new JLabel("Total Frames: " + getTotalFrames()));
        setEmpty(new JLabel());


        getSecondsSli().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setSeconds(getSecondsSli().getValue());
                getSecondsLabel().setText("Seconds: " + getSeconds());
                setTotalFrames(getFrames() * getSeconds());
                getTotalFramesLabel().setText("Total Frames: " + getTotalFrames());
            }
        });

        getFramesSli().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                getFramesLabel().setText("Frames per Second: " + getFramesSli().getValue());
                setFrames(getFramesSli().getValue());
                setTotalFrames(getFrames() * getSeconds());
                getTotalFramesLabel().setText("Total Frames: " + getTotalFrames());
            }
        });


        this.setLayout(new GridLayout(2,4, 20,10));

        this.add(framesLabel);
        this.add(totalFramesLabel);
        this.add(secondsLabel);
        this.add(previewBut);

        this.add(framesSli);
        this.add(empty);
        this.add(secondsSli);
        this.add(startBut);

        this.setSize(1000, 200);
        this.setVisible(true);

    }

    public JButton getPreviewBut() {
        return previewBut;
    }

    public void setPreviewBut(JButton previewBut) {
        this.previewBut = previewBut;
    }

    public JButton getStartBut() {
        return startBut;
    }

    public void setStartBut(JButton startBut) {
        this.startBut = startBut;
    }

    public JSlider getFramesSli() {
        return framesSli;
    }

    public void setFramesSli(JSlider framesSli) {
        this.framesSli = framesSli;
    }

    public JSlider getSecondsSli() {
        return secondsSli;
    }

    public void setSecondsSli(JSlider secondsSli) {
        this.secondsSli = secondsSli;
    }

    public JLabel getFramesLabel() {
        return framesLabel;
    }

    public void setFramesLabel(JLabel framesLabel) {
        this.framesLabel = framesLabel;
    }

    public JLabel getSecondsLabel() {
        return secondsLabel;
    }

    public void setSecondsLabel(JLabel secondsLabel) {
        this.secondsLabel = secondsLabel;
    }

    public JLabel getTotalFramesLabel() {
        return totalFramesLabel;
    }

    public void setTotalFramesLabel(JLabel totalFramesLabel) {
        this.totalFramesLabel = totalFramesLabel;
    }

    public JLabel getEmpty() {
        return empty;
    }

    public void setEmpty(JLabel empty) {
        this.empty = empty;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public int getTotalFrames() {
        return totalFrames;
    }

    public void setTotalFrames(int totalFrames) {
        this.totalFrames = totalFrames;
    }

    public boolean isPreviewFlag() {
        return previewFlag;
    }

    public void setPreviewFlag(boolean previewFlag) {
        this.previewFlag = previewFlag;
    }
}
