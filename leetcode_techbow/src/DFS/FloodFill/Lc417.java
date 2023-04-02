package DFS.FloodFill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc417 {
    public static final int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights){
        int row = heights.length;
        int col = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        //cc
        if(heights==null||row==0||col==0) return res;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for(int i=0;i<row;i++){
            dfs(heights,i,0,pacific);
            dfs(heights,i,col-1,atlantic);
        }
        for(int j=1;j<col-1;j++){
            dfs(heights,0,j,pacific);
            dfs(heights,row-1,j,atlantic);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j]&&atlantic[i][j]){
                    //public static <T> List<T> asList(T... a)
                    //因此不能将原生数据类型的数组作为Arrays.asList()的参数
                    res.add(Arrays.asList(new Integer[] {i,j}));
                }
            }
        }
        return res;
    }
    public void dfs(int[][] heights, int i, int j, boolean[][] visited){
        int row = heights.length;
        int col = heights[0].length;
        visited[i][j] = true;
        for(int[] d:DIRECTIONS){
            int x = d[0]+i;
            int y = d[0]+j;
            if(x>=0&&x<row&&y>=0&&y<col&&!visited[x][y]&&heights[x][y]>=heights[i][j]){
                dfs(heights,x,y,visited);
            }
        }
    }
}
