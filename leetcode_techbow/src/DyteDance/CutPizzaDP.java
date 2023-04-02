package DyteDance;

public class CutPizzaDP {
    /**
     * dp[i][j][k]: 右上角定点坐标为(x,y)且需要分配的人数为k时 一共有多少种切法
     * @param pizza
     * @param k
     * @return
     */
    public int ways(String[] pizza, int k){
        int mod = (int)Math.pow(10,9)+7;
        int row = pizza.length;
        int col = pizza[0].length();
        int[][][] dp = new int[row][col][k+1];
        //苹果数量的前缀和，用来快速获得指定矩阵范围内的苹果树
        //多开了一行一列是因为每次计算[i,j]位置是根据[i+1,j]和[i，j+1]得到的，
        // 因此在[row-1,j]和[i,col-1]位置需要从[row,j]和[i,col]位置获取值
        int[][] appleSum = new int[row+1][col+1];
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                appleSum[i][j] = pizza[i].charAt(j)=='A'? 1:0;
                appleSum[i][j] += (appleSum[i+1][j]+appleSum[i][j+1]-appleSum[i+1][j+1]);
            }
        }
        //从右下角开始枚举所有状态
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(appleSum[i][j]>0){
                    dp[i][j][1] = 1;
                }
                for(int a=2;a<=k;a++){
                    //横切
                    for(int x=row-1-i;x>=1;x--){
                        if(appleSum[i][j]-appleSum[i+x][j]>0){
                            dp[i][j][a] = (dp[i][j][a]+dp[i+x][j][a-1])%mod;
                        }
                    }
                    //竖切
                    for(int y=col-1-j;y>=1;y--){
                        if(appleSum[i][j]-appleSum[i][j+y]>0){
                            dp[i][j][a] = (dp[i][j][a]+dp[i][j+y][a-1])%mod;
                        }
                    }
                }
            }
        }
        return dp[0][0][k];
    }

    public static void main(String[] args) {
        CutPizza cutPizza = new CutPizza();
        String[] pizza = new String[]{"A..","AAA","..."};
        int res = cutPizza.ways(pizza,3);
        System.out.println(res);
    }
}
