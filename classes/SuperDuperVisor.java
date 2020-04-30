package classes;
import java.util.List;
import java.util.Scanner;

public class SuperDuperVisor {

    private List<Transport> transportList;
    private Route route;
    private int choice;
    private Transport yourCar;

    public SuperDuperVisor(List<Transport> transportList, Route route) {
        this.transportList = transportList;
        this.route = route;
    }

    public void showStart(){                  // intro info
        Scanner in = new Scanner(System.in);
        System.out.print("Which car do you prefer? Write number: ");
        this.choice = in.nextInt();
        this.yourCar = transportList.get(choice);
        System.out.println("Your car is " + yourCar.getName());

        for(int i = 0; i < transportList.size(); i++){
            transportList.get(i).setCurrentPosition(route.getVectorList().get(0).getPointList().get(0)); //set all on the first point
        }
    }

    Vector getVectorByPoint(Point position){         // find out on which vector we are now
        for(int i = 0; i < route.getRouteLengthV(); i++){
            if(route.getVectorList().get(i).getPointList().indexOf(position) > -1) {
                return route.getVectorList().get(i);
            }
        }
        return null;
    }

    int countSpeed(Transport transport){
        Point position = transport.getCurrentPosition();
        if(getVectorByPoint(position).getVectorMaxSpeed()    // speed = min{ vectorMaxSpeed; transportMaxSpeed}
                >= transport.getTransportMaxSpeed()){
            return transport.getTransportMaxSpeed();
        } else return getVectorByPoint(position).getVectorMaxSpeed();
    }

    public int tick(Transport transport){
        Point position = transport.getCurrentPosition();

        Vector currentVector = getVectorByPoint(position);  //in which Vector the position is
        int iV =  route.getVectorList().indexOf(currentVector); //index of the current vector in the route
        int iP = currentVector.getPointList().indexOf(position); //index of the point we are in the current classes.Vector


        int speed = countSpeed(transport);        //how much point we can jump over
        transport.setRealSpeed(speed);      //control real speed in a transport

        int currentVectorSize = currentVector.getPointList().size();

        if(iP + speed < currentVectorSize){     // we can't jump farther than currVector
            transport.setCurrentPosition(currentVector.getPointList().get(iP+speed)); //newPos = currPos + speed |currVector
        } else if(iV == route.getRouteLengthV()-1) {     //we can jump over currVector, but it is last
            return 0;                                    // finish
        } else                              //not last and we can jump
            transport.setCurrentPosition(route.getVectorList().get(iV+1).getPointList().get(iP+speed - currentVectorSize));
            return 1;
    }

        public void showInfo(Transport transport){
        if (transport.equals(yourCar)){
            System.out.print("You:   ");
        }
        else System.out.print("Enemy: ");
        System.out.print(" X: " + transport.getCurrentPosition().getX());
        System.out.print(" Y: " + transport.getCurrentPosition().getY());
        System.out.print(" speed is: " + transport.getRealSpeed());
        System.out.println("   material is " + getVectorByPoint(transport.getCurrentPosition()).getMaterial());
    }

}
