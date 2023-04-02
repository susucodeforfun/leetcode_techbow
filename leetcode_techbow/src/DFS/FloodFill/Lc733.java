package DFS.FloodFill;

public class Lc733 {
    public static final int[][] DIRECTIONS = {{0,-1},{1,0},{0,1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        int row = image.length;
        int col = image[0].length;
        //boolean[][] visited = new boolean[row][col];
        int preColor = image[sr][sc];
        dfs(image,sr,sc,color,preColor);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color, int preColor){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=preColor){
            return;
        }
        if(image[sr][sc]==preColor){
            image[sr][sc] = color;
            //visited[sr][sc] = true;
        }
        dfs(image,sr-1,sc,color,preColor);
        dfs(image,sr,sc+1,color,preColor);
        dfs(image,sr+1,sc,color,preColor);
        dfs(image,sr,sc-1,color,preColor);
    }

    public void dfs2(int[][] image, int i, int j, int originColor, int color){
        image[i][j] = color;
        int row = image.length;
        int col = image[0].length;
        for(int[] direction : DIRECTIONS){
            int x = direction[0]+i;
            int y = direction[1]+j;
            if((x<0||y<0||x>=row||y>=col)&&image[x][y]==originColor){
                dfs2(image,x,y,originColor,color);
            }
        }
    }
}
