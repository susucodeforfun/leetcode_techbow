package sort;

public class Mergesort {
    public int[] sortArray(int[] nums){
        int len = nums.length;
        mergeSort(nums,0,len-1);
        return nums;
    }
    public void mergeSort(int[] nums, int left, int right){
        if(left>=right) return;
        int mid = left+(right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        mergeTwoSortedArray(nums,left,mid,right);
    }
    public void mergeTwoSortedArray(int[] nums, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid&&j<=right){
            if(nums[i]<nums[j]){
                temp[k] = nums[i];
                k++;
                i++;
            }else{
                temp[k] = nums[j];
                k++;
                j++;
            }
        }
        while (i<=mid){
            temp[k] = nums[i];
            k++;
            i++;
        }
        while (j<=right){
            temp[k] = nums[i];
            k++;
            j++;
        }
        for(int index=0;index<=temp.length;index++){
            nums[index+left] = temp[index];
        }
    }
}
