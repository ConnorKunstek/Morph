import java.awt.*;

public class LineModel {

    public PointController getPoint1() {
        return point1;
    }

    public void setPoint1(PointController point1) {
        this.point1 = point1;
    }

    private PointController point1;

    public PointController getPoint2() {
        return point2;
    }

    public void setPoint2(PointController point2) {
        this.point2 = point2;
    }

    private PointController point2;

    public LineModel(PointController point1, PointController point2){
        setPoint1(point1);
        setPoint2(point2);
    }
}
