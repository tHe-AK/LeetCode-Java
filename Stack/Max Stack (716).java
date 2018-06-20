class MaxStack {
    private Stack<Integer> num;
    private Stack<Integer> max;

    public MaxStack() {
        num = new Stack<>();
        max = new Stack<>();
    }

    public void push(int x) {
        num.push(x);
        
        if (max.empty() || x >= max.peek()) {
            max.push(x);
        }
    }

    public int pop() {
    	int peek = num.pop();
    	
        if (max.peek() == peek) {
            max.pop();
        }
        
        return peek;
    }

    public int top() {
        return num.peek();
    }

    public int peekMax() {
        return max.peek();
    }

    public int popMax() {
        int max = this.peekMax();
        Stack<Integer> buffer = new Stack<>();
        
        while (this.top() != max) {
            buffer.push(this.pop());
        }
        
        this.pop();
        
        while (!buffer.empty()) {
            this.push(buffer.pop());
        };
        
        return max;
    }
}
