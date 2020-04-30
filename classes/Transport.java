package classes;

public class Transport {
    private String name;
    private Engine engine;
    private Wheels wheels;
    private int transportMaxSpeed;
    private Point currentPosition;

    public Transport(String name, Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
        this.transportMaxSpeed = countMaxSpeed(engine, wheels);
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    int countMaxSpeed(Engine engine, Wheels wheels){
        return (int) (engine.getEngineMaxSpeed() * (1 - wheels.getWheelCoeffFriction()));
    }

    public int getTransportMaxSpeed() {
        return transportMaxSpeed;
    }

    public String getName() {
        return name;
    }
}
