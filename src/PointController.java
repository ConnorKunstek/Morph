import javax.swing.*;
import java.awt.event.*;
import java.awt.Point;

public class PointController extends Point implements ActionListener {


    PointView view;
    PointModel model;
    private MouseMotionAdapter MMA = new MouseMotionAdapter() {
        public void mouseDragged(MouseEvent e) {
            System.out.println("Mouse Event Dragged:");
            System.out.println(e.getPoint());
            Point t = e.getPoint();
            model.setX((int)t.getX());
            model.setY((int)t.getY());
            view.repaint( );
        }
    };

    private MouseListener ML = new MouseAdapter() {
        public void mouseReleased(MouseEvent e) {
            System.out.println("Mouse Event Released:");
            System.out.println(e.getSource());
        }
    };

    public PointModel getModel() {
        return model;
    }

    public PointView getView() {
        return view;
    }


    public PointController(int row, int col, int dim){
        super();
        model = new PointModel(row, col, dim, 50);

        //view = new PointView(row * 50, col * 50, model.getRightBound(), model.getBottomBound(), MMA, ML);
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
        view = new PointView(this, model.getRight(), model.getBottom(), model.getDiag(), MMA, ML);
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

    public void actionPerformed(ActionEvent e){
        System.out.println("THIS IS E: " + e);
    }
}
