package classes.Route;
import java.util.List;

public class Route {
    private List<Vector> vectorList;
    private int routeLengthPoints;
    private int routeLengthVectors;

    public Route(List<Vector> vectorList) {
        this.vectorList = vectorList;
        this.routeLengthPoints = countRouteLengthP(vectorList);
        this.routeLengthVectors = vectorList.size();
    }

    /**
     * Count length of the route in points
     * @param vectorList
     * @return int (sum of the points)
     */
    int countRouteLengthP(List<Vector> vectorList){
        int sum = 0;
        for (int i = 0; i < vectorList.size(); i++){
            sum += vectorList.get(i).getVectorLength();
        }
        return sum;
    }

    public int getRouteLengthP() {
        return routeLengthPoints;
    }
    public int getRouteLengthV() {
        return routeLengthVectors;
    }
    public List<Vector> getVectorList() { return vectorList; }
}
