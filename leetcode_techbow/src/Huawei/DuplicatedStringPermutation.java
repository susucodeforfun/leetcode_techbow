package Huawei;

import java.util.*;

public class DuplicatedStringPermutation {
    List<String> res;
    public List<String> permutation(String S){
        char[] arr = S.toCharArray();
        Arrays.sort(arr);
        S = new String(arr);
        res = new ArrayList<>();
        boolean[] visited = new boolean[S.length()];
        dfs(S,new StringBuilder(),visited);
        return res;
    }

    public void dfs(String S, StringBuilder sb, boolean[] visited){
        if(sb.length()==S.length()){
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<S.length();i++){
            if(visited[i]) continue;
            sb.append(S.charAt(i));
            visited[i] = true;
            dfs(S,sb,visited);
            visited[i] = false;
            sb.setLength(sb.length()-1);
            while(i<S.length()-1 && S.charAt(i)==S.charAt(i+1)) i++;
        }
    }

    public static void main(String[] args) {
        DuplicatedStringPermutation newInstance = new DuplicatedStringPermutation();
        List<String> res = newInstance.permutation("qqe");
        for(String s:res){
            System.out.println(s);
        }
    }
}
