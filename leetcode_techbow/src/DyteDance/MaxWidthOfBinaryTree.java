package DyteDance;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {
    /*
    public int widthOfBinaryTree(TreeNode root){
        //cc
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = getHeight(root);
        int curHeight = 1;
        int maxWidth = 0;
        while(curHeight<=height){
            int size = queue.size();
            int startIndex = 0;
            int endIndex = 0;
            int index = 0;
            while(size-->0){
                TreeNode cur = queue.poll();
                queue.offer(cur.left);
                queue.offer(cur.right);
                if(cur!=null&&startIndex==0){
                    startIndex = index;
                }
                if(cur!=null){
                    endIndex = index;
                }
                index++;
            }
            maxWidth = Math.max(maxWidth,endIndex-startIndex);
            curHeight++;
        }
        return maxWidth;
    }
    public int getHeight(TreeNode root){
        //base case
        if(root==null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        MaxWidthOfBinaryTree maxWidthOfBinaryTree = new MaxWidthOfBinaryTree();
        maxWidthOfBinaryTree.getHeight()
    }
     */
}
