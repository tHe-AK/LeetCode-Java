public class Solution {
    public int trap(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        
        while (low <= high) {
            if (leftMax <= rightMax) {
                int curr = height[low++];
                
                if (leftMax > curr) {
                    sum += leftMax - curr;
                } else {
                    leftMax = curr;
                }
            } else {
                int curr = height[high--];
                
                if (rightMax > curr) {
                    sum += rightMax - curr;
                } else {
                    rightMax = curr;
                }
            }
        }
        
        return sum;
    }
}
