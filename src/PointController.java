import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;

public class PointController extends Point implements ActionListener {

    private PointView view;
    private PointModel model;

    public PointController(int row, int col, int dim){
        super();
        model = new PointModel(row, col, dim, 50);
        //view = new PointView(this, model.getRight(), model.getBottom(), model.getDiag());
    }

    public void setNeighbors(PointController[][] points){
        if(!model.getRightBound()){
            setRight(points[model.getRow()][model.getCol()+1]);
        }else{
            setRight(null);
        }
        if(!model.getBottomBound()){
            setBottom(points[model.getRow()+1][model.getCol()]);
        }else{
            setBottom(null);
        }
        if(!model.getRightBound() && !model.getBottomBound()){
            setDiag(points[model.getRow()+1][model.getCol()+1]);
        }else{
            setDiag(null);
        }
        view = new PointView(this, model.getRight(), model.getBottom(), model.getDiag());
    }

    public void setBottom(PointController point){
        getModel().setBottom(point);
    }

    public void setRight(PointController point){
        getModel().setLeft(point);
    }

    public void setDiag(PointController point){
        getModel().setDiag(point);
    }

    public PointModel getModel() {
        return model;
    }

    public PointView getView() {
        return view;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("THIS IS E: " + e);
    }
}
