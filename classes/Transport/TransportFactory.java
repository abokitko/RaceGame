package classes.Transport;
import classes.Engine.*;
import classes.Wheels.*;
import classes.Exceptions.*;

import java.lang.reflect.InvocationTargetException;


public class TransportFactory {
    private Engine[] engineList;
    private Wheels[] wheelsList;

    public TransportFactory(Engine[] engineList, Wheels[] wheelsList) {
        this.engineList = engineList;
        this.wheelsList = wheelsList;
    }

    /**
     * According to the name create new object of Name class with random engine
     * and wheels from engineList and wheelsList
     * @param name
     * @return object (Transport/heir of Transport)
     */
    public Transport createTransport(String name) throws NoSuchTransport, ObjectCreationException {
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
        }   catch (ClassNotFoundException | NoSuchMethodException  e) {
                throw new NoSuchTransport("There is no such transport");
            }
            catch( IllegalAccessException | InvocationTargetException | InstantiationException e){
                throw new ObjectCreationException("Check your inputs again, there are some creating problems");
        }
    }

    public void setEngineList(Engine[] engineList) {
        this.engineList = engineList;
    }

    public void setWheelsList(Wheels[] wheelsList) {
        this.wheelsList = wheelsList;
    }
}


