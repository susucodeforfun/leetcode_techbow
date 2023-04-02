package ZeroToThousand;

import java.util.Deque;
import java.util.LinkedList;

//LC20
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else{
                if(stack.isEmpty()||stack.pop()!=c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        ValidParentheses vp = new ValidParentheses();
        boolean res = vp.isValid("()[]{}");
        System.out.println(res);
    }
}
