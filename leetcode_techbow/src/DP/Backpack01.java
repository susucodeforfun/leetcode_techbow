package DP;

//01背包问题
//1.确定dp数组定义： dp[i][j]: 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
//确定递推公式： 1.不放物品i: 由dp[i-1][j]推出，背包容量为j,里面不放物品i的最大价值，此时dp[i][j] = dp[i-1][j]
//            2. 放物品i: 由dp[i-1][j-weight[i]], dp[i-1][j-weight[i]]为背包容量为j-weight[i]的时候不放物品i的最大价值，
//            那么dp[i-1][j-weight[i]]+value[i]（物品i的价值),就是背包放物品i得到的最大价值
//             dp[i][j] = max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
//dp数组初始化：  根据定义，如果背包容量j为0，dp[i][0]，无论选哪些物品，背包价值总和一定为0
//              dp[0][j]: 即i为0，存放编号0的物品的时候，各个容量的背包所能存放的最大价值
//              当j<weight[0]时,dp[0][j]=0,因为背包容量比编号0的物品重量还小
//              当j>=weights[0]时，dp[0][j]应该是value[0]，因为背包容量放足够放编号0物品

public class Backpack01 {
    /*
    public int maxValue(int[] value, int[] weight, int size) {
        int[][] dp = new int[weight.length][size + 1];
        //初始化：dp初始化默认为0，因此weight[0]
        for (int j = weight[0]; j <= size; j++) {
            dp[0][j] = value[0];
        }
        //filled dp array
        for (int i = 1; i < weight.length; i++) {
            for (int j = weight[0]; j <= size; j++) {
                //当前背包容量没有当前物品i大的时候，不放物品i
                //因此前i-1个物品能放下的最大价值就是当前情况的最大价值
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                }
                //当前背包容量可以放下物品i
                //
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[weight.length][size+1];
    }
     */

    //1d dp array
    //滚动数组
    //dp定义: dp[j]: 容量为j的背包，所背的物品价值可以最大为dp[j]
    //递推公式: 两种选择：1.取自己dp[j]，相当于2d dp array中的dp[i-1][j],即不放物品
    //                 2. dp[i-weight[i]]+value[i]
    //初始化：dp[0] = 0

    public int maxValue1(int[] value, int[] weight, int size){
        int[] dp = new int[size+1];
        dp[0] = 0;
        for(int i=1;i<=weight.length;i++){
            for(int j=size;j>=weight[0];j--){
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        return dp[size];
    }

    public int packbackDemo(int[] value, int[] weight, int size){
        //dp[i][j]: select items from item 0 to item i, put them into the bag which the weight is size,
        //find the maximum of the value
        //initialize the dp array
        int[][] dp = new int[weight.length][size+1];
        for(int j=weight[0];j<=size;j++){
            dp[0][j] = value[0];
        }
        for(int i=1;i<weight.length;i++){
            for(int j=1;j<=size;j++){
                if(j<weight[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
            }
        }
        return dp[weight.length][size];
    }

    public int optimizedPackBack(int[] value, int[] weight, int size){
        //dp[j] definition: the maximum of the value, when the weight of the backpack is j;
        //initialize the dp array
        int[] dp = new int[size+1];
        for(int j=weight[0];j<=size;j++){
            dp[j] = value[0];
        }
        for(int i=0;i<weight.length;i++){
            for(int j=size;j>=weight[i];j--){
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        return dp[size];
    }

}
