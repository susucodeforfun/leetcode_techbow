package ZeroToThousand;

public class DivideTwoIntegers {
    /**
     * DFS
     * 提高效率快速逼近结果
     * 例如 dividend: 11 divisor: 3
     * 11>3 => 3*2  11>6 => 6*2  11<12  So (11-6)/3+2
     * 5>3 => 3*2  5<6 So (5-3)/3+2+1 = 3
     * @param dividend 被除数
     * @param divisor 除数
     * @return
     */
    public int divide(int dividend, int divisor){
        //cc
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1){
            return -dividend;
        }
        long longDividend = dividend;
        long longDivisor = divisor;
        //判断dividend和divisor符号
        //sign=true dividend和divisor同号
        //sign=false dividend和divisor异号
        boolean sign = true;
        if((longDividend>0&&longDivisor<0)||(longDividend<0&&longDivisor>0)){
            sign = false;
        }
        longDividend = dividend>0? dividend:-dividend;
        longDivisor = divisor>0? divisor:-divisor;
        long res = dfs(dividend,divisor);
        return sign==true? (int)res:(int)-res;
    }

    public int dfs(long dividend, long divisor){
        if(dividend<divisor) return 0;
        long temp = divisor;
        int count =1;
        while((temp+temp)<=dividend){
            count = count + count;
            temp = temp + temp;
        }
        return count + dfs(dividend-temp,divisor);
    }

    public static void main(String[] args) {
        DivideTwoIntegers newInstance = new DivideTwoIntegers();
        int res = newInstance.divide(10,3);
        System.out.println(res);
    }
}
