package DFS.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Lc46 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> Permute(int[] nums){
        if(nums==null||nums.length==0) return res;
        boolean[] visited = new boolean[nums.length];
        dfs(nums,new ArrayList<Integer>(),visited);
        return  res;
    }
    public void dfs(int[] nums, List<Integer> list, boolean[] visited){
        if(list.size()==nums.length) {
            res.add(new ArrayList<>(list));
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums,list,visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
