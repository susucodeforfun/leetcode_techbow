package LinkedList;

import java.util.List;

//Lc206
public class ReverseLinkedList {
    //反转链表： 两种方式 递归和for loop
    //method1: recursion
    //递归反转，先recursion找到最后一个ListNode 标记为新的head(newHead) 然后backtracking 反转链表 最后return最后newHead
    public static ListNode reverseList(ListNode head){
        //cc:head==null base case: head.next==null
        if(head==null||head.next==null) return head;
        //------------------------------
        //先recursion后办事
        //recursion find the last node
        ListNode newHead = reverseList(head.next);
        //backtracking: reverse the direction of each node
        head.next.next = head;
        head.next = null;
        //尾部最后一个节点是新的头节点
        //-----------------------------
        //先办事后recursion 不行
        /*
        ListNode rest = head.next;
        head.next.next = head;
        head.next = null;
        ListNode newHead = reverseList(rest);
         */
        return newHead;
    }

    //method2: iteration
    //很直观的方法：从头向后遍历LinkedList,初始化 cur pre 和next
    //next: 保存cur.next 防止cur.next指向pre后 cur的下一个node丢失
    //cur: 当前node，每次将cur的next指向pre
    //pre： 保存cur的前一个节点 初始为null
    public static ListNode reverseList2(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(3);
        ListNode node1 = new ListNode(2,node2);
        ListNode head = new ListNode(1,node1);
        ListNode cur = ReverseLinkedList.reverseList(head);
        while(cur!=null){
            System.out.println(cur.value);
            cur = cur.next;
        }
    }
}
