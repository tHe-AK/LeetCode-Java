public class ZigzagIterator {
    private Queue<Iterator<Integer>> queue;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<Iterator<Integer>>();
        
        if (!v1.isEmpty()) {
            queue.offer(v1.iterator());
        }
        
        if (!v2.isEmpty()) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> peek = queue.poll();
        int result = peek.next();
        
        if (peek.hasNext()) {
            queue.offer(peek);
        }
        
        return result;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
