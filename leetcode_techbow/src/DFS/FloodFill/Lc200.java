package DFS.FloodFill;

public class Lc200 {
    public static final int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}};
    public int numIslands(char[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        int row = grid.length;
        int col = grid[0].length;
        grid[i][j] = '0';
        for(int[] d:DIRECTIONS){
            int x = d[0]+i;
            int y = d[1]+j;
            if(x>=0&&y>=0&&x<row&&y<col&&grid[x][y]=='1'){
                dfs(grid,x,y);
            }
        }
    }
}
