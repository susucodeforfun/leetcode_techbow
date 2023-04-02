package BFS;

import java.util.*;

public class Lc102 {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-->0){
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                if(curNode.left!=null){
                    queue.offer(curNode.left);
                }
                if(curNode.right!=null){
                    queue.offer(curNode.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
