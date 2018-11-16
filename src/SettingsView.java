import javax.swing.*;
import java.awt.*;

public class SettingsView extends JPanel {

    private JButton startbut, previewbut;
    private JSlider speeds, framess;
    public SettingsView( JButton start, JButton preview,JSlider speed, JSlider frames){
        this.setLayout(new GridLayout(4,1));
        this.init(start,preview,speed, frames);
        startbut = start;
        previewbut = preview;
        speeds = speed;
        framess = frames;
    }

    public void init(JButton start, JButton preview,JSlider speed, JSlider frames){

//        speed.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        frames.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        preview.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        start.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        this.add(speed);
        this.add(frames);
        this.add(preview);
        this.add(start);
        this.setVisible(true);
    }

    public JSlider getFrames() {
        return framess;
    }

    public JSlider getSpeeds() {
        return speeds;
    }

    public void setSpeeds(JSlider speeds) {
        this.speeds = speeds;
    }

    public void setFramess(JSlider framess) {
        this.framess = framess;
    }
}
