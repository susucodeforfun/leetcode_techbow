package BFS;

import java.util.*;

public class Lc690 {
    public int getImportance(List<Employee> employees, int id) {
        /*
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int importance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int curId = queue.poll();
                for (Employee e:employees){
                    if(e.id==curId){
                        importance += e.importance;
                        if(e.subordinates.size()!=0){
                            for(int i:e.subordinates){
                                queue.offer(i);
                            }
                        }
                    }
                }
            }
        }
        return importance;
         */
        int size = employees.size();
        Map<Integer,Employee> map = new HashMap<>(size);
        for(Employee e:employees){
            map.put(e.id,e);
        }
        Queue<Integer> queue = new LinkedList<>();
        int importance = 0;
        queue.offer(id);
        while (!queue.isEmpty()){
            int curId = queue.poll();
            Employee employee = map.get(curId);
            importance += employee.importance;
            for(Integer i:employee.subordinates){
                queue.offer(i);
            }
        }
        return importance;
    }
}
