package classes;

import java.util.List;

public class Route {
    private List<Vector> vectorList;
    private int routeLengthP;
    private int routeLengthV;

    public Route(List<Vector> vectorList) {
        this.vectorList = vectorList;
        this.routeLengthP = countRouteLengthP(vectorList);
        this.routeLengthV = vectorList.size();
    }

    int countRouteLengthP(List<Vector> vectorList){
        int sum = 0;
        for (int i = 0; i < vectorList.size(); i++){
            sum += vectorList.get(i).getVectorLength();
        }
        return sum;
    }

    public int getRouteLengthP() {
        return routeLengthP;
    }
    public int getRouteLengthV() {
        return routeLengthV;
    }
    public List<Vector> getVectorList() { return vectorList; }
}
