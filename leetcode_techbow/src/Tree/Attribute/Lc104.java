package Tree.Attribute;

import Tree.TreeNode;

//二叉树的最大深度
//前序遍历求深度 后续遍临求高度
// 二叉树节点的深度：从根结点到该节点的最长简单路径边的条数或节点数(取决于深度从0开始还是从1开始）
// 二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数或节点数(取决于高度从0开始还是从1开始）

public class Lc104 {

    //后序遍历： 先求左子树高度 再求右子树高度 最后取左右子树高度的最大值再+1
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }

    //前序遍历：
    //global variable
    int res;
    public int maxDepth2(TreeNode root){
        res = 0;
        if(root==null) return res;
        getDepth(root,1);
        return res;
    }

    public void getDepth(TreeNode root, int depth){
        if(root.left==null && root.right==null){
            res = Math.max(res,depth);
        }
        if(root.left!=null){
            getDepth(root.left,depth+1);
        }
        if(root.right!=null){
            getDepth(root.right,depth+1);
        }
    }

}
