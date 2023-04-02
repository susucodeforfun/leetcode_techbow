package DyteDance;

import java.util.Arrays;

public class CoinChange {
    private int res =Integer.MAX_VALUE;
    Integer[] memo;
    public int coinChange(int[] coins, int amount){
        if(coins.length==0) return -1;
        memo = new Integer[amount];
        int res = dfs(coins,amount);
        return res == Integer.MAX_VALUE? -1:res;
    }

    /**
     * regular dfs
     * @param coins
     * @param amount
     * @param count 统计硬币个数
     */
    public void findWay(int[] coins,int amount,int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res = Math.min(res,count);
        }
        for(int i = 0;i < coins.length;i++){
            findWay(coins,amount-coins[i],count+1);
        }
    }

    /**
     * dfs with memorization
     * @param coins
     * @param amount
     * @return 在当前amount下能够花费的最少硬币个数
     */
    public int dfs(int[] coins, int amount){
        if(amount==0) return 0;
        if(amount<0) return -1;
        if(memo[amount]!=null) return memo[amount];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int res = dfs(coins,amount-coins[i]);
            if(res==-1) continue;
            min = Math.min(min,res+1);
        }
        memo[amount] = min==Integer.MAX_VALUE? -1:min;
        return memo[amount];
    }

    /**
     * dp
     * dp定义：dp[i] 目标金额为i时，需要dp[i]枚coins凑出
     */
    public int coinChangeDP(int[] coins, int amount){
        if(amount==0) return 0;
        if(coins==null || coins.length==0) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount]==(amount+1)? -1:dp[amount];
    }
}
