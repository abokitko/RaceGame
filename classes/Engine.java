package classes;

public class Engine {
    private String engineName;
    private int engineMaxSpeed;

    public Engine(String engineName, int engineMaxSpeed) {
        this.engineName = engineName;
        this.engineMaxSpeed = engineMaxSpeed;
    }

    public int getEngineMaxSpeed() {
        return engineMaxSpeed;
    }
}
