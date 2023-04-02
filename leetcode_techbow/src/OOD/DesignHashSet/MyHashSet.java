package OOD.DesignHashSet;

import java.util.LinkedList;

public class MyHashSet<E> {
    private LinkedList[] list;
    public MyHashSet(){
        list = new LinkedList[1009];
        for(int i=0;i<1009;i++){
            list[i] = new LinkedList<Integer>();
        }
    }
    public void add(E key){

    }

    public void remove(E key){

    }
    public boolean contains(E key){
        return false;
    }
}
