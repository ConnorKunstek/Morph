import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */

public class FrameController implements ActionListener {

    public FrameController(int gridDimmesion){
        FrameModel model = new FrameModel(gridDimmesion);
        //FrameView view = new FrameView(model.getGrid().getView(), model.getImage().getView());
<<<<<<< HEAD
        //FrameView view = new FrameView(model.getGrid().getView());
//        FrameView view = new FrameView(model.getImageController().getView());
        FrameView view = new FrameView(model.getGridPreContoller().getView(), model.getGridPostContoller().getView());
=======
        FrameView view = new FrameView(model.getGridController().getView());
        //FrameView view = new FrameView(model.getImageController().getView());
>>>>>>> 26f9ffb06b0cba7c4564b750361e860685115b6c
    }

    public void actionPerformed(ActionEvent e){}
}
