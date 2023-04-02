package DP.HouseRobber;

public class HouseRobberII {
    //相邻不能偷，首尾相接，因此首位也不能一起偷
    //成环有以下三种情况：
        //1. 考虑不包含首尾元素
        //2. 考虑包含首不包含尾
        //3. 考虑包含尾不包含首
    //注意 这里我们考虑首尾元素，但不一定要取
    //情况2和3包含情况1了，所以我们只考虑情2和3
    public int rob(int[] nums){
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        int res1 = robRange(nums,0,nums.length-2);
        int res2 = robRange(nums,1,nums.length-1);
        return Math.max(res1,res2);
    }

    public int robRange(int[] nums, int start, int end){
        if(end==start) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);
        /*
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
         */
        for(int i=start+2;i<=end;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[end];
    }
}
