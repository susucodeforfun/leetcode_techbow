package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-->0){
                TreeNode curNode = queue.poll();
                if(curNode.left!=null){
                    queue.offer(curNode.left);
                }
                if(curNode.right!=null){
                    queue.offer(curNode.right);
                }
                list.add(curNode.val);
            }
            res.add(0,list);
        }
        return res;
    }
}
