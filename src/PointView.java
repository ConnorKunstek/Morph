import javax.swing.*;
import java.awt.*;

public class PointView extends JComponent {

    public PointView(){
        super();
        this.setVisible(true);
    }

    private Color color;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(getColor());
        g.fillOval(0, 0, 10, 10);
    }

    public void setColor(Color color){this.color = color; repaint();}
    public Color getColor(){return this.color;}
}
