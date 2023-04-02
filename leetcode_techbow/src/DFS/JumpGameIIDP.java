package DFS;

public class JumpGameIIDP {
    /**
     * dp
     * dp[i] 当前位置最少走几步可以到达
     * 思路:在dp[i]的位置向前找所有能够到达dp[i]可能，更新dp[i]的最小值
     * 两层for-loop,第一层从i:[1,dp.length-1] 第二层向前找所有可能的位置：[
     * @param nums
     * @return
     */
    public static int jump(int[] nums){
        //cc
        int len = nums.length;
        if(len<=1) return 0;
        //初始化 dp array
        int[] dp = new int[len];
        dp[0] = 0;
        for(int i=1;i<len;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(j+nums[j]>=i){
                    dp[i] = Math.min(dp[j]+1,dp[i]);
                }
            }
        }
        return dp[len-1];
    }

    /**
     * dp[i] 当前位置最少走几步可以到达
     * 第一种方法是在当前位置向前找
     * 我们还可以从起始位置开始，更新所有可以到达的位置
     * 当到达的位置超过了nums.length-1 返回dp[len-1]
     * @param nums
     * @return
     */
    public static int jump2(int[] nums){
        int len = nums.length;
        if(len<=1) return 0;
        //initialization
        int[] dp = new int[len];
        dp[0] = 0;
        for(int i=1;i<len;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<len;i++){
            int distance = nums[i];
            for(int j=1;j<distance;j++){
                if(i+j>len-1){
                    return dp[len-1];
                }
                dp[i+j] = Math.min(dp[i]+1,dp[i+j]);
            }
        }
        return dp[len-1];
    }


    public static void main(String[] args) {
        int res1 = JumpGameIIDP.jump(new int[]{2,3,1,1,4});
        int res2 = JumpGameIIDP.jump2(new int[]{2,3,1,1,4});
        System.out.println(res1);
        System.out.println(res2);
    }
}
