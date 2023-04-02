package Graph.topologicalSort;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites){
        //build graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for(int[] p:prerequisites){
            int a = p[0];
            int b = p[1];
            map.putIfAbsent(b,new ArrayList<>());
            map.get(b).add(a);
            inDegree[a]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                queue.offer(i);
                res.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(map.get(cur)!=null){
                for(int next:map.get(cur)){
                    inDegree[next]--;
                    if(inDegree[next]==0){
                        queue.offer(next);
                        res.add(next);
                    }
                }
            }
        }
        if(res.size()!=numCourses) return new int[]{-1,-1};
        int[] arr = new int[numCourses];
        for(int i=0;i<arr.length;i++){
            arr[i] = res.get(i);
        }
        return  arr;
    }
}
