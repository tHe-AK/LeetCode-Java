public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int len = heights.length;
        int max = 0;
        
        for (int i = 0; i <= len; i++) {
            int curr = (i == len) ? -1 : heights[i];
            
            while (!stack.isEmpty() && heights[stack.peek()] >= curr) {
                int height = heights[stack.pop()];
                int width = stack.empty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            
            stack.push(i);
        }
        
        return max;
    }
}
