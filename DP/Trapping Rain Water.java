public class Solution {
    public int trap(int[] height) {
        if (height == null) {
            throw new IllegalArgumentException();
        }
        
        if (height.length < 3) {
            return 0;
        }
        
        int len = height.length;
        int sum = 0;
        int max = height[0];
        int maxIndex = 0;
        
        for (int i = 1; i < len; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        
        int curMax = 0;
        
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] < curMax) {
                sum += curMax - height[i];
            }
            
            curMax = Math.max(curMax, height[i]);
        }
        
        curMax = 0;
        
        for (int i = len - 1; i > maxIndex; i--) {
            if (height[i] < curMax) {
                sum += curMax - height[i];
            }
            
            curMax = Math.max(curMax, height[i]);
        }
        
        return sum;
    }
}
