package DyteDance;

public class RunningSumOf1DArray {

    //不改变传入参数
    //创建新的array 接收结果
    public static int[] runningSum(int[] nums){
        int len = nums.length;
        int[] res = new int[len];
        res[0] = nums[0];
        for(int i=1;i<len;i++){
            res[i] = res[i-1]+nums[i];
        }
        return res;
    }

    //reuse input arguments

    public static int[] runningSum2(int[] nums){
        for(int i=1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] res = RunningSumOf1DArray.runningSum(nums);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
