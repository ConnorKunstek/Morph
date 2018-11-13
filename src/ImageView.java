import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;


public class ImageView extends JPanel {
    private int width, height;
    public BufferedImage view;
    private BufferedImage proccessImg;
    public ImageView(){
        super();
    }
    public ImageView(BufferedImage img){
        if(img == null){
            view = null;
        }
        this.view = img;
        this.width = img.getWidth();
        this.height = img.getHeight();
        proccessImg = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        this.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
    }

    public void setNewImage(BufferedImage img){
        if(img == null) return;
        this.view = img;
        this.width = img.getWidth();
        this.height = img.getHeight();
        this.proccessImg = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        this.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        this.repaint();
    }

    public void showImg(){
      this.repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D canvas = (Graphics2D) g;
        boolean x = false;
        while(!x){
          x = canvas.drawImage(view, 0, 0, this);
        }

    }
}
