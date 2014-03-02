public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int len = height.length;
        int[] copy = new int[len + 1];
        for (int i = 0; i < len; i++) {
            copy[i] = height[i];
        }
        copy[len] = 0;
        
        Stack<Integer> s = new Stack<Integer>();
        int area = 0;
        int i = 0;
        while (i < copy.length) {
            if (s.empty() == true || copy[i] >= copy[s.peek()]) {
                s.push(i);
                i++;
            }
            else {
                int cur = s.peek();
                s.pop();
                if (s.empty() == true) {
                    area = Math.max(area, i * copy[cur]);
                }
                else {
                    area = Math.max(area, (i - s.peek() - 1) * copy[cur]);
                }
            }
        }
        
        return area;
    }
}
