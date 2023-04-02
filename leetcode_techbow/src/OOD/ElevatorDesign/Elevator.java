package OOD.ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private List<ElevatorButton> buttons;
    private List<Boolean> upStops;
    private List<Boolean> downStops;

    private int currLevel;
    private Status status;

    //constructor
    public Elevator(int n){
        buttons = new ArrayList<ElevatorButton>();
        upStops = new ArrayList<Boolean>();
        downStops = new ArrayList<Boolean>();
        currLevel = 0;
        for(int i=0;i<n;i++){
            upStops.add(false);
            downStops.add(false);
        }
    }

    public void insertButton(ElevatorButton eb){
        buttons.add(eb);
    }
}
