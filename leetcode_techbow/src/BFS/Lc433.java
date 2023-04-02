package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//"AACCTTGG" "AATTCCCGG" "AATTCCGG, AACCTGGG, AACCCCGG, AACCTACC"
public class Lc433 {
    public static char[] banks = {'A','C','G','T'};
    public int minMutation(String startGene, String endGene, String[] bank){
        HashSet<String> set = new HashSet<>();
        for(String s:bank){
            set.add(s);
        }
        if(!set.contains(endGene)) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                String cur = queue.poll();
                if(cur.equals(endGene)) return count;
                List<String> nexts = convert(cur,set);
                for(String next:nexts){
                    queue.offer(next);
                    set.remove(next);
                }
            }
            count++;
        }
        return count;
    }
    public List<String> convert(String s,HashSet<String> set){
        List<String> res = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for(int i=0;i<charArray.length;i++){
            char temp = charArray[i];
            for(char c:banks){
                charArray[i] = c;
                String str = String.valueOf(charArray);
                if(set.contains(str)){
                    res.add(str);
                }
            }
            charArray[i] = temp;
        }
        return res;
    }
}
