package DFS.Combination;

import java.util.ArrayList;
import java.util.List;

public class Lc216 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k,int n){
        //cc
        dfs(new ArrayList<>(),k,n,0,1);
        return res;
    }
    public void dfs(List<Integer> list, int k, int n, int sum,int startIndex){
        if(k==0 && sum==n){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum>n||k<=0) return;
        for(int i=startIndex;i<=9;i++){
            list.add(i);
            dfs(list,k-1,n,sum+i,i+1);
            list.remove(list.size()-1);
        }
    }
}
