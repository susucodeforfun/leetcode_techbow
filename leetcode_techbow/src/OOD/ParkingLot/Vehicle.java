package OOD.ParkingLot;

import java.util.ArrayList;

abstract class Vehicle {
    protected int spotNeeded; //需要几个停车位
    protected VehicleSize size; //车的类型
    protected  String licensePlate; //id for a vehicle
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();//id for parking where may occupy multi

    //getter
    public int getSpotNeeded(){
        return spotNeeded;
    }

    public VehicleSize getVehicleSize(){
        return size;
    }

    /* Park vehicle in this spot */
    public void parkInSpot(ParkingSpot spot){
        parkingSpots.add(spot);
    }

    /* Remove car from spot and notify spot that it's gone */
    public void clearSpots(){
        for(int i=0;i<parkingSpots.size();i++){
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }

    /* This function needs to be implement in subclass */
    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print();
}
