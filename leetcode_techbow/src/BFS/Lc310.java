package BFS;

import java.util.*;

public class Lc310 {
    /*
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n];
        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a,new ArrayList<>());
            graph.get(a).add(b);
            graph.putIfAbsent(b,new ArrayList<>());
            graph.get(b).add(a);
            inDegree[a]++;
            inDegree[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]<=1){
                queue.offer(i);
                inDegree[i]--;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int cur = queue.poll();
                for(Integer next : graph.get(cur)){

                }
            }
        }


    }
    */
}
