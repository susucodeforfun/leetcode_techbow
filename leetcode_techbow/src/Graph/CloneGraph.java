package Graph;

import java.util.*;

public class CloneGraph {

    //method1: dfs
    /*
        Map<Node,Node>
           <原始node,clone node>
     */
    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraphDFS(Node node){
        if(node==null) return node;
        return dfs(node);
    }

    public Node dfs(Node node){
        //base case:
        if(node==null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val);
        map.put(node,clone);
        for(Node next:node.neighbors){
            clone.neighbors.add(dfs(next));
        }
        return clone;
    }

    //method2: bfs
    public Node cloneGraphBFS(Node node){
        if(node==null) return node;
        Queue<Node> queue = new LinkedList<>();
        Node clone = new Node(node.val);
        Map<Node,Node> map = new HashMap<>();
        map.put(node,clone);
        queue.offer(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(Node next:cur.neighbors){
                if(!map.containsKey(next)){
                    queue.offer(next);
                    map.put(next,new Node(next.val));
                }
                map.get(cur).neighbors.add(map.get(next));
            }
        }
        return clone;
    }
}
