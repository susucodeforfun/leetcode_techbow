package OOD.ParkingLot;

public class Motorcycle extends Vehicle{
    public Motorcycle(){
        spotNeeded = 1;
        size = VehicleSize.MOTORCYCLE;
    }
    public boolean canFitInSpot(ParkingSpot spot){
        return true;
    }

    @Override
    public void print() {
        System.out.println("MOTORCYCLE");
    }

}
