import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

public class SettingsController extends JPanel{

    private JButton startBut, resetBut;
    private JSlider framesSli, secondsSli, preSlider, postSlider;
    private JLabel framesLabel, secondsLabel, totalFramesLabel, empty;
    private int seconds, frames, totalFrames;
    private double preInt, postInt;


    /**
     * @Class:          SettingsController()
     * @Description:    Creates settings panel at bottom of frame
     *                  Used for changing intensities, frames, seconds, and starting
     */

    public SettingsController(){
        super();

        //start button
        setStartBut(new JButton("Start"));
        setResetBut(new JButton("Reset"));

        //frames slider
        setFramesSli(new JSlider(SwingConstants.HORIZONTAL,30,120,30));
        getFramesSli().setMinorTickSpacing(10);
        getFramesSli().setMajorTickSpacing(30);
        getFramesSli().setPaintTicks(true);
        getFramesSli().setPaintLabels(true);
        getFramesSli().setSnapToTicks(true);

        //seconds slider
        setSecondsSli(new JSlider(SwingConstants.HORIZONTAL,0,5,2));
        getSecondsSli().setMajorTickSpacing(1);
        getSecondsSli().setPaintTicks(true);
        getSecondsSli().setPaintLabels(true);
        getSecondsSli().setSnapToTicks(true);

        //values
        setSeconds(getSecondsSli().getValue());  // seconds = 2
        setFrames(getFramesSli().getValue()); // frames = 30
        setTotalFrames(getFrames() / getSeconds());

        //labels
        setSecondsLabel(new JLabel("Seconds: " + getSeconds()));
        setFramesLabel(new JLabel("Frames: " + getFrames()));
        setTotalFramesLabel(new JLabel("Frames Per Second (FPS): " + getTotalFrames()));

        //slider listener
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

        //slider listener
        getFramesSli().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                getFramesLabel().setText("Frames: " + getFramesSli().getValue());
                setFrames(getFramesSli().getValue());
                setTotalFrames(getFrames() / getSeconds());
                getTotalFramesLabel().setText("Frames Per Second (FPS): " + getTotalFrames());
            }
        });

        //in order to allow JSlider ticks to disple decimals
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();

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

        //Pre image intensity slider
        setPreSlider(new JSlider(SwingConstants.HORIZONTAL,5,15,10));
        getPreSlider().setLabelTable(labelTable);
        getPreSlider().setMajorTickSpacing(1);
        getPreSlider().setPaintTicks(true);
        getPreSlider().setPaintLabels(true);
        getPreSlider().setSnapToTicks(true);
        setPreInt(getPreSlider().getValue());

        //post image intensity slider
        setPostSlider(new JSlider(SwingConstants.HORIZONTAL,5,15,10));
        getPostSlider().setLabelTable(labelTable);
        getPostSlider().setMajorTickSpacing(1);
        getPostSlider().setPaintTicks(true);
        getPostSlider().setPaintLabels(true);
        getPostSlider().setSnapToTicks(true);
        setPostInt(getPostSlider().getValue());

        //layout
        this.setLayout(new GridLayout(3,3, 20,10));

        this.add(getPreSlider());
        this.add(getResetBut());
        this.add(getPostSlider());

        this.add(getFramesLabel());
        this.add(getTotalFramesLabel());
        this.add(getSecondsLabel());

        this.add(getFramesSli());
        this.add(getStartBut());
        this.add(getSecondsSli());

        this.setSize(1000, 200);
        this.setVisible(true);

    }

    ////////////////////////////////////////////GETTERS AND SETTERS////////////////////////////////////////////////////

    public JButton getStartBut() { return startBut; }
    public void setStartBut(JButton startBut) { this.startBut = startBut; }

    public JSlider getFramesSli() {return framesSli; }
    public void setFramesSli(JSlider framesSli) { this.framesSli = framesSli; }

    public JSlider getSecondsSli() { return secondsSli; }
    public void setSecondsSli(JSlider secondsSli) { this.secondsSli = secondsSli; }

    public JLabel getFramesLabel() {return framesLabel; }
    public void setFramesLabel(JLabel framesLabel) { this.framesLabel = framesLabel; }

    public JLabel getSecondsLabel() { return secondsLabel; }
    public void setSecondsLabel(JLabel secondsLabel) { this.secondsLabel = secondsLabel; }

    public JLabel getTotalFramesLabel() { return totalFramesLabel; }
    public void setTotalFramesLabel(JLabel totalFramesLabel) { this.totalFramesLabel = totalFramesLabel; }

    public int getSeconds() { return seconds; }
    public void setSeconds(int seconds) { this.seconds = seconds; }

    public int getFrames() { return frames; }
    public void setFrames(int frames) { this.frames = frames; }

    public int getTotalFrames() { return totalFrames; }
    public void setTotalFrames(int totalFrames) { this.totalFrames = totalFrames; }

    public JSlider getPreSlider() { return preSlider; }
    public void setPreSlider(JSlider preSlider) { this.preSlider = preSlider; }

    public JSlider getPostSlider() { return postSlider; }
    public void setPostSlider(JSlider postSlider) { this.postSlider = postSlider; }

    public double getPreInt() { return preInt; }
    public void setPreInt(double preInt) { this.preInt = preInt; }

    public double getPostInt() { return postInt; }
    public void setPostInt(double postInt) { this.postInt = postInt; }

    public JButton getResetBut() { return resetBut;}
    public void setResetBut(JButton resetBut) { this.resetBut = resetBut;}
}
