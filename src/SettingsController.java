public class SettingsController {
    private SettingsModel model;
    private SettingsView view;
    public SettingsController(){
        super();
        model = new SettingsModel();
        view = new SettingsView(model.getStartBut(),model.getPreviewBut(), model.getSpeedSli(),model.getFramesSli());
        view.setSpeeds(model.setUpSpeed(view.getSpeeds()));

    }

    public SettingsView getView() {
        return view;
    }
}
