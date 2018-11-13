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
        //FrameView view = new FrameView(model.getGrid().getView());
        FrameView view = new FrameView(model.getImage().getView());
    }

    public void actionPerformed(ActionEvent e){}
}
