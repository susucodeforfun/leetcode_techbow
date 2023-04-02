package SlidingWindow;

public class Lc2379 {
    public static int minimumRecolors(String blocks, int k){
        if(blocks==null||blocks.length()==0 || k==0) return 0;
        char[] charArray = blocks.toCharArray();
        int min = Integer.MAX_VALUE;
        int fast = 0;
        int slow = 0;
        int blackNum = 0;
        int whiteNum = 0;
        while(fast<blocks.length()){
            //if(blackNum==k) min = Math.min(min,fast-slow+1);
            if(charArray[fast]=='B'){
                blackNum++;
            }
            if(charArray[fast]=='W'){
                whiteNum++;
            }
            if(blackNum+whiteNum==k) {
                min = Math.min(min, whiteNum);
            }
            fast++;
            if(fast-slow+1>k){
                slow++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "WBBWWBBWBW";
        int res = Lc2379.minimumRecolors(s,7);
        System.out.println(res);
    }
}
