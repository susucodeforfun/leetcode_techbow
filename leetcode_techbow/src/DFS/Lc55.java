package DFS;

public class Lc55 {
    public boolean canJump(int[] nums){
        if(nums==null||nums.length==0) throw new IllegalArgumentException();
        return dfs(nums,0);
    }

    public boolean dfs(int[] nums, int index){
        if(index>=nums.length-1) return true;
        int distance = nums[index];
        for(int i=1;i<=distance;i++){
            if(dfs(nums,i)) return true;
        }
        return false;
    }
}
