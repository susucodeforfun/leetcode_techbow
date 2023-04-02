package sort;

public class Quicksort {
    public int[] sortArray(int[] nums){
        quicksort(nums,0,nums.length);
        return nums;
    }
    public void quicksort(int[] nums, int left, int right){
        if(left>=right) return;
        int pivotIndex = partition(left,right,nums);
        quicksort(nums,left,pivotIndex-1);
        quicksort(nums,pivotIndex+1,right);
    }
    public int partition(int left, int right, int[] nums){
        int pivot = nums[left];
        int j = left; // j是<=pivot的集合的最后一个元素
        //all in nums[left+1,j] <= pivot
        //all in nums(j,i) > pivot
        for(int i=left+1;i<=right;i++){
            if(pivot>=nums[i]) {
                //若当前元素nums[i]<=pivot,交换nums[i]和>pivot区间的第一个元素
                j++;
                swap(nums,j,i);
            }
        }
        swap(nums,left,j);
        return j;
    }

    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    //第二种写法 修改定义 j为>pivot区间的第一个元素
    //<=pivot区间：[left+1,j)
    //>=pivot区间 :[j,i)
    public int partition2(int[] nums,int left,int right){
        int pivot = nums[left];
        int j = left+1;
        for(int i= left+1;i<=right;i++){
            if(nums[i]<=pivot){
                swap(nums,i,j);
                j++;
            }
        }
        swap(nums,left,j-1);
        return j-1;
    }
}
