package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Lc116 {
    public Node connect(Node root){
        if(root==null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        //utilize a preNode to connect current node
        Node pre = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Node curNode = queue.poll();
                if(curNode.left!=null){
                    queue.offer(curNode.left);
                }
                if(curNode.right!=null){
                    queue.offer(curNode.right);
                }
                //if previous node is not null, we can set the next of the previous node to current node
                //else we set previous node to current node
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
