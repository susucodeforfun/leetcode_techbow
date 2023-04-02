package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            while(size-->0){
                TreeNode curNode = queue.poll();
                if(curNode.left!=null){
                    queue.offer(curNode.left);
                }
                if(curNode.right!=null){
                    queue.offer(curNode.right);
                }
                if(level%2==0){
                    list.add(curNode.val);
                }
                if(level%2!=0){
                    list.add(0, curNode.val);
                }
            }
            res.add(list);
            level++;
        }
        return res;
    }
}
