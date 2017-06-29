public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int[] left = new int[len];
        int sum = 0;
        
        for (int i = 0; i < len; i++) {
            left[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        
        for (int i = len - 1; i >= 0; i--) {
            int min = Math.min(left[i], rightMax);
            rightMax = Math.max(rightMax, height[i]);
            
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        
        return sum;
    }
}
