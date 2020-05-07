package classes.Transport;
import classes.Engine.Engine;
import classes.Transport.*;
import classes.Wheels.Wheels;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class TransportFactory {
    private Engine[] engineList;
    private Wheels[] wheelsList;

    public TransportFactory(Engine[] engineList, Wheels[] wheelsList) {
        this.engineList = engineList;
        this.wheelsList = wheelsList;
    }

    public Transport createTransport(String name) {
        System.out.println();
        try {
            Class<?> transportClass = Class.forName("classes.Transport." + name);

            //args in Transport Constructor
            Engine engine = engineList[(short)(Math.random()*engineList.length)];
            Wheels wheels = wheelsList[(short)(Math.random()*wheelsList.length)];
            String yourName = name;

            //create
            Object[] args = {yourName, engine, wheels};
            return (Transport) transportClass.getConstructor(String.class, Engine.class, Wheels.class).newInstance(args);
        }   catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException();
            }
    }

    public void setEngineList(Engine[] engineList) {
        this.engineList = engineList;
    }

    public void setWheelsList(Wheels[] wheelsList) {
        this.wheelsList = wheelsList;
    }
}


