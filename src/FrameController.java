import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class FrameController implements ActionListener {

    /**
     * @Function: constructor()
     * @Parameters: dimmension of grid Type: int
     * @Returns: N/A
     * @Description: Creates FrameModel and FrameView
     *
     */

    public FrameController(int gridDimmesion){

        FrameModel model = new FrameModel(gridDimmesion);
        FrameView view = new FrameView(
                model.getGridPreContoller().getView(),
                model.getGridPostContoller().getView(),
                model.getSettingsController().getView()
        );

//        FrameView view = new FrameView(model.getGrid().getView(), model.getImage().getView());
//        FrameView view = new FrameView(model.getGrid().getView());
//        FrameView view = new FrameView(model.getImageController().getView());

    }

    public void actionPerformed(ActionEvent e){}
}
