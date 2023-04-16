package ZeroToThousand;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums){
        int len = nums.length;
        int slow = 0;
        int fast = 1;
        while(fast<len){
            if(nums[fast]!=nums[slow]){
                nums[slow+1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow+1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray newInstance = new RemoveDuplicatesFromSortedArray();
        int res = newInstance.removeDuplicates(new int[]{1,1,2});
        System.out.println(res);
    }
}
