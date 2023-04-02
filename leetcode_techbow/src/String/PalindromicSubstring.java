package String;

public class PalindromicSubstring {
    public int countSubstrings(String s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isPalindrom(s.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isPalindrom(String s){
        if(s==null||s.length()==0) return false;
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static int count = 0;
    public void dfs(String s, int index){
        for(int i=index;i<s.length();i++){
            if(isPalindrom(s.substring(index,i+1))){
                count++;
            }
            dfs(s,i+1);
        }
    }
}
