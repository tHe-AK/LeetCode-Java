class MinStack {
    private Stack<Integer> stack;
    private int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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

class MinStack {
    private Stack<Integer> num;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        num = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        num.push(x);
        
        if (min.empty() || x <= min.peek()) {
            min.push(x);
        }
    }
    
    public void pop() {
        if (num.pop().equals(min.peek())) {
            min.pop();
        }
    }
    
    public int top() {
        return num.peek();
    }
    
    public int getMin() {
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
