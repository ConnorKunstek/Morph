public class SettingsController {
    private SettingsModel model;
    private SettingsView view;
    public SettingsController(){
        model = new SettingsModel();
        view = new SettingsView(model.getStartBut(),model.getPreviewBut(), model.getSpeedSli(),model.getFramesSli());

    }
}
