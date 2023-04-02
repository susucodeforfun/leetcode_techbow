package DFS.Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc40 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSumII(int[] candidates, int target){
        if(candidates==null||candidates.length==0||target==0) return res;
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),0,0);
        return res;
    }
    public void dfs(int[] candidates, int target,List<Integer> list, int startIndex,int sum){
        if(sum==target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum>target||startIndex>=candidates.length) return;
        for(int i=startIndex;i<candidates.length;i++){
            if(i!=startIndex && candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            dfs(candidates,target,list,i+1,sum+candidates[i]);
            list.remove(list.size()-1);
        }
    }
}
