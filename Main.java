import classes.*;
import classes.Engine.Engine;
import classes.Route.Route;
import classes.Route.Vector;
import classes.Route.Point;
import classes.Transport.*;
import classes.Wheels.Wheels;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many vectors do you want to set? ");
        int vectors = scan.nextInt();

        ArrayList<Vector> vectorList = new ArrayList<>();
        for(int j = 0; j < vectors; j++){

            System.out.print("How many points do you want to set on " + (j+1) +" vector? ");
            int points = scan.nextInt();

            ArrayList<Point> pointList = new ArrayList<>();
            for(int i = 0; i < points; i++){
                pointList.add(new Point((int)(i+1+Math.random()*2), (int)(i+1+Math.random()*2)));
            }
            if(j%2 ==0) vectorList.add( new Vector(pointList,"ground"));
            else vectorList.add( new Vector(pointList,"highway"));
        }

        Route route= new Route(vectorList);

        Engine engine1 = new Engine("ROAR7", 11);
        Engine engine2 = new Engine("MOTO414", 8);
        Engine engine3 = new Engine("whoo12", 6);

        Engine[] engines = {engine1, engine2, engine3};

        Wheels wheels1 = new Wheels("Tiger", 0.4);
        Wheels wheels2 = new Wheels("SOSO", 0.6);
        Wheels wheels3 = new Wheels("Lizard", 0.8);

        Wheels[] wheels = {wheels1, wheels2, wheels3};

        SuperDuperVisor lena = new SuperDuperVisor(route);

            TransportFactory Charlies = new TransportFactory(engines, wheels);

            List<Transport> transportList = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            System.out.print("Which car do you prefer? (Truck, PassengerCar, SportCar): ");
            String name = in.next();
            Transport yourTransport = Charlies.createTransport(name);
            lena.setYourTransport(yourTransport);
            System.out.println("Your car is " + name);
            transportList.add(yourTransport);

            System.out.print("How many players(enemies) do you want? ");
            int k = in.nextInt();
            for(int i = 0; i<k; i++){
                System.out.print("Truck/PassengerCar/SportCar ");
                String enemyName = in.next();
                transportList.add(Charlies.createTransport(enemyName));
            }

        boolean flag = true;
        for(int i = 0; i < transportList.size(); i++){
            transportList.get(i).setCurrentPosition(route.getVectorList().get(0).getPointList().get(0)); //set all on the first point
        }
        do {
            for(int i = 0; i < transportList.size(); i++){
                if(i!=0) System.out.print("Enemy: " );
                else System.out.print("You:   ");

                if(lena.tick(transportList.get(i)) != 0)
                    lena.showInfo(transportList.get(i));
                else {
                    flag = false;
                    System.out.println("Winner! Race is over!");
                    break;
                }
            }
            System.out.println(" ");
        } while (flag);
    }
}
