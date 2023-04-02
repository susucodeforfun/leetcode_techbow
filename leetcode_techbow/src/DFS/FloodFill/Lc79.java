package DFS.FloodFill;

public class Lc79 {
    public static final int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}};
    public boolean exist(char[][] board, String word){
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dfs(board,i,j,word,0,visited)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j,String word, int index, boolean[][] visited){
        int row = board.length;
        int col = board[0].length;
        if(index==word.length()) return true;
        if(board[i][j]==word.charAt(index)){
            visited[i][j] = true;
            for(int[] direction:DIRECTIONS){
                int x = direction[0]+i;
                int y = direction[1]+j;
                if(x>=0&&y>=0&&x<row&&y<col&&!visited[x][y]){
                    if(dfs(board,x,y,word,index+1,visited)) return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    public boolean dfs2(char[][] board, int i, int j, String word, int index, boolean[][] visited){
        int row = board.length;
        int col = board[0].length;
        if(index==word.length()) return true;
        if(i<0||i>=row||j<0||j>=col||visited[i][j]||board[i][j]!=word.charAt(index)) return false;
        visited[i][j] = true;
        boolean res = dfs2(board,i-1,j,word,index+1,visited)
                ||dfs2(board,i,j+1,word,index+1,visited)
                ||dfs2(board,i+1,j,word,index+1,visited)
                ||dfs2(board,i,j-1,word,index+1,visited);
        visited[i][j] = false;
        return res;
    }
}
