package DailyOneCode;

public class PreviousPermutationWithOneSwap {
    /**
     * 1.升序不用交换
     * 2.确定需要交换元素的位置：逆序遍历数组，第一次升序的位置 arr[i-1]>arr[i]，arr[i-1]就是要交换的元素
     * 3.从arr[i-1]的位置向右找,小于arr[i-1]的最大值且这个元素最靠近arr[i-1]
     *  第三步的实现要从右向左遍历 因为从左向右遍历去找这个值 找到的会是离arr[i-1]最远的target(数组中有重复元素) 还需要再往左找
     *  因此从右向左找更方便
     * @param arr
     * @return
     */
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        //int index = -1;
        boolean hasSwapped = false;
        for(int i=len-1;i>=1;i--){
            if(hasSwapped) break;
            if(arr[i-1]>arr[i]){
                int index = i-1;
                int min = Integer.MAX_VALUE;
                for(int j=len-1;j>i-1;j--){
                    if(arr[j]<arr[i-1] && arr[i-1]-arr[j]<=min){
                        min = arr[i-1]-arr[j];
                        index = j;
                    }
                }
                swap(arr,i-1,index);
                hasSwapped = true;
            }
        }
        return arr;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println("*********");
    }


    public static void main(String[] args) {
        PreviousPermutationWithOneSwap newInstance = new PreviousPermutationWithOneSwap();
        int[] res = newInstance.prevPermOpt1(new int[]{3,2,1});
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
