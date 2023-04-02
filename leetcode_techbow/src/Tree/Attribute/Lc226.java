package Tree.Attribute;

import Tree.TreeNode;

//反转一颗二叉树 就是将一个节点的左右孩子进行交换
//遍历顺序可以选择前序遍历或后续遍历

public class Lc226 {
    //前序遍历反转二叉树： 先办事后recursion，先交换左右节点再反转左右子树
    public TreeNode invertTreePreorder(TreeNode root){
        if(root==null) return root;
//      TreeNode temp = root.left;
//      root.left = root.right;
//      root.right = temp;
        swap(root);
        invertTreePreorder(root.left);
        invertTreePreorder(root.right);
        return root;
    }
    //后续遍历反转二叉树： 先recursion后办事
    public TreeNode invertTreePostorder(TreeNode root){
        if(root==null) return root;
        invertTreePostorder(root.left);
        invertTreePostorder(root.right);
        swap(root);
        return root;
    }
    public void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
