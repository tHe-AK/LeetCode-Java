public class Solution {
    public int trap(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int sum = 0;
        
        while (low + 1 < high) {
            if (height[low] <= height[high]) {
                if (height[low] > height[low + 1]) {
                    sum += height[low] - height[low + 1];
                    height[low + 1] = height[low];
                }
                
                low++;
            } else {
                if (height[high] > height[high - 1]) {
                    sum += height[high] - height[high - 1];
                    height[high - 1] = height[high];
                }
                
                high--;
            }
        }
        
        return sum;
    }
}

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
