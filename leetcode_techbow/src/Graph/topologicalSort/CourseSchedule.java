package Graph.topologicalSort;

import java.util.*;

public class CourseSchedule {
    /*
        BFS
        1. build graph  list数组 List<Integer>[]
        2. build inDegree数组
        3. 创建queue 按graph中的顺序 将元素入队
        4. 比较 遍历后得到的结果和numCourses
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites){
        //1. build graph
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for(int[] p:prerequisites){
            int a = p[0];
            int b = p[1];
            if(!graph.containsKey(b)){
                graph.put(b,new ArrayList<>());
            }
            graph.get(b).add(a);
            inDegree[a]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int totalCourse = 0;
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                queue.offer(i);
                totalCourse++;
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            //check 当前key的value是否为null
            if(graph.get(cur)==null){
                for(int next:graph.get(cur)){
                    inDegree[next]--;
                    if(inDegree[next]==0){
                        queue.offer(next);
                        totalCourse++;
                    }
                }
            }
        }
        return totalCourse==numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,0}};
        boolean res =  CourseSchedule.canFinish(2,prerequisites);
        System.out.println(res);
    }
}
