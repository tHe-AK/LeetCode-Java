import java.util.Stack;
 
public class MyQueue<T> {
    private Stack<T> stackAdd;
    private Stack<T> stackRemove;
    
    public MyQueue() {
        stackAdd = new Stack<T>();
        stackRemove = new Stack<T>();
    }
    
    public int size() {
        return stackAdd.size() + stackRemove.size();
    }
    
    public boolean empty() {
        return stackAdd.empty() && stackRemove.empty();
    }
    
    public void offer(T val) {
        stackAdd.push(val);
    }
    
    public T poll() {
        if (empty()) {
            throw new RunTimeException("Stack is empty.");
        }
        
        shifStack();
        
        return stackRemove.pop();
    }
    
    public T peek() {
        if (empty()) {
            throw new RunTimeException("Stack is empty.");
        }
        
        shifStack();
        
        return stackRemove.peek();
    }
    
    private void shifStack() {
        if (stackRemove.empty()) {
            while (!stackAdd.empty()) {
                stackRemove.push(stackAdd.pop());
            }
        }
    }
}
