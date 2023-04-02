package DP.HouseRobber;

//
public class HouseRobberI {
    //1.dp[i]: 考虑下标i（包括i)在内的房屋，最多可以偷窃的金额为dp[i]  or 偷前i个房子
    //2.递推公式：决定dp[i]的因素就是第i个房间偷还是不偷
        //如果偷第i个房间，那么dp[i] = dp[i-2]+nums[i]：即i-1房一定不考虑，找出i-2(包括i-2)以内的房屋，最多可以偷窃的金额为dp[i-2]加上第i房间偷到的钱
        //如果不偷第i个房间，那么dp[i]=dp[i-1] （这里是考虑第i-1个房子，不是一定偷）
        //取两种情况的最大值： dp[i] = max(dp[i-2]+nums[i],dp[i-1])
    //3. 数组初始化： 根据dp定义 dp[0]=nums[0] dp[1] = max(nums[0],nums[1])
    //4. 确定遍历顺序: dp[i] 根据dp[i-2] dp[i-1]推导得出,因此是从前向后遍历
    public int rob(int[] nums){
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
