import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class ImageController implements ActionListener {

    private BufferedImage curImg = null;
    public ImageController(){

        ImageModel model = new ImageModel(readImage("assets/boat.gif"));
        this.curImg = model.getBuffImg();
        ImageView view = new ImageView(curImg);
    }

    public BufferedImage readImage(String file) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(file));
        } catch (IOException e) {}
        MediaTracker tracker = new MediaTracker (new Component () {});
        tracker.addImage(img, 0);
        try {
            tracker.waitForID (0);
        }
        catch(InterruptedException e) {}

        BufferedImage bim = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        return bim;
    }

    public void actionPerformed(ActionEvent e){}
}
