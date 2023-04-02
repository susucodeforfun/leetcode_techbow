package Tree.Attribute;

import Tree.TreeNode;

public class Lc101 {
    //判断是否是对称二叉树，只能通过后续遍历。因为需要通过左右子树的递归函数返回值来判断两个子树的内侧节点和外侧节点是否相等

    //1. 确定参数和返回值： 因为要比较的是根结点的两个子树是否是对称的，从而判断这个树是否是对称的，因此参数是左右子树

    public boolean isSymmetric(TreeNode root){
        if(root==null) return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null||right==null) return false;
        if(left.val!=right.val) return false;
        return dfs(left.left,right.right)&&dfs(left.right,right.left);
    }
}
