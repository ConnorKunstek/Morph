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

public class Frame implements ActionListener {

    public Frame(int gridDimmesion){
        FrameModel model = new FrameModel(gridDimmesion);
        //FrameView view = new FrameView(model.getGrid().getView(), model.getImage().getView());
        FrameView view = new FrameView(model.getGrid().getView());
    }

    public void actionPerformed(ActionEvent e){}
}
