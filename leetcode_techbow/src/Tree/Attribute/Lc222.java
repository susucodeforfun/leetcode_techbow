package Tree.Attribute;

import Tree.TreeNode;

//完全二叉树的节点个数
public class Lc222 {

    //按普通二叉树来做
    public int countNode(TreeNode root){
        if(root==null) return 0;
        int left = countNode(root.left);
        int right = countNode(root.right);
        return left+right+1;
    }

    //根据完全二叉树的性质：
    //完全二叉树只有两种情况： 1. 满二叉树 2.最后一层叶子节点没有满
    //情况1 可以直接用2^树的深度-1

}
