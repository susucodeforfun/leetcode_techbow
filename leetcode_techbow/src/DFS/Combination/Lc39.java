package DFS.Combination;

import java.util.ArrayList;
import java.util.List;

public class Lc39 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        if(candidates==null||candidates.length==0||target==0) return res;
        dfs(candidates,target,new ArrayList<>(),0,0);
        return res;
    }
    public void dfs(int[] candidates, int target, List<Integer> list, int sum, int index){
        if(sum==target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(index>=candidates.length||sum>target) return;
        for(int i=index;i<candidates.length;i++){
            list.add(candidates[i]);
            dfs(candidates,target,list,sum+candidates[i],i);
            list.remove(list.size()-1);
        }
    }
}
