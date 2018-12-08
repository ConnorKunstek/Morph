import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.HashMap;
import java.util.Hashtable;

public class SettingsController extends JPanel{

    private JButton previewBut, startBut;
    private JSlider framesSli, secondsSli, preSlider, postSlider;
    private JLabel framesLabel, secondsLabel, totalFramesLabel, empty1, empty2, empty3;
    private int seconds, frames, frameNumber, totalFrames;
    private double preInt, postInt;
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
        setFrames(getFramesSli().getValue()); // frames = 30
        setTotalFrames(getFrames() / getSeconds());

        setSecondsLabel(new JLabel("Seconds: " + getSeconds()));
        setFramesLabel(new JLabel("Frames: " + getFrames()));
        setTotalFramesLabel(new JLabel("Frames Per Second (FPS): " + getTotalFrames()));
        setEmpty(new JLabel());


        getSecondsSli().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setSeconds(getSecondsSli().getValue());
                getSecondsLabel().setText("Seconds: " + getSeconds());
                if(getSeconds() == 0){
                    setTotalFrames(0);
                }else {
                    setTotalFrames(getFrames() / getSeconds());
                }
                getTotalFramesLabel().setText("Frames Per Second (FPS): " + getTotalFrames());
            }
        });

        getFramesSli().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                getFramesLabel().setText("Frames: " + getFramesSli().getValue());
                setFrames(getFramesSli().getValue());
                setTotalFrames(getFrames() / getSeconds());
                getTotalFramesLabel().setText("Frames Per Second (FPS): " + getTotalFrames());
            }
        });

        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();

        labelTable.put(5, new JLabel("0.5"));
        labelTable.put(6, new JLabel("0.6"));
        labelTable.put(7, new JLabel("0.7"));
        labelTable.put(8, new JLabel("0.8"));
        labelTable.put(9, new JLabel("0.9"));
        labelTable.put(10, new JLabel("1.0"));
        labelTable.put(11, new JLabel("1.1"));
        labelTable.put(12, new JLabel("1.2"));
        labelTable.put(13, new JLabel("1.3"));
        labelTable.put(14, new JLabel("1.4"));
        labelTable.put(15, new JLabel("1.5"));

        setPreSlider(new JSlider(SwingConstants.HORIZONTAL,5,15,10));
        getPreSlider().setLabelTable(labelTable);
        getPreSlider().setMajorTickSpacing(1);
        getPreSlider().setPaintTicks(true);
        getPreSlider().setPaintLabels(true);
        getPreSlider().setSnapToTicks(true);
        setPreInt(getPreSlider().getValue());

        setPostSlider(new JSlider(SwingConstants.HORIZONTAL,5,15,10));
        getPostSlider().setLabelTable(labelTable);
        getPostSlider().setMajorTickSpacing(1);
        getPostSlider().setPaintTicks(true);
        getPostSlider().setPaintLabels(true);
        getPostSlider().setSnapToTicks(true);
        setPostInt(getPostSlider().getValue());

        this.setLayout(new GridLayout(3,3, 20,10));

        this.add(getPreSlider());
        this.add(previewBut);
        this.add(getPostSlider());

        this.add(framesLabel);
        this.add(totalFramesLabel);
        this.add(secondsLabel);

        this.add(framesSli);
        this.add(startBut);
        this.add(secondsSli);


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

    public void setEmpty(JLabel empty) {
        this.empty1 = empty;
        this.empty2 = new JLabel();
        this.empty3 = new JLabel();
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

    public JSlider getPreSlider() {
        return preSlider;
    }

    public void setPreSlider(JSlider preSlider) {
        this.preSlider = preSlider;
    }

    public JSlider getPostSlider() {
        return postSlider;
    }

    public void setPostSlider(JSlider postSlider) {
        this.postSlider = postSlider;
    }

    public double getPreInt() {
        return preInt;
    }

    public void setPreInt(double preInt) {
        this.preInt = preInt;
    }

    public double getPostInt() {
        return postInt;
    }

    public void setPostInt(double postInt) {
        this.postInt = postInt;
    }
}
