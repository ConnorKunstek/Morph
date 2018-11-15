import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;



public class PointController extends Point implements ActionListener {

    PointView view;
    PointModel model;

    public PointModel getModel() {
        return model;
    }

    public PointView getView() {
        return view;
    }

    public PointController(int row, int col, int dim){
        super();
        model = new PointModel(row, col, dim, 50);
        view = new PointView(row * 50, col * 50, model.getRightBound(), model.getBottomBound());
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

    public void actionPerformed(ActionEvent e){
        System.out.println("THIS IS E: " + e);
    }
}
