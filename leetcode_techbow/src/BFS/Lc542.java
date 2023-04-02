package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Lc542 {
    public static final int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        Queue<Integer> queue = getZero(mat);
        boolean[][] visited = new boolean[row][col];
        int minLen = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                int cur = queue.poll();
                int i = cur/col;
                int j = cur%col;
                for(int[] d:DIRECTIONS){
                    int ii = d[0]+i;
                    int jj = d[1]+j;
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&mat[ii][jj]==1&&!visited[ii][jj]){
                        queue.offer(ii*col+jj);
                        mat[ii][jj] = minLen;
                        visited[ii][jj] = true;
                    }
                }
            }
            minLen++;
        }
        return mat;
    }
    public Queue<Integer> getZero(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
                    queue.offer(i*col+j);
                }
            }
        }
        return queue;
    }
}
