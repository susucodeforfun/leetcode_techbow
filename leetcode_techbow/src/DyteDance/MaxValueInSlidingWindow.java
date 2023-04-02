package DyteDance;

import java.util.Deque;
import java.util.LinkedList;

public class MaxValueInSlidingWindow {

    //method1： 两层for-loop Time: O(n^2) 超时
    public static int[] maxSlidingWindow(int[] nums, int k){
        if(k==1) return nums;
        int len = nums.length;
        int[] res = new int[len-k+1];
        for(int i=0;i<=len-k;i++){
            int max = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
               max = Math.max(max,nums[j]);
            }
            res[i] = max;
        }
        return res;
    }

    //method2: 维护一个单调非严格递减序列，保存滑动窗口中的最大值
    public static int[] MaxValueInSlidingWindow2(int[] nums, int k){
        //cc
        if(nums==null || nums.length==0) return nums;
        //使用一个Deque去维护一个单调非严格递减序列，保存滑动窗口中的最大值
        Deque<Integer> deque = new LinkedList<>();
        int len = nums.length;
        //保存结果
        int[] res = new int[len-k+1];
        int index = 0;
        //初始化
        for(int i=0;i<k;i++){
            while(!deque.isEmpty()&&deque.peekLast()<nums[i]){
                deque.removeLast();
            }
            deque.offer(nums[i]);
        }
        res[index] = deque.peekFirst();
        index++;
        for(int i=k;i<len;i++){
            if(deque.peekFirst()==nums[i-k]) deque.removeFirst();
            while(!deque.isEmpty()&&deque.peekLast()<nums[i]){
                deque.removeLast();
            }
            deque.offer(nums[i]);
            res[i] = deque.peekFirst();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] res = MaxValueInSlidingWindow.MaxValueInSlidingWindow2(new int[]{1,3,1,2,0,5},3);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
