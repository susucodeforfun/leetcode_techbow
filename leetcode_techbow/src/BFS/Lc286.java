package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Lc286 {
    public static final int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}};
    public void wallAndGates(int[][] rooms){
        int row = rooms.length;
        int col = rooms[0].length;
        //cc
        if(rooms==null || rooms.length==0 || rooms[0].length==0) return;
        Queue<Integer> queue = getGates(rooms);
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
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&rooms[ii][jj]==Integer.MAX_VALUE){
                        rooms[ii][jj] = minLen;
                        queue.offer(ii*col+jj);
                    }
                }
            }
            minLen++;
        }
    }

    public Queue<Integer> getGates(int[][] rooms){
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rooms[i][j]==0){
                    queue.offer(i*col+j);
                }
            }
        }
        return queue;
    }
}
