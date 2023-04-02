package sort;

public class Insertsort {
    //插入排序每次将一个元素插入到他前面的有序数组中
    //有两种插入方式：1.逐个交换：待插入元素逐个交换到前面
    // 2.先暂存再后移：先暂存待插入元素 然后前面比暂存元素严格大的后移
    //特点：插入排序是稳定排序，在数组的值接近有序时，时间复杂度接近线性级别
    //基于交换的写法
    public int[] sortArray(int[] nums){
        int len = nums.length;
        //把nums[i]插入有序数组 nums[0,i-1]
        for(int i=1;i<len;i++){
            for(int j=i;j>0;j--){
                //前面的数严格大于后面的数才交换
                if(nums[j-1]>nums[j]){
                    swap(nums,j-1,j);
                }else{//提前终止内层循环
                    break;
                }
            }
        }
        return nums;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //写法2 先暂存再后移
    public int[] insertsort2(int[] nums){
        int len = nums.length;
        for(int i=1;i<len;i++){
            int temp = nums[i];
            int j = i;
            for(;j>0;j--){
                if(temp<nums[j-1]){
                    nums[j] = nums[j-1];
                }else{
                    break;
                }
            }
            nums[j] = temp;
        }
        return nums;
    }
}
