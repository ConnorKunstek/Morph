import javax.swing.*;
import java.awt.*;

public class SettingsView extends JPanel {
    /**
     * @Function: cosntructor()
     * @Parameters: start, preview Type: JButton | seconds, frames Type: JSlider | seconds, framesLabel, totalFramesLabel, empty Type: JLabel
     * @Returns: N/A
     * @Description: constructs Settings View
     *
     */
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

    }
    /**
     * @Function: cosntructor()
     * @Parameters: startBut, previewBut Type: JButton | secondsSli, framesSli Type: JSlider | secondsLabel, framesLabel, totalFramesLabel, empty Type: JLabel
     * @Returns: N/A
     * @Description: creates view for settings panel
     *
     */
    public void init(JButton startBut, JButton previewBut, JSlider secondsSli, JSlider framesSli, JLabel secondsLabel, JLabel framesLabel, JLabel totalFramesLabel, JLabel empty){


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
}