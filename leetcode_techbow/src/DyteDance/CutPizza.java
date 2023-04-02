package DyteDance;
/*
 Lc1444
 */
public class CutPizza {
    long mod = (long) Math.pow(10,9);
    String[] board;
    int rows;
    int cols;
    int[][] appleSum;
    public int ways(String[] pizza, int k){
        board = pizza;
        rows = pizza.length;
        cols = pizza[0].length();
        //构造一个rows行cols列大小的sum[][]board,
        // 后缀和： 记录从pizza[i][j]位置为左上角起点位置向右向下围成的区域一共有多少个苹果
        appleSum = new int[rows][cols];
        if(pizza[rows-1].charAt(cols-1)=='A') appleSum[rows-1][cols-1] = 1;
        //从右下角位置开始填值
        for(int i=rows-2;i>=0;i--){
            for(int j=cols-2;j>=0;j--){
                    appleSum[i][j] = appleSum[i+1][j]+appleSum[i][j+1]-appleSum[i+1][j+1];
            }
        }
        return (int)dfs(k-1,0,0);
    }

    /**
     * @param remain 能切的次数 初始化k-1
     * @param row
     * @param col  用比萨左上角坐标(row,col)标记披萨
     * @return
     */
    public long dfs(int remain, int row, int col){
        if(remain==0){
            if(appleSum[row][col]!=0){
                return 1;
            }else{
                return 0;
            }
        }
        long count = 0;
        /*
        //FAR: first apple row
        int FAR = getFirstAppleRow(board,row,col);
        for(int i=FAR+1;i<=rows-1;i++){
            count += dfs(remain-1,i,col)
        }
        //FAC: first apple column
        int FAC = getFirstAppleCol(board,row,col);
        for(int j=FAC;j<=col-1;j++){
            count+=dfs(remain-1,row,j);
        }
         */
        for(int i=row+1;i<rows;i++){
            if(appleSum[row][col]==appleSum[i][col]) continue;
            count += dfs(i,col,remain-1) % mod;
        }
        for(int i=row+1;i<rows;i++){
            if(appleSum[row][col]==appleSum[i][col]) continue;
            count += dfs(i,col,remain-1) % mod;
        }
        return count;
    }

    public static void main(String[] args) {
        CutPizza cutPizza = new CutPizza();
        String[] pizza = new String[]{"A..","AAA","..."};
        int res = cutPizza.ways(pizza,3);
        System.out.println(res);
    }
}
