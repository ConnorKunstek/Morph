import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import java.util.Hashtable;

public class SettingsModel {
    private JButton previewBut, startBut;
    private JSlider framesSli, speedSli;
    private int speed, frames;
    public SettingsModel(){
        init();
    }

    public void init(){
        previewBut = new JButton("Preview");
        startBut= new JButton("Start");
        framesSli = new JSlider(SwingConstants.HORIZONTAL,0,120,30);
        speedSli = new JSlider(SwingConstants.HORIZONTAL,0,5,2);
        speed = 2;  // seconds
        frames = 30;// fps
    }

    public JSlider setUpSpeed(JSlider s){
        s.setValue(2);
        s.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                speed = speedSli.getValue();
            }
        });
        Hashtable<Integer, JLabel> speedLabels = new Hashtable<>();
        speedLabels.put(0, new JLabel("0"));
        speedLabels.put(1000, new JLabel("Speed - secs"));
        speedLabels.put(2000, new JLabel("5"));
        s.setLabelTable(speedLabels);
        s.setPaintLabels(true);
        s.setMajorTickSpacing(1); // create tick every 10
        s.setPaintTicks(true); // paint ticks on slider
        return s;
    }

    public JSlider setUpFrames(JSlider f){
        f.setValue(30);
        f.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                frames = framesSli.getValue();
            }
        });
        Hashtable<Integer, JLabel> frameLabels = new Hashtable<>();
        frameLabels.put(0, new JLabel("0"));
        frameLabels.put(2000, new JLabel("30"));
        frameLabels.put(2000, new JLabel("60"));
        frameLabels.put(2000, new JLabel("90"));
        frameLabels.put(2000, new JLabel("120"));
        f.setLabelTable(frameLabels);
        f.setPaintLabels(true);
        f.setMajorTickSpacing(10); // create tick every 10
        f.setPaintTicks(true); // paint ticks on slider
        return f;
    }

    public JSlider getSpeedSli() {
        return speedSli;
    }

    public JSlider getFramesSli() {
        return framesSli;
    }

    public int getFrames() {
        return frames;
    }

    public int getSpeed() {
        return speed;
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

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}