package classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class TransportFactory {

    public static Transport createTransport(String transName) throws Exception {
        Class transClass = Class.forName("classes." + transName);
        Constructor constructor = transClass.getConstructor();
        Object object = constructor.newInstance();  //create object in chosen Class
        Method[] methods = transClass.getMethods(); //all public methods in Class

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < methods.length; i++) {

            if (methods[i].getName().contains("set")) {     // find setters

                System.out.print("Enter " + methods[i].getName().substring(3, methods[i].getName().length()) + " ");

                Parameter[] parameters = methods[i].getParameters();
                switch (parameters[0].getType().toString()) {       //setter's length is always 1
                    case "int":
                        int intValue = scan.nextInt();
                        methods[i].invoke(object, intValue); //calls setters to the object create in chosen Class
                        break;
                    case "class java.lang.String":
                        String strValue = scan.next();
                        methods[i].invoke(object, strValue);
                        break;
                    default:
                        System.out.println("defolt");
                }
            }
        }
        return (Transport) object;
    }
}
