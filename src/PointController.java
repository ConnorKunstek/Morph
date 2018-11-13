import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointController implements ActionListener {

    public PointModel getModel() {
        return model;
    }

    PointModel model;

    public PointView getView() {
        return view;
    }

    PointView view;

    public PointController(int row, int col, int dim){
        model = new PointModel(row, col, dim);
        view = new PointView();
    }

    public void setTop(PointController point){
        getModel().setTop(point);
    }
    public void setLeft(PointController point){
        getModel().setLeft(point);
    }
    public void setDiag(PointController point){
        getModel().setDiag(point);
    }


    public void actionPerformed(ActionEvent e){}
}
