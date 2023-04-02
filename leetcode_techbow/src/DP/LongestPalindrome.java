package DP;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<=1) return  s;
        int len = s.length();
        int startIndex = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];
        //注意dp的填值顺序
        //由于dp[i][j]是根据dp[i+1][j-1]得出 因此i要从大到小填值 j从小到大填值
        //或者先遍历j再遍历i 可以不考虑i的填值顺序问题
        /**
         * 遍历顺序 先i后j i从大到小填值方式
         */
        for(int i=len-2;i>=0;i--){
            for(int j=i+1;j<=len-1;j++){
                if(( j-i<=2 || dp[i+1][j-1]) && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        startIndex = i;
                    }
                }
            }
        }
        /**
         * 遍历顺序 先j后i 不需要考虑i的填值顺序
         */
        for(int j=1;j<=len-1;j++){
            for(int i=0;i<j;i++){
                if((j-i+1<=2||dp[i+1][j-1]) && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                    if(maxLen<j-i+1){
                        maxLen = j-i+1;
                        startIndex = i;
                    }
                }
            }
        }
        return s.substring(startIndex,startIndex+maxLen);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("aaaa"));
    }
}
