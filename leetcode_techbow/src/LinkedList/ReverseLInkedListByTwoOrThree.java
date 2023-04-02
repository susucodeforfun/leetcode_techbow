package LinkedList;

public class ReverseLInkedListByTwoOrThree {

    public ListNode reverseByTwo(ListNode head){
        //cc && base case
        if(head==null||head.next==null){
            return head;
        }
        //这里既可以进行先序遍历 也可以后续遍历 就是所谓的是先办事后recursion 和 先recursion后办事
        //-----------------------------
        //先recursion后办事
        //nextHead：已经reverse的LinkedList的head
        ListNode nextHead = reverseByTwo(head.next.next);
        //switch two nodes
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = nextHead;
        return newHead;
        //--------------------------------
        //先办事后recursion
        /*
        ListNode rest = head.next.next;
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = reverseByTwo(rest);
        return newHead;
         */
    }

    public ListNode reverseByThree(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode nextHead = reverseByThree(head.next.next.next);
        ListNode newHead = head.next.next;
        newHead.next = head.next;
        head.next.next = head;
        head.next = nextHead;
        return newHead;
    }
}
