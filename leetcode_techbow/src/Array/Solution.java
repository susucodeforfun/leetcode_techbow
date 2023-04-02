package Array;
public class Solution {
    public int uglyValue(int num, int[] nums){
        int len = nums.length;
        int res = 0;
        for(int i=0;i<len-1;i++){
            int index = i+1;
            for(int j=i+1;j<len;j++){
                int min = Integer.MAX_VALUE;
                if(Math.abs(nums[i]-nums[j])<min){
                    min = Math.abs(nums[i]-nums[j]);
                    index = j;
                }
            }
            swap(nums,i+1,index);
        }
        for(int i=1;i<nums.length;i++){
            res+= Math.abs(nums[i]-nums[i-1]);
        }
        for(int i=0;i<nums.length;i++){
           System.out.print(nums[i]+" ");
        }
        return res;
    }

    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int res = solution.uglyValue(4,new int[]{4,1,3,2});
        System.out.print(res);
    }
}
