package BFS;

import java.io.FileOutputStream;
import java.util.*;
public class Lc127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        HashSet wordSet = new HashSet(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        int count = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                String cur = queue.poll();
                if(cur.equals(endWord)) return count+1;
                List<String> nexts = convert(cur,wordSet);
                for(String next : nexts){
                    queue.offer(next);
                    wordSet.remove(next);
                }
            }
            count++;
        }
        return 0;
    }
    public List<String> convert(String s, HashSet wordSet){
        List<String> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        for(int i=0;i<charArray.length;i++){
            char temp = charArray[i];
            for(char c='a';c<='z';c++){
                charArray[i] = c;
                String word = String.valueOf(charArray);
                if(wordSet.contains(word)){
                    res.add(word);
                }
            }
            charArray[i] = temp;
        }
        return res;
    }
}
