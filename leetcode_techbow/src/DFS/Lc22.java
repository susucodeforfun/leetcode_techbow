package DFS;

import java.util.ArrayList;
import java.util.List;

public class Lc22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n){
        if(n<=0) throw new IllegalArgumentException();
        dfs(new StringBuilder(),n,0);
        return res;
    }

    private void dfs(StringBuilder sb, int n, int delta){
        //base case
        if(sb.length()==2*n && delta==0){
            res.add(sb.toString());
            return;
        }
        if(delta<0 || sb.length()>=2*n || delta>n){
            return;
        }
        //add '('
        sb.append('(');
        dfs(sb,n,delta+1);
        sb.setLength(sb.length()-1);
        //add ')'
        sb.append(')');
        dfs(sb,n,delta-1);
        sb.setLength(sb.length()-1);
    }
}
