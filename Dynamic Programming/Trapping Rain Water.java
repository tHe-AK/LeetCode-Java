public class Solution {
    public int trap(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        if (A.length < 3) {
            return 0;
        }
        
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = Integer.MIN_VALUE;
        right[len - 1] = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], A[i - 1]);
        }
        
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], A[i + 1]);
        }
        
        for (int i = 0; i < len; i++) {
            sum += Math.min(left[i], right[i]) > A[i] ? Math.min(left[i], right[i]) - A[i] : 0;
        }
        
        return sum;
    }
}