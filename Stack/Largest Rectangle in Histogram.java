public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null) {
            throw new IllegalArgumentException();
        }
        
        int max = 0;
        int[] rec = new int[height.length + 1];
        System.arraycopy(height, 0, rec, 0, height.length);
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        
        while (i < rec.length) {
            if (stack.empty() || rec[stack.peek()] < rec[i]) {
                stack.push(i);
                i++;
            }
            else {
                int peek = stack.pop();
                max = Math.max(max, stack.empty() ? rec[peek] * i : rec[peek] * (i - stack.peek() - 1));
            }
        }
        
        return max;
    }
}