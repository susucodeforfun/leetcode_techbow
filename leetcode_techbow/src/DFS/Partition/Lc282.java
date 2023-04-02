package DFS.Partition;

import java.util.ArrayList;
import java.util.List;

public class Lc282 {
    List<String> res;
    public List<String> addOperators(String num, int target){
            res = new ArrayList<>();
            if(num==null||num.length()==0) return res;
            dfs(num,target,new StringBuilder(),0,0,0);
            return res;
    }
    public void dfs(String num, int target, StringBuilder path, int startIndex, long curRes, long pre){
        //base case
        if(startIndex==num.length() && curRes==target){
            res.add(path.toString());
            return;
        }
        for(int i=startIndex;i<num.length();i++){
            //不能以0开头
            if(num.charAt(startIndex)=='0' && i>startIndex){
                break;
            }
            long curVal = Long.parseLong(num.substring(startIndex,i+1));
            int len = path.length();
            //取第一个数字时不需要加符号
            if(startIndex==0){
                dfs(num,target,path,i+1,curVal,curVal);
            }else{
                //+
                path.append('+').append(curVal);
                dfs(num,target,path,i+1,curRes+curVal,curVal);
                path.setLength(len);
                //-
                path.append('-').append(curVal);
                dfs(num,target,path,i+1,curRes-curVal,-curVal);
                path.setLength(len);
                //*
                path.append('*').append(curVal);
                dfs(num,target,path,i+1,curRes-pre+pre*curVal,pre*curVal);
                path.setLength(len);
            }
        }
    }
}
