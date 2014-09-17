public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int len = A.length;
        int cur = A[0];
        int[] left = new int[len];
        left[0] = cur;
        
        for (int i = 1; i < len; i++) {
            cur = Math.max(cur + A[i], A[i]);
            left[i] = Math.max(left[i - 1], cur);
        }
        
        cur = A[len - 1];
        int[] right = new int[len];
        right[len - 1] = cur;
        
        for (int i = len - 2; i >= 0; i--) {
            cur = Math.max(cur + A[i], A[i]);
            right[i] = Math.max(right[i + 1], cur);
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }
        
        return max;
    }
}
