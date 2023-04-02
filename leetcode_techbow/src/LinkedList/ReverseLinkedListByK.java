package LinkedList;

public class ReverseLinkedListByK {
    //通过head和tail确定k个一组的LinkedList
    //使用reserve()反转整个链表，每次反转从head到tail的LinkedList
    //recursion 反转k Group
    public ListNode reverseKGroup(ListNode head, int k){
        //cc
        if(head==null||head.next==null) return head;
        ListNode tail = head;
        //这里的tail不是思路中head到tail 而是下一段的head 也就是思路中tail的next
        for(int i=0;i<k;i++){
            if(tail==null) return head;
            tail = tail.next;
        }
        //newHead： 反转当前k个一组的LinkedList后的新的head
        ListNode newHead = reverse(head,tail);
        //老的head 也就是反转后的tail 连接后面的LinkedList
        head.next = reverseKGroup(tail,k);
        return newHead;
    }

    //reverse 可以用recursion和iteration两种方式实现
    public ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || head.next == tail) return head;
        ListNode newHead = reverse(head.next, tail);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
