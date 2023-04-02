package DFS.Subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 题目要我们去找在一个数组中的非递减子序列，并且子序列不能重复
// 子集+去重 类似Lc90题 在90题中 我们通过排序+标记数组达到去重目的
// 但本题中无法对数组进行排序，因为排序后数组都是自增子序列
public class Lc491 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums){
        if(nums==null||nums.length==0) return res;
        dfs(nums,new ArrayList<Integer>(),0);
        return res;
    }
    public void dfs(int[] nums,List<Integer> list, int index){
        if(list.size()>=2){
            res.add(new ArrayList<>(list));
        }
        //使用hashset进行去重，由于子序列不能重复，所以在当前层相同数字只能用一次
        //hashset是记录本层是否有重复元素使用，因此每一层都重新定义进行去重
        //在dfs回溯中，从树形结构来看，recursion是纵向遍历，往深走。for loop是横向遍历。
        HashSet set = new HashSet();
        for(int i=index;i<nums.length;i++) {
            if (!list.isEmpty() && nums[i] < list.get(list.size() - 1)) {
                continue;
            }
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            list.add(nums[i]);
            dfs(nums, list, i + 1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Lc491 lc = new Lc491();
        int[] nums = {4,4,3,2,1};
        List<List<Integer>> res = lc.findSubsequences(nums);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
