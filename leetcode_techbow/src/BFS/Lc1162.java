package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Lc1162 {
    public static final int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}};
    public int maxDistance(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> queue = getLands(grid);
        if(queue.size()==0 || queue.size()==row*col) return -1;
        boolean[][] visited = new boolean[row][col];
        int maxLen = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                int cur = queue.poll();
                int i = cur/col;
                int j = cur%col;
                for(int[] d:DIRECTIONS){
                    int ii = d[0]+i;
                    int jj = d[1]+j;
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&grid[ii][jj]==0&&!visited[ii][jj]){
                        queue.offer(ii*col+jj);
                        visited[ii][jj] = true;
                    }
                }
            }
            maxLen++;
        }
        return maxLen;
    }
    public Queue<Integer> getLands(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    queue.offer(i*col+j);
                }
            }
        }
        return queue;
    }
}
