package DFS.FloodFill;

import java.util.HashSet;

public class Lc694 {
    HashSet<String> res;
    public int numDistinctIslands(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        if(grid==null||row==0||grid[0]==null||col==0) throw new IllegalArgumentException();
        res = new HashSet<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    StringBuilder path = new StringBuilder();
                    dfs(grid,i,j,path,'s');
                    res.add(path.toString());
                }
            }
        }
        return res.size();
    }

    public void dfs(int[][] grid, int i, int j, StringBuilder path, char c){
        int row = grid.length;
        int col = grid[0].length;
        if(i<0||i>=row||j<0||j>=col||grid[i][j]==0) return;
        grid[i][j] = 0;
        path.append(c);
        //up
        dfs(grid,i-1,j,path,'u');
        //right
        dfs(grid,i,j+1,path,'r');
        //down
        dfs(grid,i+1,j,path,'d');
        //left
        dfs(grid,i,j-1,path,'l');
        path.append('b');
    }
}
