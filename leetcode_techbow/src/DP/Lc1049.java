package DP;

public class Lc1049 {
    //思路： 尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小。
    //可以转化为01背包问题，类似416题

    //define dp array: dp[j] 表示容量为j的背包，最多可以背最大重量为dp[j]
    //递推公式： dp[j] = max(dp[j],dp[j-stones[i]]+stones[i])
    public int lastStoneWeightII(int[] stones){
        int weightSum = 0;
        for(int i=0;i<stones.length;i++){
            weightSum+=stones[i];
        }
        int target = weightSum/2;
        int[] dp = new int[target+1];
        for(int i=0;i<stones.length;i++){
            for(int j=target;j>=stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return weightSum-dp[target]-dp[target];
    }
}
