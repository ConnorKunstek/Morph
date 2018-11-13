import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;


public class ImageView extends JPanel {
    private int width, height;
    private BufferedImage view;
    private BufferedImage filtered;
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
        filtered = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        this.setVisible(true);
        this.repaint();

    }

    public void paintComponent(Graphics g) {
        Graphics2D big = (Graphics2D) g;
        big.drawImage(view, 0, 0, this);
    }
}
