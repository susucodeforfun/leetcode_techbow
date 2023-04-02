package DyteDance;

//Lc3
public class LongestSubstringWithoutRepeatingCharacters {
    static int[] map = new int[128];
    public static int lengthOfLongestSubString(String s){
        char[] charArray = s.toCharArray();
        int fast = 0;
        int slow = 0;
        int max = 1;
        while (fast<charArray.length){
            map[charArray[fast]]++;
            while(map[charArray[fast]]>1){
                map[charArray[slow]]--;
                slow++;
            //    max = Math.max(fast-slow+1,max);
            }
            max = Math.max(fast-slow+1,max);
            fast++;
        }
        return max;
    }

    public static void main(String[] args) {
        int res = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubString("au");
        System.out.println(res);
    }
}
