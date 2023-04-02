package EveryDayOneLeetcode;

public class MaskingPersonalInfo {
    public String maskPII(String s){
        String[] country = new String[]{"","+*-","+**-","+***-"};
        //indexOf: returns an int value, representing the index of the first occurrence of the character in the string
        //or -1 if it never occurs
        int index = s.indexOf("@");
        if(index>0){
            s = s.toLowerCase();
            return s.charAt(0)+"*****"+s.substring(index-1,s.length());
        }else{
            s = s.replaceAll("[^0-9]","");
            return country[s.length()-10]+"***-***-"+s.substring(s.length()-4);
        }
    }
}
