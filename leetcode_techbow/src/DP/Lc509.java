package DP;

public class Lc509 {
    //fibonacci：
    //dp五步
    //1. 确定dp数组和下标含义： dp[i]: 第i个数的fibonacci数值是dp[i]
    //2. 确定递推公式： dp[i] = dp[i-1]+dp[i-2]
    //3. dp数组初始化： dp[0] = 0  dp[1] = 1
    //4. 确定遍历顺序： dp[i] =
    public int fib(int n){
        if(n<=1) return n;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //空间优化，使用滚动数组
    public int fib2(int n){
        if(n<=1) return n;
        int[] dp = new int[2];
        int sum = 0;
        for(int i=2;i<=n;i++){
            sum = dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }

    //recursion
    public int fibRecursion(int n){
        if(n<=1)  return n;
        return fibRecursion(n-1)+fibRecursion(n-2);
    }
}
