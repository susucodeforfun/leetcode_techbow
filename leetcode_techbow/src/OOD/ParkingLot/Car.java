package OOD.ParkingLot;

public class Car extends Vehicle{
    public Car(){
        spotNeeded = 1;
        size = VehicleSize.COMPACT;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.LARGE || spot.getSize() == VehicleSize.COMPACT;
    }

    @Override
    public void print() {
        System.out.println("CAR");
    }
}
