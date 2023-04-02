package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class Lc1590 {
    /*
    public int minSubarray(int[] nums, int p){
        int minLen = Integer.MAX_VALUE;
        int len = nums.length;
        int[] preSum = new int[len];
        Map<Integer,Integer> map = new HashMap<>();
        preSum[0] = nums[0];
        map.put(0,preSum[0]%p);
        for(int i=1;i<len;i++){
            preSum[i] = preSum[i-1] + nums[i];
            map.put(i,preSum[i]%p);
            if(map.containsValue(preSum[i]%p)){

            }
        }
    }

     */
}
