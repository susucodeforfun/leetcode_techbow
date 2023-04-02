package DyteDance;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 辅助栈 minStack
 * 维护一个最小栈：按非严格递减的顺序存储 minStack的栈顶就是当前最小值
 * 当stack push进入一个value 与minStack的栈顶元素进行比较，如果栈顶元素大于等于value 将value进栈
 */
public class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;
    public MinStack(){
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x){
        stack.addLast(x);
        if(minStack.isEmpty() || minStack.peekLast()>=x){
            minStack.addLast(x);
        }
    }

    public void pop(){
        if(!stack.isEmpty()){
            int popNum = stack.removeLast();
            if(!minStack.isEmpty()&&popNum==minStack.peekLast()){
                minStack.removeLast();
            }
        }
    }

    public int top(){
        return stack.peekLast();
    }

    public int min(){
        int min = 0;
        if(!minStack.isEmpty()){
            min = minStack.peekLast();
        }
        return min;
    }
}
