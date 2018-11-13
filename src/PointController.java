import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Point implements ActionListener {

    public PointModel getModel() {
        return model;
    }

    PointModel model;

    public PointView getView() {
        return view;
    }

    PointView view;

    public Point(int row, int col, int dim){
        model = new PointModel(row, col, dim);
        view = new PointView();
    }

    public void setTop(Point point){
        getModel().setTop(point);
    }
    public void setLeft(Point point){
        getModel().setLeft(point);
    }
    public void setDiag(Point point){
        getModel().setDiag(point);
    }


    public void actionPerformed(ActionEvent e){}
}
