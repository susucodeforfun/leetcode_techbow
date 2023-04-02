package DyteDance;

import LinkedList.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        int sum = 0;
        int carry = 0;
        while(l1!=null||l2!=null){
            int i = l1==null ? 0:l1.value;
            int j = l2==null? 0:l2.value;
            sum = i+j+carry;
            carry = sum/10;
            sum %= 10;
            cur.next =new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry==1) cur.next = new ListNode(1);
        return dummyNode.next;
    }
}
