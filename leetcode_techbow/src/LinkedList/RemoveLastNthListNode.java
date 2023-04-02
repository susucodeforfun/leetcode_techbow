package LinkedList;

public class RemoveLastNthListNode {
    public ListNode removeNthFromEnd(ListNode head, int n){
        //two pointer: fast node先走n 然后 fast slow 同时走，
        // 当fast.next==null slow的位置是倒数Nth Node的前一个位置，因为删除curNode 需要知道他的preNode才可以删除
        //注意是从dummyNode开始
        ListNode dummyNode = new ListNode();
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return slow;
    }
}