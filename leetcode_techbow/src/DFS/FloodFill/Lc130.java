package DFS.FloodFill;

public class Lc130 {
    public static final int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}};
    public void solve(char[][] board){
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][col-1]=='O') dfs(board,i,col-1);
        }
        for(int j=0;j<col;j++){
            if(board[0][j]=='O') dfs(board,0,j);
            if(board[row-1][j]=='O') dfs(board,row-1,j);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board,int i,int j){
        int row = board.length;
        int col = board[0].length;
        board[i][j] = '#';
        for(int[] d:DIRECTIONS){
            int x = d[0]+i;
            int y = d[1]+j;
            if(x>=0&&x<row&&y>=0&&y<col&&board[x][y]=='O'){
                dfs(board,x,y);
            }
        }

    }
}
