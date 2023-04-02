package DFS.Subset;

import java.util.ArrayList;
import java.util.List;

public class Lc78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        if(nums==null||nums.length==0) return res;
        res.add(new ArrayList<>());
        dfs(nums,new ArrayList<>(),0);
        return res;
    }
    public void dfs(int[] nums, List<Integer> list, int index){
        if(index==nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(nums,list,index+1);
            list.remove(list.size()-1);
        }
    }
}
