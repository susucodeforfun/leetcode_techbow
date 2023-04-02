package DFS.Combination;

import java.util.ArrayList;
import java.util.List;

public class Lc77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k){
        //cc
        if(k<=0||n<k) return res;
        dfs(new ArrayList<>(),n,k,1);
        return res;
    }

    public void dfs(List<Integer> list,int n,int k,int startIndex){
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        //在对n进行遍历时，可以进行优化：
        //对搜索起点的上界进行剪枝
        for(int i=startIndex;i<=n;i++){
            list.add(i);
            dfs(list,n,k,i+1);
            list.remove(list.size()-1);
        }
    }

    public void optimizedDfs(List<Integer> list,int n,int k,int startIndex){
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        //例如：n=7 k=4时，从5开始搜索就已经没意义了，即使选了5后面只有6和7，凑不出4个所以可以进行剪枝
        //for example, n=6, k=4, path.size()=1时，选3个数，搜索起点最大是4，最后一组被选的组合是[4,5,6]
        //因此：搜索起点的上界+接下来要选择的元素个数-1 = n  4+3-1 = 6
        //接下来要选择的元素个数 = k-path.size()
        //可以得到：搜索起点的上界：n-(k-path.size())+1
        for(int i=startIndex;i<=n-(k-list.size()+1);i++){
            list.add(i);
            dfs(list,n,k,i+1);
            list.remove(list.size()-1);
        }
    }
}
