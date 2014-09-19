public class Solution {
    public int maxSubArrayDiff(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int len = A.length;
        int curMax = A[0];
        int curMin = A[0];
        int[] leftMax = new int[len];
        int[] leftMin = new int[len];
        leftMax[0] = curMax;
        leftMin[0] = curMin;
        
        for (int i = 1; i < len; i++) {
            curMax = Math.max(curMax + A[i], A[i]);
            leftMax[i] = Math.max(leftMax[i - 1], curMax);
            curMin = Math.min(curMin + A[i], A[i]);
            leftMin[i] = Math.min(leftMin[i - 1], curMin);
        }
        
        curMax = A[len - 1];
        curMin = A[len - 1];
        int[] rightMax = new int[len];
        int[] rightMin = new int[len];
        rightMax[len - 1] = curMax;
        rightMin[len - 1] = curMin;
        
        for (int i = len - 2; i >= 0; i--) {
            curMax = Math.max(curMax + A[i], A[i]);
            rightMax[i] = Math.max(rightMax[i + 1], curMax);
            curMin = Math.min(curMin + A[i], A[i]);
            rightMin[i] = Math.min(rightMin[i + 1], curMin);
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, leftMax[i] - rightMin[i + 1]);
            max = Math.max(max, rightMax[i + 1] - leftMin[i]);
        }
        
        return max;
    }
}
