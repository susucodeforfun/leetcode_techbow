package LinkedList;

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode A = headA;
        ListNode B = headB;
        while(A!=B){
            A = A.next;
            B = B.next;
            if(A == null){
                A = headB;
            }
            if(B == null){

            }
        }
        return A;
    }
}
