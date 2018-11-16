import javax.swing.*;
import java.awt.*;

public class SettingsView extends JPanel {

//    private JButton startbut, previewbut;
//    private JSlider seconds, frames;

    public SettingsView(
                JButton start,
                JButton preview,
                JSlider seconds,
                JSlider frames,
                JLabel secondsLabel,
                JLabel framesLabel,
                JLabel totalFramesLabel,
                JLabel empty){

        this.setLayout(new GridLayout(2,4, 20,10));

        this.init(start, preview, seconds, frames, secondsLabel, framesLabel, totalFramesLabel, empty);

//        startbut = start;
//        previewbut = preview;
//        this.seconds = seconds;
//        this.frames = frames;
    }

    public void init(JButton startBut, JButton previewBut, JSlider secondsSli, JSlider framesSli, JLabel secondsLabel, JLabel framesLabel, JLabel totalFramesLabel, JLabel empty){

//        speed.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        frames.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        preview.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        start.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

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

//    public JSlider getFrames() {
//        return frames;
//    }
//
//    public JSlider getSpeeds() {
//        return seconds;
//    }
//
//    public void setSpeeds(JSlider speeds) {
//        this.seconds = seconds;
//    }
//
//    public void setFrames(JSlider frames) {
//        this.frames = frames;
//    }
}
