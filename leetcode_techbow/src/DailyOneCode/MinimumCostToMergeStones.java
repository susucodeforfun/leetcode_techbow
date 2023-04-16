package DailyOneCode;

public class MinimumCostToMergeStones {
    //method1: dfs
    //定义dfs(i,j,p): 表示stones[i]到stones[j]合并成p堆的最低成本
    //目标计算 dfs(0,6,1) = dfs(0,6,3) +  ∑(i=0,6)stones[i]
    // dfs(0,6,3) 可以分成以下几种情况的minimum
    //dfs(0,0,1)+dfs(1,6,2)
    //dfs(0,2,1)+dfs(3,6,2)
    //dfs(0,4,1)+dfs(5,6,2)
    //Generally:
    //dfs(i,j,1) = dfs(i,j,k) + ∑(x=i,j)stones[x] 子数组可以用前缀和优化
    //dfs(i,j,p) = min

    //递归边界 dfs(i,i,1) = 0;
    //递归入口 dfs(0,n-1,1)
    //return -1的情况 从n堆merge成1堆，需要减少n-1堆，每次合并都会减少k-1堆 因此 n-1是k-1的倍数

    //前缀和
    public int[] prefixSum;
    public int mergeStones1(int[] stones, int k){
        int len = stones.length;
        if((len-1)%(k-1)!=0) return -1; //无法合并成一堆
        prefixSum = new int[len];
        prefixSum[0] = stones[0];
        for(int i=1;i<len;i++){
            prefixSum[i] = prefixSum[i-1]+stones[i];
        }
        return dfs(0,len-1,k);
    }
    public int dfs(int i, int j, int k){
        if(k==1){
            if(i==j) return 0;
            else return dfs(i,j,k)+prefixSum[j+1]-prefixSum[i];
        }
        int res = Integer.MAX_VALUE;
        for(int a = i;a<=j;a+= k-1){
            res = Math.min(res,dfs(i,a,1)+dfs(a+1,j,k-1));
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumCostToMergeStones newInstance = new MinimumCostToMergeStones();
        int res = newInstance.mergeStones1(new int[]{3,5,1,2,6},3);
        System.out.println(res);
    }

    // dp[i,j]定义：merge stones[i,j]的最小cost
    // 递推公式： dp[i,j] = Min(dp[i,j],dp[i+1,j]+stones[i])
    /*
    public int mergeStones2(int[] stones, int k){
        int[] dp = new int[];

    }
     */
}
