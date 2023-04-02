package Array;

public class Solution2 {
    public float[] res(int num,int[] nums,int opration,char[] oprations){
        float[] res = new float[opration];

        int[] postion = new int[opration];
        int index1 = 0;
        for(int i=0;i<opration;i++){
            postion[i] = Integer.valueOf(oprations[index1]);
            index1+=2;
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        System.out.println("sum"+sum);
        char[] oprator = new char[opration];
        int index2 = 1;
        for(int i=1;i<opration;i++){
            oprator[i] = oprations[index2];
            index2+=2;
            System.out.print("oprator:"+oprator[i]+" ");
        }
        for(int i=0;i<opration;i++){
            if(oprator[i]=='+') res[i] = sum;
            if(oprator[i]=='-') res[i] = sum-2*nums[postion[i]];
            if(oprator[i]=='*') res[i] = sum-nums[postion[i]]-nums[postion[i]-1]+(nums[postion[i]]*nums[postion[i]-1]);
            if(oprator[i]=='/') res[i] = sum-nums[postion[i]]-nums[postion[i]-1]+(nums[postion[i]]/nums[postion[i]-1]);
            System.out.println(res[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        float[] res = s.res(5,new int[]{1,2,4,2,5},3,new char[]{'1','-','2','*','4','/'});
        for (int i=0;i>res.length;i++){
            System.out.println(res[i]);
        }
    }
}
