import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingsController {
    private SettingsModel model;
    private SettingsView view;
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
                model.getTotalFramesLabel(),
                model.getEmpty());

        model.getSecondsSli().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                model.setSeconds(model.getSecondsSli().getValue());
                model.getSecondsLabel().setText("Seconds: " + model.getSeconds());
                model.setTotalFrames(model.getFrames() * model.getSeconds());
                model.getTotalFramesLabel().setText("Total Frames: " + model.getTotalFrames());
            }
        });

        model.getFramesSli().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                model.getFramesLabel().setText("Frames per Second: " + model.getFramesSli().getValue());
                model.setFrames(model.getFramesSli().getValue());
                model.setTotalFrames(model.getFrames() * model.getSeconds());
                model.getTotalFramesLabel().setText("Total Frames: " + model.getTotalFrames());
            }
        });
    }

    public SettingsView getView() {
        return view;
    }

    public SettingsModel getModel() {
        return model;
    }
}
