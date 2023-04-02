package DyteDance;

import java.util.HashMap;
import java.util.Map;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t){
        //two points
        int sPoint = 0;
        int tPoint = 0;
        while(tPoint<=t.length()-1){
            char curCharacter = s.charAt(sPoint);
            if(curCharacter==t.charAt(tPoint)){
                sPoint++;
                if(sPoint==s.length()) return true;
            }
            tPoint++;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = IsSubsequence.isSubsequence("axc","ahbgdc");
        System.out.println(res);
    }
}
