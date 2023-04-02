package DyteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumNumberOfPairsInArray {
    public static int[] numberOfPairs(int[] nums){
        Map<Integer, List<Integer>> map = new HashMap<>();
        int numberOfPairs = 0;
        int remain = 0;
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for(int key:map.keySet()){
            int size = map.get(key).size();
            numberOfPairs += size/2;
            if(size%2!=0){
                remain++;
            }
        }
        return new int[]{numberOfPairs,remain};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,1,3,2,2};
        int[] res = MaximumNumberOfPairsInArray.numberOfPairs(arr);
        System.out.println(res[0]+" "+res[1]);
    }
}
