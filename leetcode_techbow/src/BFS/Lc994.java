package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Lc994 {
    public static final int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}};
    public int orangeRotting(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        //cc
        if(grid==null||grid.length==0||grid[0].length==0) return -1;
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.offer(i*col+j);
                }else if(grid[i][j]==1){
                    count++;
                }
            }
        }
        int minTime = 0;
        while(!queue.isEmpty()){
            //判断 当前是否还有新鲜的橘子，没有直接跳出，不然会多算一次次数。
            if(count==0) break;
            int size = queue.size();
            while(size-->0){
                int cur = queue.poll();
                int i = cur/col;
                int j = cur%col;
                for(int[] d:DIRECTIONS){
                    int x = d[0]+i;
                    int y = d[1]+j;
                    if(x>=0&&x<row&&y>=0&&y<col&&grid[x][y]==1){
                        queue.offer(x*col+y);
                        grid[x][y] = 2;
                        count--;
                    }
                }
            }
            minTime++;
        }
        if(count!=0) return -1;
        return  minTime;
    }
}
