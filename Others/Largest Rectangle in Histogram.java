public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null) {
            throw new IllegalArgumentException();
        }
        
        int len = height.length + 1;
        int[] rec = new int[len];
        System.arraycopy(height, 0, rec, 0, len - 1);
        rec[len - 1] = 0;
        
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        
        while (i < len) {
            if (stack.empty() || rec[i] > rec[stack.peek()]) {
                stack.push(i);
                i++;
            }
            else {
                int pos = stack.pop();
                max = Math.max(max, stack.empty() ? i * rec[pos] : (i - stack.peek() - 1) * rec[pos]);
            }
        }
        
        return max;
    }
}
