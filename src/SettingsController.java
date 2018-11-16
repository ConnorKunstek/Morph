import java.awt.*;

public class SettingsController {
    private SettingsModel model;
    private SettingsView view;
    public SettingsController(boolean previewFlag){
        super();
        model = new SettingsModel(previewFlag);
        view = new SettingsView(model.getStartBut(),model.getPreviewBut(), model.getSpeedSli(),model.getFramesSli());
        view.setSpeeds(model.setUpSpeed(view.getSpeeds()));

    }

    public SettingsView getView() {
        return view;
    }

    public SettingsModel getModel() {
        return model;
    }
}
