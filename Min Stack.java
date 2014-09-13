public class MinStack extends Stack<Integer> {
    private Stack<Integer> minStack;
    
    public MinStack() {
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        super.push(val);

        if (val <= min()) {
            minStack.push(val);
        }
    }
    
    // Must return Integer type.
    public Integer pop() {        
        Integer val = super.pop();

        if (val == minStack.peek()) {
            minStack.pop();
        }
        
        return val;
    }
    
    public int min() {
        if (super.empty()) {
            throw new RunTimeException("Stack is Empty");
        }
        else {
            return minStack.peek();
        }
    }
}
