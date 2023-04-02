package BFS;

import java.util.*;

public class Lc126{
    /*
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        HashSet<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if(!wordSet.contains(endWord)) return res;
        Queue<String> queue = new LinkedList<>();
        Map<String,List<String>> graph = new HashMap<>();
        queue.offer(beginWord);
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            HashSet<String> nextLevel = new HashSet<>();
            while (size-->0){
                String cur = queue.poll();
                if(cur.equals(endWord)){
                    flag = true;
                    continue;
                }
                List<String> nexts = convert(cur,wordSet);
                for(String next:nexts){
                    if(nextLevel.add(next)){
                        graph.putIfAbsent(next,new ArrayList<>());
                        queue.offer(next);
                    }
                    graph.get(next).add(cur);
                }
            }
            wordSet.removeAll(nextLevel);
        }
        if(flag){
            List<String> path = new LinkedList<>();
            path.add(0,endWord);
            dfs(graph,path,endWord,beginWord,res);
            return res;
        }
        return res;
    }

    public void dfs(Map<String,List<String>> graph, List<String> path, String cur, String endWord, List<List<String>> res){
        if(cur.equals(endWord)){
            res.add(new LinkedList<>(path));
            return;
        }
        List<String> nexts = graph.get(cur);
        for(String next:nexts){
            path.add(0,next);
            dfs(graph,path,next,endWord,res);
            path.remove(0);
        }
    }
    /*
    public List<String> convert(String cur,HashSet wordSet){

    }

     */
}
