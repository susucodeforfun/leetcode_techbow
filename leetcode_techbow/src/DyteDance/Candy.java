package DyteDance;

public class Candy {

    /**
     * 两次遍历： 第一次从左向右遍历 如果nums[i]>nums[i-1]  res[i] = res[i-1]+1 否则 res[i] = 1
     * 第二次遍历 从右向左 如果nums[i]>nums[i+1]
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings){
        int len = ratings.length;
        int[] res = new int[len];
        int sum = 0;
        res[0] = 1;
        for(int i=1;i<len;i++){
            if(ratings[i]>ratings[i-1]){
                res[i] = res[i-1]+1;
            }else{
                res[i] = 1;
            }
        }
        for(int i=len-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                if(res[i]<=res[i+1]){
                    res[i] = res[i+1]+1;
                }
            }
        }
        for(int i=0;i<res.length;i++){
            sum += res[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int res = Candy.candy(new int[]{1,2,87,87,87,2,1});
        System.out.println(res);
    }
}
