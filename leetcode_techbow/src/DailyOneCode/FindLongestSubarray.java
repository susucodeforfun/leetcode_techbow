package DailyOneCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//description: Given an array filled with letters and numbers,
// find the longest subarray with an equal number of letters and numbers.
public class FindLongestSubarray {
    public static String[] findLongestSubarray(String[] array){
        Set<String> set = new HashSet<>();
        int fast = 0;
        int slow = 0;
        int countLetter = 0;
        int countNumber = 0;
        //存位置
        int[] positions = new int[2];
        while(fast< array.length){
            if(array[fast].compareTo("A")==1 && array[fast].compareTo("Z")==-1){
                countLetter++;
            }else {
                countNumber++;
            }
            set.add(array[fast]);
            while(set.contains(array[fast])){
                set.remove(array[fast]);
                slow++;
            }
           if(countLetter==countNumber && fast-slow+1>positions[1]-positions[0]){
               positions[0] = slow;
               positions[1] = fast;
           }
           fast++;
        }
        String[] result = new String[fast-slow+1];
        for(int i=0;i<result.length;i++){
            result[i] = array[i+slow-1];
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        String[] res = FindLongestSubarray.findLongestSubarray(strs);
        for(String s:res){
            System.out.print(s+" ");
        }
    }
}
