package DFS.Partition;

import java.util.ArrayList;
import java.util.List;

public class Lc282Demo {
    List<String> res;
    public List<String> addOperators(String num, int target){
        res = new ArrayList<>();
        if(num==null||num.length()==0) return res;
        dfs(num,target,new StringBuilder(),0,0,0);
        return res;
    }

    public void dfs(String num, int target, StringBuilder path, int startIndex, long curRes, long pre){
        //base case:
        //num全部匹配完，并且curRes==target,将path存入res
        //此处无法通过curRes和target的大小关系进行剪枝，即使curRes>target，后面做减法也可能满足curRes==target
        if(startIndex==num.length() && curRes==target){
                res.add(path.toString());
                //path.setLength(len);
                return;
        }
        for(int i=startIndex;i<num.length();i++){
            //数字不能以0开头
            if(num.charAt(startIndex)=='0'&&i>startIndex) break;
            //获取当前数值
            long curVal = Long.parseLong(num.substring(startIndex,i+1));
            //记录the length of path
            int len = path.length();
            //取第一个数字不需要加符号
            if(startIndex==0){
                dfs(num,target,path,i+1,curRes+curVal,curVal);
            }else{
                //add operation
                path.append("+").append(curVal);
                dfs(num,target,path,i+1,curRes-curVal,curVal);
                path.setLength(len);
                //minus operation
                path.append("-").append(curVal);
                dfs(num,target,path,i+1,curRes-curVal,-curVal);
                path.setLength(len);
                //times operation
                path.append("*");
                dfs(num,target,path,i+1,curRes-pre+pre*curVal,pre*curVal);
                path.setLength(len);
            }
        }
    }
}
