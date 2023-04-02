package ZeroToThousand;

import LinkedList.ListNode;

public class MergeTwoSortedLists {

    //recursion
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.value<=list2.value) {
            list1.next = mergeTwoLists1(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists1(list1,list2.next);
            return list2;
        }
    }

    //iteration
    //使用dummyNode 和 prev
    //dummyNode用来标记起始位置
    //prev用来标记当前合并到的位置
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        //list1 list2都不为null时 线性探测
        while(list1!=null&&list2!=null){
            if(list1.value<=list2.value){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        //有一个list为null prev.next指向另一个
        if(list1==null) prev.next = list2;
        else prev.next = list1;
        return dummyNode.next;
    }
}
