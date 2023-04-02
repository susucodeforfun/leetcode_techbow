package Tree.Attribute;

import Tree.TreeNode;

public class Lc111 {
    public int minDepth(TreeNode root){
        //求高度
        //后序遍历，先recursion 后办事
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(root.left==null && root.right!=null){
            return right+1;
        }
        if(root.right==null && root.left!=null){
            return left+1;
        }
        return 1 + Math.min(left,right);
    }

    int res;
    public int minDepth2(TreeNode root){
        //求深度
        //前序遍历，先办事后recursion
        if(root==null) return 0;
        res =  Integer.MAX_VALUE;
        minDepthHelper(root,1);
        return res;
    }
    public void minDepthHelper(TreeNode root, int depth){
        if(root.left==null&&root.right==null){
            res = Math.min(depth,res);
            return;
        }
        if(root.left!=null){
            minDepthHelper(root.left,depth+1);
        }
        if(root.right!=null) {
            minDepthHelper(root.right, depth + 1);
        }
    }
}
