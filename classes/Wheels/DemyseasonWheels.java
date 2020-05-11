package classes.Wheels;

public class DemyseasonWheels extends Wheels{

    public double wearCoeff;
    public double wheelCoeffFriction;

    public DemyseasonWheels(String wheelsName, double wheelCoeffFriction) {
        super(wheelsName, wheelCoeffFriction);
    }

    public double getWheelCoeffFriction(){
        return wearCoeff * wheelCoeffFriction;
    }
}
