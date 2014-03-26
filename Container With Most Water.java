public class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        
        int start = 0;
        int end = height.length - 1;
        int area = 0;
        while (start < end) {
            int cur = Math.min(height[start], height[end]);
            area = Math.max(area, cur * (end - start));
            
            if (height[start] <= height[end]) {
                start++;
            }
            else {
                end--;
            }
        }
        
        return area;
    }
}
