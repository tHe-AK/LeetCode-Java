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
        int index = 0;
        int max = height[0];
        
        for (int i = 1; i < len; i++) {
            if (height[i] > max) {
                max = height[i];
                index = i;
            }
        }
        
        int high = 0;
        
        for (int i = 0; i < index; i++) {
            if (height[i] < high) {
                sum += high - height[i];
            }
            
            high = Math.max(high, height[i]);
        }
        
        high = 0;
        
        for (int i = height.length - 1; i > index; i--) {
            if (height[i] < high) {
                sum += high - height[i];
            }
            
            high = Math.max(high, height[i]);
        }
        
        return sum;
    }
}
