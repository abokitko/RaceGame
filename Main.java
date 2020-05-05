import classes.*;

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

            System.out.println("How many points do you want to set? ");
            int points = scan.nextInt();

            ArrayList<Point> pointList = new ArrayList<>();
            for(int i = 0; i < points; i++){
                pointList.add(new Point((int)(i+1+Math.random()), (int)(i+1+Math.random())));
            }
            if(j%2 ==0) vectorList.add( new Vector(pointList,"ground"));
            else vectorList.add( new Vector(pointList,"highway"));
        }

        Route route= new Route(vectorList);


        Engine engine1 = new Engine("ROAR7", 11);
        Engine engine2 = new Engine("MOTO414", 8);
        Engine engine3 = new Engine("whoo12", 6);

        Wheels wheels1 = new Wheels("Tiger", 0.4);
        Wheels wheels2 = new Wheels("SOSO", 0.6);
        Wheels wheels3 = new Wheels("Lizard", 0.8);

        Transport sporty = new SportCar("Cheetah",engine1, wheels1);
        Transport carry = new PassengerCar("Zebra", engine2, wheels2);
        Transport trucky = new Truck("Elephant", engine3, wheels3);

        List<Transport> transportList = new ArrayList<>();

        transportList.add(sporty);
        transportList.add(carry);
        transportList.add(trucky);



        SuperDuperVisor lena = new SuperDuperVisor(transportList, route);

        lena.showStart();

        boolean flag = true;
        do {
            for(int i = 0; i < transportList.size(); i++){
                if(lena.tick(transportList.get(i)) != 0)
                    lena.showInfo(transportList.get(i));
                else {
                    flag = false;
                    break;
                }
            }
            System.out.println(" ");
        } while (flag);
    }
}
