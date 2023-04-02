package DP;

public class Lc96 {
    //dp定义：dp[i]: 1到i为节点组成的二叉搜索数的个数为dp[i]
    //递推公式：dp[i]+=dp[以j为头节点左子树节点数量]*dp[以j为头节点右子树节点数量]
    //j相当于是头节点的元素，从1遍历到i为止
    //dp初始化：dp[0]=1
    //遍历顺序：从前向后
    public int numTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<n;i++){
            for(int j=1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
