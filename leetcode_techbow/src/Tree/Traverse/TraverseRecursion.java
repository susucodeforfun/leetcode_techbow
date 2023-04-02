package Tree.Traverse;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TraverseRecursion {
    //二叉树的递归遍历
    //1. 确定递归函数的参数和返回值
    //2. 确定终止条件
    //3. 确定单层递归的逻辑
    List<Integer> res = new ArrayList<>();
    public List<Integer> preOrder(TreeNode root){
        //base case
        if(root==null) return res;
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
        return res;
    }

    public List<Integer> inOrder(TreeNode root){
        //base case
        if(root==null) return res;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
        return res;
    }

    public List<Integer> postOrder(TreeNode root){
        if(root==null) return res;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
        return res;
    }
}
