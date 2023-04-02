package OOD.ParkingLot;

public class Bus extends Vehicle{
    //constructor
    public Bus(){
        spotNeeded = 5;
        size = VehicleSize.LARGE;
    }
    public boolean canFitInSpot(ParkingSpot spot){
        return spot.getSize() == VehicleSize.LARGE;
    }
    public void print(){
        System.out.println("BUS");
    }
}
