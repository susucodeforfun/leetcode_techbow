package ZeroToThousand;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> res;
    public List<String> generateParenthesis(int n){
        res = new ArrayList<>();
        dfs(new StringBuilder(),n,0,0,0);
        return res;
    }
    public void dfs(StringBuilder sb, int n, int left, int right, int delta){
        //base case
        if(2*n==left+right && delta==0){
            res.add(sb.toString());
            return;
        }
        if(delta<0 || left>n || right>n) return;
        //add '('
        sb.append('(');
        dfs(sb,n,left+1,right,delta+1);
        sb.setLength(sb.length()-1);
        //add ')'
        sb.append(')');
        dfs(sb,n,left,right+1,delta-1);
        sb.setLength(sb.length()-1);
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> res = gp.generateParenthesis(3);
        System.out.println(res);
    }
}
