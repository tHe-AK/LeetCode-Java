class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.peek();
                res[idx] = i - idx;
                stack.pop();
            }
            
            stack.push(i);
        }
        
        return res;
    }
}
