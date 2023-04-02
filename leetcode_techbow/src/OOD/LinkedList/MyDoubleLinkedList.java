package OOD.LinkedList;

public class MyDoubleLinkedList {
    class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int val){
            this.val = val;
            next = null;
            prev = null;
        }
    }
    //access modifier Type name
    private ListNode head;
    private ListNode tail;
    private int size;
    //constructor
    public MyDoubleLinkedList(){
        this.size = 0;
        head = null;
        tail = null;
    }
    public int get(int index){
        if(head==null||index<0||index>=size) return -1;
        ListNode cur = head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * 注意add node时 链表是否为null
     * @param val
     */
    public void addAtHead(int val){
        ListNode cur = new ListNode(val);
        if(head==null){
            //head = cur;
            tail = cur;
        }else{
            cur.next = head;
            head.prev = cur;
            //head = cur;
        }
        head = cur;
        size++;
    }

    /**
     * 注意add node时 链表是否为null
     * @param val
     */
    public void addAtTail(int val){
        ListNode cur = new ListNode(val);
        if(tail==null){
            head = cur;
        }else{
            tail.next = cur;
            cur.prev = tail;
        }
        tail = cur;
        size++;
    }

    /**
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val){
        if(index==size){
            addAtTail(val);
            return;
        }
        if(index==0){
            addAtHead(val);
            return;
        }
        ListNode node = new ListNode(val);
        ListNode cur = head;
        for(int i=0;i<index-1;i++){
            cur = cur.next;
        }
        ListNode next = cur.next;
        node.next = next;
        cur.next = node;
        next.prev = node;
        node.prev = cur;
    }

    /**
     *
     * @param index
     */
    public void deleteAtIndex(int index) {

    }
}
