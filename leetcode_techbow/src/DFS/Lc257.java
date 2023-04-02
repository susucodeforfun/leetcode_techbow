package DFS;

import java.util.ArrayList;
import java.util.List;

public class Lc257 {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root){
        res = new ArrayList<>();
        dfs(root,new StringBuilder());
        return res;
    }

    /**
     *
     * @param root
     * @param path 记录分叉路径
     * 做dfs题目一定要注意是否需要setback
     */

    //先判断 后dfs
    public void dfs(TreeNode root, StringBuilder path){
        int len = path.length();
        //base case：当current node的left right node均为null
        //说明 current node is leaf node, 存该path
        if(root.left==null&&root.right==null) {
            path.append(root.val);
            res.add(path.toString());
            //存完后，需要将path setback
            path.setLength(len);
            return;
        }
        path.append(root.val+"->");
        //由于我们的base case是 check 是否是leaf node 不是check 是否是null
        //因此 在recursion时要提前判断
        //check if left node is null
        if(root.left!=null){
            dfs(root.left,path);
        }
        //check if right node is null
        if(root.right!=null){
            dfs(root.right,path);
        }
        path.setLength(len);
    }

    //method 2： 先dfs后判断
    public void dfs2(TreeNode root, StringBuilder path){
        //base case:
        if(root==null) return;
        int len = path.length();
        if(root.left==null&&root.right==null){
            path.append(root.val);
            res.add(path.toString());
            path.setLength(len);
        }else{
            path.append(root.val+"->");
            dfs2(root.left,path);
            path.setLength(len);
        }
    }
}
