import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingsController {
    private SettingsModel model;
    private SettingsView view;
    /**
     * @Function: constructor()
     * @Parameters: previewFlag Type: boolean
     * @Returns: N/A
     * @Description: creates Controller
     *
     */
    public SettingsController(boolean previewFlag){
        super();
        model = new SettingsModel(previewFlag);
        view = new SettingsView(
                model.getStartBut(),
                model.getPreviewBut(),
                model.getSecondsSli(),
                model.getFramesSli(),
                model.getSecondsLabel(),
                model.getFramesLabel(),
                model.getFramesPerSecLabel(),
                model.getEmpty());

        model.getSecondsSli().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                model.setSeconds(model.getSecondsSli().getValue());
                model.getSecondsLabel().setText("Seconds: " + model.getSeconds());
                model.setFramesPerSec(model.getFrames() / model.getSeconds());
                model.getFramesPerSecLabel().setText("Frames per sec: " + model.getFramesPerSec());
            }
        });

        model.getFramesSli().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                model.getFramesLabel().setText("Frames per Second: " + model.getFramesSli().getValue());
                model.setFrames(model.getFramesSli().getValue());
                model.setFramesPerSec(model.getFrames() / model.getSeconds());
                model.getFramesPerSecLabel().setText("Frames per sec: " + model.getFramesPerSec());
            }
        });
    }

    ////////////////////////////////GETTERS AND SETTER//////////////////////////////////////////////////////////////////

    public SettingsView getView() {
        return view;
    }

    public SettingsModel getModel() {
        return model;
    }
}
