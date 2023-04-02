package DP;

public class Lc62 {
    public int uniquePaths(int m,int n){
        //define dp array：from[0][0]to[i][j], it has dp[i][j] different routes
        int[][] dp = new int[m][n];
        //递推公式： dp[i][j] = dp[i-1][j]+dp[i][j-1]
        //初始化：dp[i][0] dp[0][j] 都是 1 因为(0,0)到(i,0) （0，0）到（0,j)的路径只有一条
        //遍历顺序：从上方和左方推导而来，因此从左到右逐层推
        //验证
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            dp[0][j] = 1;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    //space optimized
    //滚动数组
    public int optimizedUniquePaths(int m, int n){
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
        }
        for(int j=1;j<m;j++){
            for(int i=1;i<n;i++){
                dp[i] += dp[i-1];
            }
        }
        return dp[n-1];
    }
}
