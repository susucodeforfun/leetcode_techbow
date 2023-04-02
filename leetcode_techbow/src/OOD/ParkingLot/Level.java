package OOD.ParkingLot;

public class Level {
    private int floor; //楼层
    private ParkingSpot[] spots; //车位数组
    private int availableSpots = 0;// number of free spots
    private int SPOTS_PER_ROW;

    public Level(int floor, int num_rows,int sports_per_row){
        this.floor = floor;
    }

}
