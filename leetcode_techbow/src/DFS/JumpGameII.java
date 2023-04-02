package DFS;

public class JumpGameII {
    public static int res = Integer.MAX_VALUE;

    /**
     * method1:DFS 超时
     * @param nums
     * @return
     */
    public static int jump(int[] nums){
        //cc
        if(nums.length<=1) return 0;
        int count = 0;
        dfs(nums,0,count);
        return res;
    }
    public static void dfs(int[] nums, int index, int count){
        //base case
        if(index==nums.length-1) {
            res = Math.min(count,res);
            return;
        }
        if(index>=nums.length) return;
        if(nums[index]==0){
            return;
        }
        int distance = nums[index];
        for(int i=1;i<=distance;i++){
            if(index+i>=nums.length){
                break;
            }
            dfs(nums,index+i,count+1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6};
        int res = JumpGameII.jump(nums);
        System.out.println(res);
    }
}
