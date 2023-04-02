package DP;

//完全背包问题
//01背包和完全背包唯一不同的地方是在遍历顺序上
//我们知道01背包内嵌的循环是从大到小遍历，为了保证没个物品只添加一次
//而完全背包可以添加多次，所以从小到大遍历
//此外，在完全背包中内层循环和外层循环的顺序也是可变的，
public class BackpackII {
    public int backpack(int[] values, int[] weights, int bagSize){
        int[] dp = new int[bagSize+1];
        for(int i=0;i<weights.length;i++){
            for(int j=weights[i];j<=bagSize;j++){
                dp[j] = Math.max(dp[j],dp[j-weights[i]]+values[i]);
            }
        }
        return dp[bagSize];
    }
}
