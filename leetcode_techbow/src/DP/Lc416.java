package DP;

public class Lc416 {
    //Make sure the following four points, we can use 01 backpack
    //1. the weight of the backpack is sum/2
    //2. the weight of the items is the value of the items.
    //3. If the backpack is filled, it means we find out the collection which equals to sum/2
    //4. items can not be put into the backpack repeatedly

    //思路和01背包相同， 按照01背包的思路去填充dp，最后我们check 当背包容量为sum/2的时候，是否能装满
    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum%2==1) return false;
        int target = sum/2;
        //initialize 1d dp array
        int[] dp = new int[target+1];
        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }
}
