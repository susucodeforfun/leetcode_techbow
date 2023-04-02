package DFS.Partition;

import java.util.ArrayList;
import java.util.List;

public class Lc131 {
        List<List<String>> res = new ArrayList<>();
       public List<List<String>> partition(String s){
           //cc
           if(s==null||s.length()==0) return res;
           dfs(s,0,new ArrayList<String>());
           return res;
       }

       public void dfs(String s, int index, List<String> list){
           //base case
           if(index==s.length()){
               res.add(new ArrayList<>(list));
               return;
           }
           for(int i=index;i<s.length();i++){
               if(isPalindrome(s,index,i)){
                   list.add(s.substring(index,i+1));
               }else continue;
               dfs(s,i+1,list);
               list.remove(list.size()-1);
           }
       }

       public boolean isPalindrome(String s, int start, int end){
           while(start<=end){
               if(s.charAt(start)!=s.charAt(end)) return false;
               start++;
               end--;
           }
           return true;
       }

}
