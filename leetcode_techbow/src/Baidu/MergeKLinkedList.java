package Baidu;

import LinkedList.ListNode;

public class MergeKLinkedList {

    /**
     * Method1:
     *  调用mergeTwo方法，将K个LinkedList一直merge
     *      具体步骤：使用一个ListNode res 维护MergeTwo的结果 与后面的LinkedList继续merge
     *      Time: O(k^2*n)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){
        ListNode res = null;
        for(ListNode l:lists){
            res = mergeTwo(res,l);
        }
        return res;
    }

    /**
     * Method2:
     *  使用devide and conquer
     *  Time: O(n*logK)
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists){
        //cc
        if(lists==null||lists.length==0) return null;
        ListNode res = partition(lists,0,lists.length-1);
        return res;
    }
    public ListNode partition(ListNode[] lists, int left, int right){
        if(left==right){
            return lists[left];
        }
        if(left>right){
            return null;
        }
        int mid = left+(right-left)/2;
        ListNode leftNode = partition(lists,left,mid);
        ListNode rightNode =partition(lists,mid+1,right);
        return mergeTwo(leftNode,rightNode);
    }
    public ListNode mergeTwo(ListNode l1, ListNode l2){
        //base case
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.value<=l2.value){
            l1.next = mergeTwo(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwo(l1,l2.next);
            return l2;
        }
    }
}
