package DP;

public class Lc70 {
    //1. 确定dp数组和下标含义：dp[i]:爬到第i层楼梯有dp[i]种方法
    //2. 确定递推公式：从dp定义可以看出，dp[i]有两个方向可以从两个方向推导
    // 1) dp[i-1]: 上i-1层楼梯 有dp[i-1]种方法，则再一步一个台阶到达dp[i]
    // 2）dp[i-2]: 上i-2层楼梯，有dp[i-2]种方法，那么再一步跳两个台阶到达dp[i]
    //3. dp数组初始化：dp[1] = 1  dp[2] = 2  dp[0]的定义有歧义，如果一定要从dp[0]开始定义
    //那么dp[0] = 1 到第0层也是一种方法
    //4. 确定遍历顺序： 从前向后
    //5. 举例推导dp数组
    public int climbStairs(int n){
        if(n<=1) return n;
        int[] dp = new int[n];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //空间优化 利用滚动数组
    public int climbStairs2(int n){
        if(n<=1) return n;
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        int sum = 0;
        for(int i=3;i<=n;i++){
            sum = dp[1]+dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }
}
