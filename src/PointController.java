import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;

public class PointController extends Point implements ActionListener {

    public PointModel getModel() {
        return model;
    }

    PointModel model;

    public PointView getView() {
        return view;
    }

    PointView view;

    public PointController(int row, int col, int dim){
        super();
        model = new PointModel(row, col, dim);
        view = new PointView(row * 100, col * 100);
    }

    public void setTop(PointController point){
        getModel().setTop(point);
        getModel().setTopLine(this, point);
    }
    public void setLeft(PointController point){
        getModel().setLeft(point);
        getModel().setLeftLine(this, point);
    }
    public void setDiag(PointController point){
        getModel().setDiag(point);
        getModel().setDiagLine(this, point);
    }

    public void actionPerformed(ActionEvent e){}
}
