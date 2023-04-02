package Greedy;

import java.util.Arrays;

public class Lc455 {
    //局部最优情况：大饼干喂给胃口大的，充分利用饼干尺寸喂饱一个，全局最优就是喂饱尽可能多的小孩
    //尝试贪心策略：先将饼干数组和小孩儿数组进行排序，然后从后向前遍历小孩儿数组，用大饼干优先满足胃口大的
    //int[] g: array of the greedy of each child
    //int[] s: array of the size of each cookie
    public int findContentChildren(int[] g, int[] s){
        //cc
        if(g==null||g.length==0||s==null||s.length==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = s.length-1;
        for(int i=g.length-1;i>=0;i--){
            if(index>=0 && s[index]>g[i]){
                index--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Lc455 lc = new Lc455();
        int[] g = new int[]{1,3,5,9};
        int[] s = new int[]{1,2,7,10};
        lc.findContentChildren(g,s);
    }
}
