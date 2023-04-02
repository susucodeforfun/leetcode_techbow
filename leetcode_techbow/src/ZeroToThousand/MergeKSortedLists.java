package ZeroToThousand;

import LinkedList.ListNode;

public class MergeKSortedLists {

    //method 1: mergeSort
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length==0) return new ListNode();
        ListNode res = patition(lists,0,lists.length-1);
        return res;
    }
    public ListNode patition(ListNode[] lists,int left, int right){
        if(left==right) return lists[left];
        int mid = left+(right-left)/2;
        ListNode leftNode = patition(lists,left,mid);
        ListNode rightNode = patition(lists,mid+1,right);
        return merge(leftNode,rightNode);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.value<=l2.value){
            l1.next = merge(l1.next,l2);
            return l1;
        }else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}
