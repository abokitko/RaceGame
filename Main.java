import classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point A = new Point(0,0);
        Point B = new Point(1,1);
        Point C = new Point(2,2);
        Point D = new Point(3,3);
        Point E = new Point(4,4);
        Point F = new Point(5,5);
        Point G = new Point(6,6);
        Point H = new Point(7,7);
        Point I = new Point(8,8);
        Point J = new Point(9,9);
        Point K = new Point(10,10);

        List<Point> pointListAE = new ArrayList<>();
        List<Point> pointListFK = new ArrayList<>();

        pointListAE.add(A);
        pointListAE.add(B);
        pointListAE.add(C);
        pointListAE.add(D);
        pointListAE.add(E);

        pointListFK.add(F);
        pointListFK.add(G);
        pointListFK.add(H);
        pointListFK.add(I);
        pointListFK.add(J);
        pointListFK.add(K);

        Vector AE = new Vector(pointListAE,"ground");
        Vector FK = new Vector(pointListFK, "highway");

        List<Vector> vectorList = new ArrayList<>();

        vectorList.add(AE);
        vectorList.add(FK);

        Route AEFK= new Route(vectorList);
      // route block

        Engine engine1 = new Engine("ROAR7", 11);
        Engine engine2 = new Engine("MOTO414", 8);
        Engine engine3 = new Engine("whoo12", 5);

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



        SuperDuperVisor lena = new SuperDuperVisor(transportList, AEFK);

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
        } while (flag);
    }
}
