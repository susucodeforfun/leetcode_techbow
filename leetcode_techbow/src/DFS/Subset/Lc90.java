package DFS.Subset;

import java.util.ArrayList;
import java.util.List;

public class Lc90 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums){
        if(nums==null||nums.length==0) return res;
        res.add(new ArrayList<Integer>());
        dfs(nums,new ArrayList<Integer>(),0);
        return res;
    }
    public void dfs(int[] nums, List<Integer> list, int index){
        if(index==nums.length) return;
        for(int i=index;i<nums.length;i++){
            if(i!=index&&nums[i]!=nums[i-1]){
                list.add(nums[i]);
                res.add(new ArrayList<>(list));
                dfs(nums,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
