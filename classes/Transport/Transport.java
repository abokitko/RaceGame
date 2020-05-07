package classes.Transport;

import classes.Engine.Engine;
import classes.Route.Point;
import classes.Wheels.Wheels;

public class Transport {
    private String name;
    private Engine engine;
    private Wheels wheels;
    private int transportMaxSpeed;
    private int realSpeed;
    private Point currentPosition;

    public Transport(String name, Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
        this.transportMaxSpeed = countMaxSpeed(engine, wheels);
        this.name = name;
    }

    int countMaxSpeed(Engine engine, Wheels wheels){
        return (int) (engine.getEngineMaxSpeed() * (1 - wheels.getWheelCoeffFriction()));
    }

    //getters
    public Point getCurrentPosition() {
        return currentPosition;
    }
    public int getRealSpeed() { return realSpeed; }
    public int getTransportMaxSpeed() {
        return transportMaxSpeed;
    }
    public String getName() {
        return name;
    }
    public Engine getEngine() { return engine;}

    //setters
    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }
    public void setRealSpeed(int realSpeed) { this.realSpeed = realSpeed; }
    public void setName(String name) { this.name = name; }
    public void setEngine(Engine engine) { this.engine = engine;}
    public void setWheels(Wheels wheels) { this.wheels = wheels; }
    public void setTransportMaxSpeed(int transportMaxSpeed) { this.transportMaxSpeed = transportMaxSpeed; }
}
