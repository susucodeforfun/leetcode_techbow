package LinkedList;

public class ReverseListNodeBetweenTwoNodes {
    public ListNode reverseBetweem(ListNode head, int left, int right){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode leftNodePrev = dummyNode;
        ListNode rightNode = dummyNode;
        //find the precursor of the left
        for(int i=0;i<left-1;i++){
            leftNodePrev = leftNodePrev.next;
        }
        //find the right
        for(int j=0;j<right;j++){
            rightNode = rightNode.next;
        }
        ListNode leftNode = leftNodePrev.next;
        ListNode rightNodeNext = rightNode.next;
        reverse(leftNode,rightNode);
        leftNodePrev.next = rightNode;
        leftNode.next = rightNodeNext;
        return head;
    }
    public ListNode reverse(ListNode left, ListNode right){
        if(left==right){
            return left;
        }
        ListNode newHead = reverse(left.next,right);
        left.next.next = left;
        left.next = null;
        return left;
    }
}
