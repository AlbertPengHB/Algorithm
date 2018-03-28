/* 
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */


import java.util.Stack;

public class Solution {

    //维护一个最小栈用于存放当前元素的最小值
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> minStack=new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
        if(!minStack.isEmpty()){
            int temp=Math.min(minStack.peek(),node);
            minStack.push(temp);
        }else{
            minStack.push(node);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
        if(!minStack.isEmpty()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}