package classes;
import java.lang.reflect.InvocationTargetException;


public class TransportFactory {

    public static Transport createTransport(String name) {
        System.out.println();
        try {
            Class<?> transportClass = Class.forName("classes."+name);

            //args in Transport Constructor
            Engine eng2 = new Engine("aloha", 6);
            Wheels wheels2 = new Wheels("fasters", 0.6);
            String name2 = "example";


            //create
            Object[] args = {name2, eng2, wheels2};
            return (Transport) transportClass.getConstructor(String.class, Engine.class, Wheels.class).newInstance(args);
        }   catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}


