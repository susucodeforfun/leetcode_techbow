package DFS;

public class Offer47 {
    //礼物的最大价值
    //dp[i][j]:在ij位置能拿到的最大value
    public static int maxValue(int[][] grid){
        //cc
        if(grid==null||grid.length==0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        //初始化dp
        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for(int i=1;i<row;i++){
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }
        for(int j=1;j<col;j++){
            dp[0][j] = grid[0][j]+dp[0][j-1];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j] = Math.max(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
               System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return grid[row-2][col-2];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
    }

}
