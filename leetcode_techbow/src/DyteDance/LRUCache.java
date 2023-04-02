package DyteDance;

import java.util.HashMap;

/**
 * 使用LinkedHashMap 实现LRUCache
 * 首先 实现双向链表 DoubleLinkedList
 *
 */
public class LRUCache {
    //key -> Node(key,val)
    private HashMap<Integer,Node> map;
    //Node(k1,v1) -> Node(k2,v2)
    private DoubleLinkedList cache;
    int capacity;

    //constructor
    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleLinkedList();
    }

    /**
     * 将某个key提升为最近使用的
     * 先从链表删除这个节点
     * 再重新插入队尾
     * @param key
     */
    private void makeRecently(int key){
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    /**
     * add used node recently
     * 1. add node to the linkedlist in the last position
     * 2. add <key,val> in the map
     * @param key
     * @param val
     */
    private void addRecently(int key, int val){
        Node x = new Node(key,val);
        cache.addLast(x);
        map.put(key,x);
    }

    /**
     * delete key
     *  1. delete node from linkedlist
     *  2. delete key from map
     * @param key
     */
    private void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    /**
     * delete unused node longest
     */
    private void removeLeastRecently(){
        Node deletedNode = cache.removeFirst();
        map.remove(deletedNode.key);
    }

    /**
     * get时别忘了将get的<key,value>设置成最近使用
     * @param key
     * @return
     */
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return map.get(key).value;
    }

    public void put(int key, int val){
        if(map.containsKey(key)){
            deleteKey(key);
        }
        if(capacity==cache.size()){
            removeLeastRecently();
        }
        addRecently(key,val);
    }

    private class Node{
        int key;
        int value;
        public Node prev;
        public Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private class DoubleLinkedList{
        //head & tail
        //头尾dummyNode
        private Node head;
        private Node tail;
        //链表元素个数
        private int size;

        //constructor
        public DoubleLinkedList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        //add node on the tail of linkedlist, time O(1)
        public void addLast(Node x){
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        //remove node in the linkedlist
        public void remove(Node x){
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        //remove thr first node
        public Node removeFirst(){
           if(head.next == tail){
               return null;
           }
           Node first = head.next;
           remove(first);
           return first;
        }

        //return the size of linkedlist, time O(1)
        public int size(){
            return size;
        }
    }
}
