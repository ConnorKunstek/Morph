import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Point implements ActionListener {

    public Point(){
        PointModel model = new PointModel();
        PointView view = new PointView();
    }


    public void actionPerformed(ActionEvent e){}
}
