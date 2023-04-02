package DFS.Partition;

import java.util.ArrayList;
import java.util.List;

public class Lc93 {
    List<String> res = new ArrayList<>();//record the result
    public List<String> restoreIpAddresses(String s){
        if(s==null||s.length()==0) return res;
        backTracking(new StringBuilder(),s,0,0);
        return res;
    }

    //techbow code
    //使用StringBuilder比拼接字符串在空间上更好

    /**
     *
     * @param sb 存储路径 storage path
     * @param index 起始位置 start index
     * @param count 记录'.'的个数 number of dot
     */
    private void backTracking(StringBuilder sb, String s, int index, int count){
        //base case:
        //success: 匹配成功
        if(index==s.length()&&count==4){
            sb.setLength(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        //failed: 加了四个'.' 但sb匹配长度为达到 target String
        if(count==4&&index<s.length()) return;
        //暂存一下sb的长度
        int len = sb.length();
        //分叉逻辑：在一个以index为起始位置，我们可以最多可以取得len=3的位置，即[index,index+1),[index,index+2),[index,index+3)
        for(int i=1;i<=3;i++){
            //如果起始位置+i 超过s.length()可以直接剪枝，此处break和return都可以 效果相同
            if(index+i>s.length()) break;
            //题目要求每段数字不能有前导0，因此当index起始位置为0，只能取0，不能向后取
            if(s.charAt(index)=='0'&&i!=1) break;
            int val = Integer.valueOf(s.substring(index,index+i));
            //小于255存入StringBuilder
            if(val<=255) {
                sb.append(val + ".");
                backTracking(sb, s, index + i, count + 1);
                sb.setLength(len);
                //数字开头是0 invalid 和 if(s.charAt(index)=='0'&&i!=1) break; 效果相同
                //if (val == 0) break;
            }
        }
    }

    //----------------------------------------------------------------
    //startIndex the start potion for search  pointNum：record the number of '.'
    public void dfs(String s, int startIndex, int pointNum){
        if(pointNum==3){// the partition ends when the point number is three.
            //check whether the 4th substring is legal. If it's legal, put it into the result
            if(isValid(s,startIndex,s.length()-1)){
                res.add(s);
            }
            return;
        }
        for(int i=startIndex;i< res.size();i++){
            if(isValid(s,startIndex,i)){
                s = s.substring(0,i+1)+"."+s.substring(i+1);
                pointNum++;
                dfs(s,i+2,pointNum);
                pointNum--;
                s = s.substring(0,i+1)+s.substring(i+2);
            }else{
                break;
            }
        }
    }

    //check whether the String s is valid in [start,end]
    public boolean isValid(String s, int start, int end){
        if(start>end) return false;
        if(s.charAt(start)=='0' && start!=end) return false; //0开头的数字不合法
        int num = 0;
        for(int i=start;i<=end;i++){
            if(s.charAt(i)>'9'||s.charAt(i)<'0') return false;
            num = num*10+(s.charAt(i)-'0');
            if(num>255) return false;
        }
        return true;
    }
}
