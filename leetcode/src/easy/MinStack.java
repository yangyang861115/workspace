package easy;

import java.util.*;

/*
 * 155
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 * */
public class MinStack {

    /** initialize your data structure here. */
    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> min;
    private int size;
    
    public MinStack() {
        size = 0;
        stack = new ArrayDeque<Integer>();
        min = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.size() == 0 || min.peek() >= x) min.push(x);
        size++;
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == min.peek()) min.pop();
        size--;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(min.size() == 0) return -1;
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */