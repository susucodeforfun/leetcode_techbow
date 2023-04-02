package OOD.LinkedList;

import java.util.LinkedList;

//SingleLinkedList
public class MyLinkedList {
    ListNode head;
    int size;
    public MyLinkedList(){
        size = 0;
        head = null;
    }

    /**
     * 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
     * @param index
     * @return
     */
    public int get(int index){
        if(head==null||index<0||index>=size) return -1;
        ListNode cur = head;
        while(index>0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val){
        ListNode node = new ListNode(val);
        node.next = head;
    }

    public void addAtTail(int val){
        ListNode node = new ListNode(val);
        head.next = node;
    }

    public void addAtIndex(int index, int val){
        if(index>=size){
            return;
        }
        ListNode node = new ListNode(val);
        ListNode cur = head;
        for(int i=0;i<index-1;i++){
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }

    public void deleteAtIndex(int index){
        ListNode cur = head;
        for(int i=0;i<index-1;i++){
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = next.next;
        next.next = null;
    }
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            next = null;
        }
    }
}
