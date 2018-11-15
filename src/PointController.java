import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;

<<<<<<< HEAD
public class PointController implements ActionListener {
    PointView view;
    PointModel model;

=======
public class PointController extends Point implements ActionListener {
>>>>>>> 26f9ffb06b0cba7c4564b750361e860685115b6c

    public PointModel getModel() {
        return model;
    }

    public PointView getView() {
        return view;
    }

    public PointController(int row, int col, int dim){
        super();
        model = new PointModel(row, col, dim, 100);
        view = new PointView(row * 100, col * 100, model.getRightBound(), model.getBottomBound());
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

<<<<<<< HEAD

    public void actionPerformed(ActionEvent e){
        System.out.println("THIS IS E: " + e);
    }
=======
    public void actionPerformed(ActionEvent e){}
>>>>>>> 26f9ffb06b0cba7c4564b750361e860685115b6c
}
