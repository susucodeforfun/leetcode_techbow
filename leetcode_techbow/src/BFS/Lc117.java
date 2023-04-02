package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Lc117 {
    public Node connect(Node root){
        if(root==null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node pre = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                Node curNode = queue.poll();
                if(curNode.left!=null){
                    queue.offer(curNode.left);
                }
                if(curNode.right!=null){
                    queue.offer(curNode.right);
                }
                if(pre!=null){
                    pre.next = curNode;
                }
                pre = curNode;
            }
            pre = null;
        }
        return root;
    }
}
