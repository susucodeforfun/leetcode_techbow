package DFS.Subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc301 {

    Set<String> res;
    public List<String> removeInvalidParentheses(String s){
        
        res = new HashSet<>();
        if(s==null || s.length()==0) return new ArrayList<>(res);
        int left = 0;
        int right = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') left++;
            else if(c==')'){
                if(left>0) left--;
                else right++;
            }
        }
        dfs(s,new StringBuilder(),0,left,right,0);
        return new ArrayList<>(res);
    }

    /*
        @param s: 题目中给出的字符串
        @param path： 存放分叉路径
        @param index: 记录当前搜索到的位置
        @param left: 多出左括号的个数
        @param right: 多出右括号的个数
        @param delta: 记录当前path中左右括号的差值
     */
    public void dfs(String s, StringBuilder path, int index, int left, int right, int delta){
        //base case
        if(index==s.length()&&left==0&&right==0&&delta==0){
            res.add(path.toString());
            return;
        }
        if(index>=s.length() || left<0 || right<0 ||delta<0) return;
        char c = s.charAt(index);
        if(c=='('){
            //remove '('
            dfs(s,path,index+1,left-1,right,delta);
            //Do not remove '('
            path.append('(');
            dfs(s,path,index+1,left,right,delta+1);
            path.setLength(path.length()-1);
        }else if(c==')'){
            //remove ')'
            dfs(s,path,index+1,left,right-1,delta);
            //Do not remove ')'
            path.append(')');
            dfs(s,path,index+1,left,right,delta-1);
            path.setLength(path.length()-1);
        }else{
            path.append(c);
            dfs(s,path,index+1,left,right,delta);
            path.setLength(path.length()-1);
        }
    }
}
