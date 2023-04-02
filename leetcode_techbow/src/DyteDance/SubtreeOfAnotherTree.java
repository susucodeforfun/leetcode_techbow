package DyteDance;

import Tree.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(isSameTree(root.left,subRoot)) return true;
        if(isSameTree(root.right,subRoot)) return true;
        isSubtree(root.left,subRoot);
        isSubtree(root.right,subRoot);
        return false;
    }
    public boolean isSameTree(TreeNode root1,TreeNode root2){
        //base case
        if(root1==null && root2==null) return true;
        if(root1.val!=root2.val) return false;
        if(root1==null || root2==null) return false;
        boolean left = isSameTree(root1.left,root2.left);
        boolean right = isSameTree(root2.right,root2.right);
        return left&&right;
    }
}
