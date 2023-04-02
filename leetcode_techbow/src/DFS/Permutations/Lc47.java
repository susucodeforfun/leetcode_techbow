package DFS.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Lc47 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums){
        if(nums==null||nums.length==0) return res;
        boolean[] visited = new boolean[nums.length];
        dfs(nums,new ArrayList<Integer>(),visited);
        return res;
    }
    public void dfs(int[] nums, List<Integer> list, boolean[] visited){
        if(nums.length==list.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //visited[i-1]=false 说明同一树层nums[i-1]使用过
            //visited[i-1]=true 说明同一树枝nums[i-1]使用过
            //对于排列问题，树层上去重和树枝上去重都可以，但树层去重效率更高
            if(i!=0 && nums[i]==nums[i-1] && !visited[i]) continue;
            //同一树枝nums[i]访问过 直接跳过
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums,list,visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
