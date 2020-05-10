package classes.Transport;

import classes.Engine.Engine;
import classes.Transport.Transport;
import classes.Wheels.Wheels;

public class Truck extends Transport {
    private int weight;

    public Truck(String name, Engine engine, Wheels wheels) {
        super(name, engine, wheels);
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
