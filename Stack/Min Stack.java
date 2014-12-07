class MinStack {
    private Stack<Integer> num;
    private Stack<Integer> min;
    
    public MinStack() {
        num = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        num.push(x);
        
        if (min.empty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        if (num.empty()) {
            throw new RuntimeException("The stack is empty");
        }
        
        int peek = num.pop();
        
        if (peek == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        if (num.empty()) {
            throw new RuntimeException("The stack is empty");
        }
        
        return num.peek();
    }

    public int getMin() {
        if (num.empty()) {
            throw new RuntimeException("The stack is empty");
        }
        
        return min.peek();
    }
}
