package OOD.Queue;

import java.util.LinkedList;
import java.util.Stack;

/*
使用两个栈实现队列
 */
public class MyQueue {
     LinkedList<Integer> stack1;
     LinkedList<Integer> stack2;
    public MyQueue(){
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    public void appendTail(int value){
        stack1.offer(value);
    }

    public int deleteHead(){
        if(!stack2.isEmpty()) return stack2.pop();
        if(stack1.isEmpty()) return -1;
        if(!stack1.isEmpty()){
            stack2.offer(stack1.poll());
        }
        return stack2.pop();
    }
}
