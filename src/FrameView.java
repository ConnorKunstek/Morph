
import javax.swing.*;
import java.awt.*;

public class FrameView extends JFrame {

    public FrameView(GridView grid, ImageView image){

        super("Morph");

        Container c = getContentPane();

        c.add(grid);
        c.add(image);

        this.setSize(1000, 1000);
        this.setVisible(true);
    }

    public FrameView(GridView grid){

        super("Morph");

        Container c = getContentPane();

        c.add(grid);

        this.setSize(1000, 1000);
        this.setVisible(true);
    }

    public FrameView(ImageView image){

        super("Morph");

        Container c = getContentPane();

        c.add(image);

        this.setSize(1000, 1000);
        this.setVisible(true);
    }

}
