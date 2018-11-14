

public class LineController {

    public LineView getView() {
        return view;
    }

    LineView view;

    public LineModel getModel() {
        return model;
    }

    LineModel model;

    public LineController(PointController point1, PointController point2){

        model = new LineModel(point1, point2);

        view = new LineView(model.getPoint1(), model.getPoint2());

    }
}
