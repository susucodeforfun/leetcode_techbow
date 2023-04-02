package DP;

public class Lc746 {
    public int minCostClimbingStairs(int[] cost){
        //1.dp[i]定义: 到达第i台阶所花费的最少体力为dp[i]
        //2.状态转移方程：两个途径得到dp[i]:
            // 1). dp[i-1]跳到dp[i]需要花费dp[i-1]+cost[i-1]
            // 2). dp[i-2]跳到dp[i]需要花费dp[i-2]+cost[i-2]
            //因为我们要的是minCost，所以dp[i] = min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        //3. dp数组初始化: 题目中说："可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯"
        //   说明到达第0个和第1个台阶不花费体力，但从第0或1个台阶向上跳花费体力。 因此dp[0] = 0 dp[1] = 0
        //4. 确定遍历顺序： 从前向后
        //5. 验证

        //*由于题目要求是到达楼顶，因此我们最终要得到的结果是到达楼顶，
        // 也就是遍历完整个cost[]之后的结果，也就是到达cost.length的位置，不是cost.length-1
        //因此我们的dp[]的定义范围是[0,cost.length]
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=cost.length;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }

    //optimize space complexity
    //在dp中优化空间 一般来说就是利用滚动数组
    public int optimizedMinCostClimbingStairs(int[] cost){
        //cc
        if(cost==null||cost.length==0) return 0;
        //initialize dp array
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 0;
        int min = 0;
        for(int i=2;i<=cost.length;i++){
            min = Math.min(dp[0]+cost[i-2],dp[1]+cost[i-1]);
            dp[0] = dp[1];
            dp[1] = min;
        }
        return dp[1];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{10,15,20};
        Lc746 test = new Lc746();
        int res = test.minCostClimbingStairs(arr);
        System.out.println(res);
    }
}
