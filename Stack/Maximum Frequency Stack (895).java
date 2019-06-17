class FreqStack {
    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> group;
    private int max;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        max = 0;
    }
    
    public void push(int x) {
        int count = freq.getOrDefault(x, 0) + 1;
        freq.put(x, count);
        group.putIfAbsent(count, new Stack<>());
        group.get(count).push(x);
        max = Math.max(max, count);
    }
    
    public int pop() {
        Stack<Integer> stack = group.get(max);
        int peek = stack.pop();
        freq.put(peek, freq.get(peek) - 1);
        
        if (stack.empty()) {
            max--;
        }
        
        return peek;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
