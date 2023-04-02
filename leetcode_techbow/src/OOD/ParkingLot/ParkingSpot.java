package OOD.ParkingLot;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;

    //constructor
    public ParkingSpot(VehicleSize spotSize, int row, int spotNumber, Level level){
        this.spotSize = spotSize;
        this.row = row;
        this.spotNumber = spotNumber;
        this.level = level;
    }

    //getter
    public VehicleSize getSize(){
        return spotSize;
    }

    public int getRow(){
        return row;
    }
    public int getSpotNumber(){
        return spotNumber;
    }
    public Level getLevel(){
        return level;
    }

    //车位是否可用
    public boolean isAvailable(){
        return vehicle==null;
    }

    //Remove vehicle from spot and notify level that a new spot is available
    public void removeVehicle() {
        //level.spotFreed();
        vehicle = null;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        return isAvailable()&&vehicle.canFitInSpot(this);
    }

    public boolean park(Vehicle v){
        if(!canFitVehicle(v)){
            return false;
        }
        v.parkInSpot(this);
        return true;
    }

}
