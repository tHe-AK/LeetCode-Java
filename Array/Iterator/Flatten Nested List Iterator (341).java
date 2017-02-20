/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pushAll(nestedList);
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger peek = stack.peek();
            
            if (peek.isInteger()) {
                return true;
            } else {
                stack.pop();
                pushAll(peek.getList());
            }
        }
        
        return false;
    }
    
    private void pushAll(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
