package DFS;

public class Lc79 {
    public static int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}};
    public boolean exist(char[][] board, String word){
        if(board==null||board.length==0||board[0]==null||board[0].length==0) throw new IllegalArgumentException();
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

    private boolean dfs(char[][] board, int boardI, int boardJ, String word, int index, boolean[][] visited){
        int row = board.length;
        int col = board[0].length;
        if(index==word.length()-1) return word.charAt(index)==board[boardI][boardJ];
        if(board[boardI][boardJ]==word.charAt(index)){
            visited[boardI][boardJ] = true;
            for(int[] d:DIRECTIONS){
                int i = d[0]+boardI;
                int j = d[1]+boardJ;
                if(i>=0||i<row||j>=0||j<col||!visited[i][j]){
                    if(dfs(board,i,j,word,index+1,visited)) return true;
                }
            }
            visited[boardI][boardJ] = false;
        }
        return false;
    }
}
