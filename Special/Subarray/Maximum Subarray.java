public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int max = A[0];
        int cur = A[0];
        
        for (int i = 1; i < A.length; i++) {
            cur = Math.max(cur + A[i], A[i]);
            max = Math.max(max, cur);
        }
        
        return max;
    }
}