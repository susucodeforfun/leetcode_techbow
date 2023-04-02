package sort;

public class Selectsort {
    //选择排序先选出最小的，在选出第二小的，以此类推
    public int[] sortArray(int[] nums){
        int len = nums.length;
        for(int i=0;i<len-1;i++){
            int minIndex = i;
            for(int j=i+1;j<len;j++){
                if(nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums,i,minIndex);
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
