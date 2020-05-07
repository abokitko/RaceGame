package classes.Wheels;

public class demyseasonWheels extends Wheels{

    public double wearCoeff;
    public double wheelCoeffFriction;

    public demyseasonWheels(String wheelsName, double wheelCoeffFriction) {
        super(wheelsName, wheelCoeffFriction);
    }

    public double getWheelCoeffFriction(){
        return wearCoeff * wheelCoeffFriction;
    }
}
