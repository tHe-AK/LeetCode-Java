class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int len = T.length;
        int[] res = new int[len];
        
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && T[stack.peek()] < T[i]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            
            stack.push(i);
        }
        
        return res;
    }
}
