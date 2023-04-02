package DP;

public class PalindromicSubstrings {
    /**
     * dp[i][j]: [i，j]区间内的substring是否是palindrome
     *  s[i]!=s[j] false
     * **********************
     *  s[i]==s[j] 有三种情况
     *  1. i==j，说明只有一个字符，true
     *  2. i-j = 1， 如 aa true
     *  3. i-j>1  dp[i][j] 根据 dp[i+1][j-1]得出
     **/
    public int countSubstrings(String s){
        if(s==null||s.length()==0) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        //遍历顺序：由于dp[i][j]是根据dp[i+1][j-1]得到 所以要从下到上 从左到右遍历
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
//                if(s.charAt(i)==s.charAt(j)){
//                    if (j - i <= 1) {
//                        count++;
//                        dp[i][j]=true;
//                    }else if(dp[i+1][j-1]){
//                        count++;
//                        dp[i][j] = true;
//                    }
//                }
                /**
                 * 优化一下上面的写法
                 */
                if(s.charAt(i)==s.charAt(j) && (j-i<=1 || dp[i+1][j-1])){
                    count++;
                    dp[i][j] = true;
                }
            }
        }
        return count;
    }
}
