package classes.Route;
import java.util.List;

public class Route {
    private List<Vector> vectorList;
    private int routeLengthPoints;
    private int routeLengthVectors;

    public Route(List<Vector> vectorList) {
        this.vectorList = vectorList;
        this.routeLengthPoints = getRouteLengthP();
        this.routeLengthVectors = vectorList.size();
    }

    /**
     * Count length of the route in points
     * @return int (sum of the points)
     */
    public int getRouteLengthP() {
        int sum = 0;
        for (int i = 0; i < vectorList.size(); i++){
            sum += vectorList.get(i).getVectorLength();
        }
        return sum;
    }
    public int getRouteLengthV() {
        return routeLengthVectors;
    }
    public List<Vector> getVectorList() { return vectorList; }
}
