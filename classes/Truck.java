package classes;

public class Truck extends Transport{
    private int weight;

    public Truck(String name, Engine engine, Wheels wheels) {
        super(name, engine, wheels);
    }
    public Truck(){}

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
