package DP;

public class Lc518 {

    //dp[j]: 凑成总金额j的货币组合数为dp[j]
    //递推公式： dp[j]是所有dp[j-coins[i]]相加 dp[j]+=dp[j-coins[i]]
    //dp初始化: dp[0] = 1 凑成amount=0 的货币组合数是1
    //遍历顺序： 先遍历物品(coins),后遍历背包(amount),得到的是组合数
    //         先遍历背包(amount)，后遍历物品(coins)，得到的是排列数
    public int change(int amount, int[] coins){
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
