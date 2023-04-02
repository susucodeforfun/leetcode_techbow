package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lc332 {
    //path记录路线，res存所有路线
    public List<String> path = new ArrayList<>();
    public static List<List<String>> res = new ArrayList<>();

    //在只需要找一条路径的时候我们可以利用flag，当找到一条路径后，我们将flag的status设置成true，
    //这样就不需要继续dfs，相当于剪枝.
    //类似的还有word ladder 1.5 返回一种可能的情况
    public static boolean flag = false;
    public List<String> findItinerary(List<List<String>> tickets){
        if(tickets==null||tickets.size()==0) return res.get(0);
        boolean[] visited = new boolean[tickets.size()];
        tickets.sort((o1,o2)-> o1.get(1).compareTo(o2.get(1)));
        path.add("JFK");
        dfs(tickets,"JFK",visited);
        return res.get(0);
    }

    public void dfs(List<List<String>> tickets, String destination, boolean[] visited){
        //base case
        if(flag) return;
        //加入path的size等于tickets.size()+1 说明找到路线了
        if(path.size()==tickets.size()+1){
            res.add(new ArrayList<>(path));
            flag = true;
            return;
        }
        for(int i=0;i<tickets.size();i++){
            //如果出发地和上一个目的地相同，并且没用重复使用一张票
            if(tickets.get(i).get(0).equals(destination) && !visited[i]){
                //mark the ticket is used
                visited[i] = true;
                //将这次目的地加入path中
                path.add(tickets.get(i).get(1));
                dfs(tickets,tickets.get(i).get(1),visited);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Lc332 lc = new Lc332();
        List<String> list1 = new ArrayList<>(Arrays.asList("JFK","SFO"));
        List<String> list2 = new ArrayList<>(Arrays.asList("JFK","ATL"));
        List<String> list3 = new ArrayList<>(Arrays.asList("SFO","ATL"));
        List<String> list4 = new ArrayList<>(Arrays.asList("ATL","JFK"));
        List<String> list5 = new ArrayList<>(Arrays.asList("ATL","SFO"));
        List<List<String>> tickets = new ArrayList<>(Arrays.asList(list1,list2,list3,list4,list5));
        lc.findItinerary(tickets);
        System.out.println(res.get(0));
    }
}
