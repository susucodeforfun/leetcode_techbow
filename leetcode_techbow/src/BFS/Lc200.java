package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Lc200 {
    public static final int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}};
    public int numIslands(char[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid, int gridI, int gridJ){
        Queue<Integer> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        grid[gridI][gridJ] = '0';
        queue.offer(gridI*col+gridJ);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int cur = queue.poll();
                int i = cur/col;
                int j = cur%col;
                for(int[] d:DIRECTIONS){
                    int ii = d[0]+i;
                    int jj = d[1]+j;
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&grid[ii][jj]=='1'){
                        grid[ii][jj] = '0';
                        queue.offer(ii*col+jj);
                    }
                }
            }
        }
    }
}
