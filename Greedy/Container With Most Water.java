public class Solution {
    public int maxArea(int[] height) {
        if (height == null) {
            throw new IllegalArgumentException();
        }
        
        int area = 0;
        
        if (height.length < 2) {
            return area;
        }
        
        int low = 0;
        int high = height.length - 1;
        
        while (low < high) {
            if (height[low] < height[high]) {
                area = Math.max(area, (high - low) * height[low]);
                low++;
            }
            else {
                area = Math.max(area, (high - low) * height[high]);
                high--;
            }
        }
        
        return area;
    }
}