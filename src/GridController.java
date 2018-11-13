
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */

public class GridController implements ActionListener {


    public GridView getView() {
        return view;
    }

    GridView view;

    public GridModel getModel() {
        return model;
    }

    GridModel model;

    public GridController(int dim){
        model = new GridModel(dim);

        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){
                if(row > 0){
                    model.getPoint(row, col).setTop(model.getPoint(row-1, col));
                }
                if(col > 0){
                    model.getPoint(row, col).setLeft(model.getPoint(row, col-1));
                }
                if((row -1 > -1) && (col + 1 < dim)){
                    model.getPoint(row, col).setDiag(model.getPoint(row-1, col+1));
                }
            }
        }

        view = new GridView(model.getPoints(), dim);

    }


    public void actionPerformed(ActionEvent e){}
}
