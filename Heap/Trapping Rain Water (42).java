public class Solution {
    public int trap(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        
        while (low <= high) {
            if (leftMax <= rightMax) {
                if (leftMax > height[low]) {
                    result += leftMax - height[low];
                } else {
                    leftMax = height[low];
                }

                low++;
            } else {
                if (rightMax > height[high]) {
                    result += rightMax - height[high];
                } else {
                    rightMax = height[high];
                }

                high--;
            }
        }
        
        return result;
    }
}
