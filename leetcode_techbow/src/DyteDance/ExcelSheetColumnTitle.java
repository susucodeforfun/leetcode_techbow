package DyteDance;

public class ExcelSheetColumnTitle {
    /**
     * 进制转换问题
     * 以16进制和10进制转换为例
     * 16进制 B2C = B*16^2+2*16+C*16^0 = 11*16^2+2*16+12*16^0 = 2860
     * 10进制 2860  先对16取余 1132%16 = 12 (C)  再除16 1132/16 = 178 重复这个过程
     * 先对16取余 178%16 = 2 再除16 178/16 = 11
     * 先对16取余 11%16 = 11(B)  再除16 11/16 = 0 结束   结果: B2C
     *
     * 这道题是26进制和10进制之间的转换
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber){
        StringBuilder sb = new StringBuilder();
        while(columnNumber!=0){
            int convertNum = columnNumber%26;
            columnNumber/=26;
            sb.insert(0,(char) ('A'+convertNum-1));
        }
        return sb.toString();
    }
}
