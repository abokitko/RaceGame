package classes;

import java.util.List;

public class Vector {
    private List<Point> pointList;
    private int vectorLength;       //the number of points
    private String material;
    private int vectorMaxSpeed;

    public Vector(List<Point> pointList, String material) {
        this.pointList = pointList;
        this.material = material;
        this.vectorLength = countVectorLength(pointList);
        this.vectorMaxSpeed = countVectorMaxSpeed(material);
    }

    int countVectorLength(List<Point> pointList){
        return pointList.size();
    }

    int countVectorMaxSpeed(String material){
        if (material == "ice")  return 1;
        if (material == "ground") return 2;
        if (material == "road") return 3;
        if (material == "highway") return 5;
        else return 0;
    }

    public String getMaterial() { return material; }
    public int getVectorLength() {
        return vectorLength;
    }
    public List<Point> getPointList() { return pointList; }
    public int getVectorMaxSpeed() {
        return vectorMaxSpeed;
    }
}
