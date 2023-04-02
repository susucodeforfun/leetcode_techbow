package DFS;

public class JumpGame {
    public static boolean canJump(int[] nums){
        //cc
        if(nums==null||nums.length==0) return false;
        return dfs(nums,0);
    }

    public static boolean dfs(int[] nums, int index){
        if(index==nums.length-1) return true;
        if(nums[index]==0) return false;
        int distance = nums[index];
        for(int i=1;i<=distance;i++){
            //剪枝
            if(index+i>=nums.length) break;
            if(dfs(nums,index+i)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        boolean res = JumpGame.canJump(nums);
        System.out.println(res);
    }
}
