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
        model = new ImageModel(readImage("./assets/yacht.jpg"));
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
            System.out.println("File tried");
            img = ImageIO.read(new File(file));
        } catch (IOException e) {
          System.out.println("Error: tried");
        }
        MediaTracker tracker = new MediaTracker (new Component () {});
        tracker.addImage(img, 0);
        try {
            tracker.waitForID (0);
        }
        catch(InterruptedException e) {}
        return img;
    }

    public ImageView getView(){
        return this.view;
    }

    public void showImage(){
      view.showImg();
    }

    public void actionPerformed(ActionEvent e){}
}
