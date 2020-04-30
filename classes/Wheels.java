package classes;

public class Wheels {
    private String wheelsName;
    private double wheelCoeffFriction;

    public Wheels(String wheelsName, double wheelCoeffFriction) {
        this.wheelsName = wheelsName;
        this.wheelCoeffFriction = wheelCoeffFriction;
    }

    public double getWheelCoeffFriction() {
        return wheelCoeffFriction;
    }
}
