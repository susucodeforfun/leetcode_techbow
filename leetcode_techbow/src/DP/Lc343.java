package DP;

public class Lc343 {
    public int integerBreak(int n){
        //1. define dp[i]: 拆分数字i,可以得到的最大乘积dp[i]
        //2. 递推公式：
            //两种情况： 1. j*(i-j) 直接相乘 2.j*dp[i-j]
            // max(dp[i],max((i-j)*j,dp[i-j]*j)
        //3. dp初始化 对dp[0] dp[1]初始化无意义，因此我们从dp[2]开始初始化，dp[2]=1
        //4. 遍历顺序: 从前向后遍历
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<=i/2;j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
