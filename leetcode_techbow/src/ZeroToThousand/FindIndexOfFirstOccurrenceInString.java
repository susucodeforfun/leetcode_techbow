package ZeroToThousand;

public class FindIndexOfFirstOccurrenceInString {
    public int strStr(String hayStack, String needle){
        int slow = 0;
        int fast =needle.length()-1;
        while(fast<=hayStack.length()-1){
            if(hayStack.substring(slow,fast+1).equals(needle)){
                return slow;
            }
            slow++;
            fast++;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindIndexOfFirstOccurrenceInString newInstance = new FindIndexOfFirstOccurrenceInString();
        int res = newInstance.strStr("leetcode","leeto");
        System.out.println(res);
    }
}
