package Heap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Lc215 {
    //1.使用PriorityQueue
    public static int findKthLargest(int[] nums, int k){
        int len = nums.length;
        //cc
        if(nums==null||len==0) return -1;
        //Default PriorityQueue is minHeap
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<len;i++){
            queue.offer(nums[i]);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static Random random = new Random();
    //2.quickSelection
    public static int findKthLargest02(int[] nums, int k){
        //cc
        return quickSelection(nums,k-1,0,nums.length-1);
    }

    public static int quickSelection(int[] nums, int target, int left, int right){
        int randomIndex = left+random.nextInt(right-left+1);
        swap(nums,nums[left],nums[randomIndex]);
        int index = partition(nums,left,right);
        if(index<target){
            return quickSelection(nums,target,index+1,right);
        }else if(index>target){
            return quickSelection(nums,target,left,index-1);
        }else{
            return nums[index];
        }
    }

    public static int partition(int[] nums,int left,int right){
        int index = left;
        for(int i=left+1;i<=right;i++){
            if(nums[i]>nums[left]){
                swap(nums,nums[index+1],nums[i]);
                index++;
            }
        }
        swap(nums,nums[index],nums[left]);
        return index;
    }

    public static void swap(int[] nums, int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int res = Lc215.findKthLargest02(nums,2);
        System.out.println(res);
    }
}
