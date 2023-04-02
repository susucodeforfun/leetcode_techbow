package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Lc317 {
    private static final int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestDistance(int[][] grid){
        //思路： 维护一个2D array cost[][] 利用bfs 求出2D board中
        //每个位置与所有1的距离之和 最后遍历这个2D array cost[][] 取最小值
        int row = grid.length;
        int col = grid[0].length;
        int[][] cost = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    bfs(grid,i,j,cost);
                }
            }
        }
        for(int i=0;i<row;i++){
            System.out.println();
            for(int j=0;j<col;j++){
                System.out.print(grid[i][j]);
            }
        }
        System.out.println();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0 && cost[i][j]>0){
                    min = Math.min(min,cost[i][j]);
                }
            }
        }
        return min==Integer.MAX_VALUE? -1:min;
    }
    public void bfs(int[][] grid, int gridI, int gridJ, int[][] cost){
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        queue.offer(gridI*col+gridJ);
        int minLen = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int cur = queue.poll();
                int i = cur/col;
                int j = cur%col;
                for(int[] d : DIRECTIONS){
                    int ii = d[0]+i;
                    int jj = d[1]+j;
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&grid[ii][jj]==0&&!visited[ii][jj]){
                        queue.offer(ii*col+jj);
                        visited[ii][jj] = true;
                        cost[ii][jj]+=minLen;
                    }
                }
            }
            minLen++;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    grid[i][j] = 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        Lc317 lc = new Lc317();
        int[][] grid = new int[][]{{1,2,2,1},{0,0,2,0},{1,0,2,0}};
        lc.shortestDistance(grid);
    }
}
