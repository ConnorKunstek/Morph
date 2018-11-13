import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

/*
 * @Function:       ()
 * @Parameters:     Type:
 * @Returns:        NA
 * @Description:
 */

public class ImageController implements ActionListener {

    ImageModel model;

    ImageView view;

    private BufferedImage curImg = null;
    public ImageController(){
        model = new ImageModel(readImage("assets/boat.gif"));
        view = new ImageView(model.getBuffImg());
    }

    /*
     * @Function:       readImage()
     * @Parameters:     Type:
     * @Returns:        NA
     * @Description:
     */
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

    public ImageView getView(){
        return this.view;
    }

    public void actionPerformed(ActionEvent e){}
}
