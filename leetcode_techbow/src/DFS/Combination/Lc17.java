package DFS.Combination;

import java.util.ArrayList;
import java.util.List;

public class Lc17 {
    String[] dir = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits){
        //cc
        if(digits==null||digits.length()==0) return res;
        dfs(digits,0,new StringBuilder());
        return res;
    }
    public void dfs(String digits,int index,StringBuilder sb){
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        int i = digits.charAt(index)-'0';
        for(char c:dir[i].toCharArray()){
            sb.append(c);
            dfs(digits,i+1,sb);
            sb.setLength(sb.length()-1);
        }
    }
}
