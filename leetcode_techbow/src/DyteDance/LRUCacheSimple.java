package DyteDance;

import BFS.Node;

import java.util.LinkedHashMap;

public class LRUCacheSimple {
    private LinkedHashMap<Integer, Integer> linkedHashMap;
    int capacity;
    public LRUCacheSimple(int capacity){
        linkedHashMap = new LinkedHashMap<>();
        this.capacity = capacity;
    }


    public int get(int key){
        if(!linkedHashMap.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return linkedHashMap.get(key);
    }

    public void put(int key, int value){
        if(linkedHashMap.size()==capacity){
            int oldestKey = linkedHashMap.keySet().iterator().next();
            linkedHashMap.remove(oldestKey);
        }
        if(linkedHashMap.containsKey(key)){
            linkedHashMap.put(key,value);
            makeRecently(key);
            return;
        }
        linkedHashMap.put(key,value);
    }
    /**
     * 删除key
     * 插入到队尾
     * @param key
     */
    public void makeRecently(int key){
        int value = linkedHashMap.get(key);
        linkedHashMap.remove(key);
        linkedHashMap.put(key,value);
    }
}
